package com.likelion.hospital.controller;

import com.likelion.hospital.dao.HospitalDao;
import com.likelion.hospital.domain.Hospital;
import com.likelion.hospital.domain.hospital.HospitalResDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {
    private final HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResDTO> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(HospitalResDTO.from(hospitalDao.findById(id)));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(hospitalDao.getCount());
    }

    @GetMapping("")
    public ResponseEntity<List<HospitalResDTO>> searchByAddress(@RequestParam("address") String address) {
        List<Hospital> hospitals = hospitalDao.searchByAddress(address);
        return ResponseEntity.ok(
            hospitals.stream().map(HospitalResDTO::from).collect(Collectors.toList())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
        hospitalDao.deleteById(id);
        return ResponseEntity.status(204).build(); // no contents
    }
}

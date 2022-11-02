package com.likelion.hospital.dao;

import com.likelion.hospital.domain.Hospital;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalDaoTest {
    @Autowired
    private HospitalDao dao;

    private Hospital hospital = Hospital.builder()
            .id(1)
            .openServiceName("의원")
            .openLocalGovernmentCode(3620000)
            .managementNumber("PHMA119993620020041100004")
            .licenseDate(LocalDateTime.of(1999, 6, 12, 0, 0, 0))
            .businessStatus(1)
            .businessStatusCode(13)
            .phone("062-515-2875")
            .fullAddress("광주광역시 북구 풍향동 565번지 4호 3층")
            .roadNameAddress("광주광역시 북구 동문대로 24, 3층 (풍향동)")
            .hospitalName("효치과의원")
            .businessTypeName("치과의원")
            .healthcareProviderCount(1)
            .patientRoomCount(1)
            .totalNumberOfBeds(0)
            .totalAreaSize(52.29F)
            .build();

    @BeforeEach
    void rollBack() {
//        dao.deleteAll();
    }

    @Test
    void insertAndFindById() {
//        dao.insert(hospital);
//        Hospital find = dao.findById(hospital.getId());
//
//        // then
//        assertEquals(hospital.getId(), find.getId());
//        assertEquals(hospital.getOpenServiceName(), find.getOpenServiceName());
//        assertEquals(hospital.getOpenLocalGovernmentCode(), find.getOpenLocalGovernmentCode());
//        assertEquals(hospital.getManagementNumber(), find.getManagementNumber());
//        assertEquals(hospital.getLicenseDate(), find.getLicenseDate());
//        assertEquals(hospital.getBusinessStatus(), find.getBusinessStatus());
//        assertEquals(hospital.getBusinessStatusCode(), find.getBusinessStatusCode());
//        assertEquals(hospital.getPhone(), find.getPhone());
//        assertEquals(hospital.getFullAddress(), find.getFullAddress());
//        assertEquals(hospital.getRoadNameAddress(), find.getRoadNameAddress());
//        assertEquals(hospital.getHospitalName(), find.getHospitalName());
//        assertEquals(hospital.getBusinessTypeName(), find.getBusinessTypeName());
//        assertEquals(hospital.getHealthcareProviderCount(), find.getHealthcareProviderCount());
//        assertEquals(hospital.getPatientRoomCount(), find.getPatientRoomCount());
//        assertEquals(hospital.getTotalNumberOfBeds(), find.getTotalNumberOfBeds());
//        assertEquals(hospital.getTotalAreaSize(), find.getTotalAreaSize());
    }

    @Test
    @DisplayName("카운트")
    void getCount() {
//        assertEquals(0, dao.getCount());
//        dao.insert(hospital);
//        assertEquals(1, dao.getCount());
    }
}
package com.likelion.hospital.dao;

import com.likelion.hospital.domain.Hospital;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalDao {
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Hospital> rowMapper = (rs, rowNum) ->
            new Hospital(Integer.valueOf(rs.getString("id")),
                    rs.getString("open_service_name"),
                    Integer.valueOf(rs.getString("open_local_government_code")),
                    rs.getString("management_number"),
                    rs.getTimestamp("license_date").toLocalDateTime(),
                    Integer.valueOf(rs.getString("business_status")),
                    Integer.valueOf(rs.getString("business_status_code")),
                    rs.getString("phone"),
                    rs.getString("full_address"),
                    rs.getString("road_name_address"),
                    rs.getString("hospital_name"),
                    rs.getString("business_type_name"),
                    Integer.valueOf(rs.getString("healthcare_provider_count")),
                    Integer.valueOf(rs.getString("patient_room_count")),
                    Integer.valueOf(rs.getString("total_number_of_beds")),
                    Float.valueOf(rs.getString("total_area_size")));

    public void insert(Hospital hospital) {
        try {
            jdbcTemplate.update(
                    "INSERT INTO nation_wide_hospitals" +
                            "(id, open_service_name, open_local_government_code," +
                            "management_number, license_date, business_status," +
                            "business_status_code, phone, full_address," +
                            "road_name_address, hospital_name, business_type_name," +
                            "healthcare_provider_count, patient_room_count, total_number_of_beds," +
                            "total_area_size)" +
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);",
                    hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode()
                    , hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus()
                    , hospital.getBusinessStatusCode() , hospital.getPhone(), hospital.getFullAddress()
                    , hospital.getRoadNameAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName()
                    , hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds()
                    , hospital.getTotalAreaSize());
        } catch (DataIntegrityViolationException e) {
            System.out.println(String.format("[%s] %s\n", e.getMessage(),  hospital));
        }
    }

    public Hospital findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM nation_wide_hospitals WHERE id = ? ", rowMapper,id);
    }

    public int getCount() {
        int count = 0;
        count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM nation_wide_hospitals", Integer.class);
        return count;
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM nation_wide_hospitals WHERE id = ?", id);
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM nation_wide_hospitals");
    }

    public List<Hospital> findAll() {
        return jdbcTemplate.query("SELECT * FROM nation_wide_hospitals", rowMapper);
    }

    public List<Hospital> searchByAddress(String address) {
        return jdbcTemplate.query("SELECT * FROM nation_wide_hospitals WHERE road_name_address LIKE ? LIMIT 10", rowMapper,"%" + address + "%");
    }
}

package com.likelion.hospital.domain.hospital;

import com.likelion.hospital.domain.Hospital;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

// 1병원 이름, 2주소, 3도로명주소, 4의료진 수, 5병상 수, 6면적
@Getter
public class HospitalResDTO {
    private String hospitalName;
    private String fullAddress;
    private String roadNameAddress;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private float totalAreaSize;
    private boolean shutDown;

    public static HospitalResDTO from(Hospital hospital) {
        HospitalResDTO dto = new HospitalResDTO();
        dto.hospitalName = hospital.getHospitalName();
        dto.fullAddress = hospital.getFullAddress();
        dto.roadNameAddress = hospital.getRoadNameAddress();
        dto.healthcareProviderCount = hospital.getHealthcareProviderCount();
        dto.patientRoomCount = hospital.getPatientRoomCount();
        dto.totalAreaSize = hospital.getTotalAreaSize();
        dto.shutDown = hospital.isShutDown();
        return dto;
    }
}

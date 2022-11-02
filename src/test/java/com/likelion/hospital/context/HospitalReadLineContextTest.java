package com.likelion.hospital.context;

import com.likelion.hospital.config.HospitalContextConfig;
import com.likelion.hospital.domain.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HospitalContextConfig.class)
class HospitalReadLineContextTest {
    @Autowired
    private ReadLineContext<Hospital> hospitalReadLineContext;

    @Test
    @DisplayName("데이터 불러오기")
    void readLine() throws IOException {
        List<Hospital> hospitals = hospitalReadLineContext.readByLine("fulldata.txt");
        assertTrue(hospitals.size() > 100_000);
    }
}
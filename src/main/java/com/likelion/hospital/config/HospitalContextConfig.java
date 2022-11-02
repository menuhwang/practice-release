package com.likelion.hospital.config;

import com.likelion.hospital.context.ReadLineContext;
import com.likelion.hospital.domain.Hospital;
import com.likelion.hospital.parser.HospitalParser;
import com.likelion.hospital.parser.Parser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HospitalContextConfig {
    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext(Parser<Hospital> parser) {
        return new ReadLineContext<>(parser);
    }

    @Bean
    public Parser<Hospital> hospitalParser() {
        return new HospitalParser();
    }
}

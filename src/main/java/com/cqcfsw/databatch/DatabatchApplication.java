package com.cqcfsw.databatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class DatabatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabatchApplication.class, args);

    }
}

package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student jack = new Student("Jame",
                    "jack@sparrow.com",
                    LocalDate.of(2000, Month.JANUARY, 25)
            );
            Student Jasm = new Student("Jasmine",
                    "jasmine@sparrow.com",
                    LocalDate.of(1999, Month.JANUARY, 25)
            );

            studentRepository.saveAll(List.of(jack, Jasm));
        };
    }
}

//package com.example.demo.student;
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.cglib.core.Local;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
//     return args -> {
//         Student samrat = new Student(
//                 "Samrat",
//                 "samrat@gmail.com",
//                 LocalDate.of(2001, Month.DECEMBER, 27)
//         );
//
//         Student karuna = new Student(
//                 "karuna",
//                 "karuna@gmail.com",
//                 LocalDate.of(2000, Month.FEBRUARY, 24)
//         );
//
//         studentRepository.saveAll(List.of(samrat,karuna));
//     };
//    }
//}

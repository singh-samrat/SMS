package com.example.demo.authentication;

import com.example.demo.student.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public ResponseEntity<String> authenticate(Student student) {
        Student student1 = loginRepository.findStudentByEmail(student.getEmail())
                .orElseThrow(()->new IllegalStateException("No student of such email exist"));
        System.out.println("OK");
        return ResponseEntity.ok("OK");
    }

    public String register(User user) {
        int month = switch (user.getMonth()) {
            case "January" -> 1;
            case "February" -> 2;
            case "March" -> 3;
            case "April" -> 4;
            case "May" -> 5;
            case "June" -> 6;
            case "July" -> 7;
            case "August" -> 8;
            case "September" -> 9;
            case "October" -> 10;
            case "November" -> 11;
            case "December" -> 12;
            default -> 0;
        };
        System.out.println(user.getDay());
        System.out.println(user.getMonth());
        System.out.println(user.getYear());
        Student student = new Student(user.getName(),user.getEmail(),user.getPassword(), LocalDate.of(user.getYear(), month, user.getDay()));
        Optional<Student> studentByEmail = loginRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            return "Email already taken!!";
        }
        loginRepository.save(student);
        return " Registration Successss";
    }
}

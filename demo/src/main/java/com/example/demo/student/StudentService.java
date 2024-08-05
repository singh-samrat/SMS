package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void postStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new IllegalStateException("No student of such ID");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Student student) {
        Long id = student.getId();
        Student student1 = studentRepository.findById(id)
                .orElseThrow(()->  new IllegalStateException("No student of such Id"));

        if(student.getName() != null && !student.getName().isEmpty() && !student.getName().equals(student1.getName())){
            student1.setName(student.getName());
        }

        if(student.getEmail() != null && !student.getEmail().isEmpty() && !student.getEmail().equals(student1.getEmail())){
            student1.setEmail(student.getEmail());
        }

    }
}

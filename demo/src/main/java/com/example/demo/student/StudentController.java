package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path= "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(path = "/get")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping(path = "/post")
    public void postStudent(@RequestBody Student student){
        studentService.postStudent(student);
    }

    @DeleteMapping(path ="/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path="/update")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }
}

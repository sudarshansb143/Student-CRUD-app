package com.example.demo.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "api/v1/students")
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @PostMapping(path = "api/v1/student/register")
    public void registerStudent (@RequestBody Student newStudent) {
        this.studentService.addNewStudent(newStudent);
    }

    @DeleteMapping(path= "api/v1/student/{studentId}")
    public void deleteStudent (@PathVariable("studentId")Long id){
        this.studentService.deleteStudent(id);
    }
    @PutMapping(path= "api/v1/student/{studentId}")
    public void updateStudentDetails (@PathVariable("studentId")Long id, @RequestBody Student updatedStudent) {
        this.studentService.updateStudent(id, updatedStudent);
    }

}

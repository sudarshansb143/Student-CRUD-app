package com.example.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student newStudent) {
        //Handle duplicate email
        Optional<Student> studentOption = this.studentRepository.findStudentByEmail(newStudent.getEmail());
        if (studentOption.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }
        this.studentRepository.save(newStudent);
    }

    public void deleteStudent(Long id){
        boolean isStudentExists = this.studentRepository.existsById(id);
        if (!isStudentExists) {
            throw new IllegalStateException("Student with id " + id + "does not exist !");
        }
        this.studentRepository.deleteById(id);
    }

   @Transactional
    public void updateStudent(Long id, Student updatedStudent) {
        boolean isStudentExists = this.studentRepository.existsById(id);
        if (!isStudentExists) {
            throw new IllegalStateException("Student with id " + id + "does not exist !");
        }
       Student oldStudent = this.studentRepository.getById(id);
        oldStudent.setName(updatedStudent.getName());
        oldStudent.setEmail(updatedStudent.getEmail());
    }
}

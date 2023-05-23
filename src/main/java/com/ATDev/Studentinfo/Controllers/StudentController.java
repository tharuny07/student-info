package com.ATDev.Studentinfo.Controllers;

import com.ATDev.Studentinfo.Dtos.StudentDto;
import com.ATDev.Studentinfo.Models.Student;
import com.ATDev.Studentinfo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody StudentDto studentDto){
        String response= studentService.addStudent(studentDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-student")
    public ResponseEntity<Student> getStudent(@RequestParam int rollNo){
             Student student=studentService.getStudent(rollNo);
             return new ResponseEntity<>(student,HttpStatus.FOUND);
    }

    @PutMapping("/change-name")
    public ResponseEntity<String> changeStudentName(@RequestParam int rollNo,@RequestParam String newName){
        String response=studentService.changeStudentName(rollNo, newName);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-student")
    public ResponseEntity<String> deleteStudent(@RequestParam int rollNo){
        String response= studentService.deleteStudent(rollNo);
        return new ResponseEntity<>(response,HttpStatus.GONE);
    }
}

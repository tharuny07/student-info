package com.ATDev.Studentinfo.Services;

import com.ATDev.Studentinfo.Dtos.StudentDto;
import com.ATDev.Studentinfo.Models.Student;
import com.ATDev.Studentinfo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(StudentDto studentDto){
        Student student=new Student();
        //set all the attributes of the student before saving it in the database
        student.setAge(studentDto.getAge());
        student.setGender(studentDto.getGender());
        student.setName(studentDto.getName());
        student.setCurrentClass(studentDto.getCurrentClass());
        student.setParentPhoneNo(studentDto.getParentPhoneNo());
        student.setRoll_No(studentDto.getRoll_No());

        studentRepository.save(student);
        return "Student added successfully";
    }

    public Student getStudent(int rollNo){
          Student student=studentRepository.findByRollNo(rollNo);
         return student;
    }

    public String changeStudentName(int rollNo,String newName) {
        Student student;
        try {
            student = studentRepository.findByRollNo(rollNo);
            if(student==null){
                return "Student is not there OR invalid rollNo";
            }
        } catch (Exception e) {
            return "Student is not there OR invalid rollNo";
        }
        student.setName(newName);//changing the name to new name
        studentRepository.save(student);//save works as both for saving and updating

        return "Student name successfully Updated";
    }

    public String deleteStudent(int rollNo){
        Student student;
        try{
            student=studentRepository.findByRollNo(rollNo);
            if(student==null){
                return "Student is not there OR invalid rollNo";
            }
        }
        catch(Exception e){
            return "Student not there with that rollNo";
        }
        studentRepository.delete(student);
        return "Student successfully deleted";
    }
}

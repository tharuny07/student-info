package com.ATDev.Studentinfo.Models;

import jakarta.persistence.*;


@Entity   //Telling the spring boot that it is an entity by using entity annotation
@Table(name = "students") //Giving the table a name
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int rollNo;
    private String currentClass;
    private String parentPhoneNo;
    private int age;
    private String gender;

    public Student() {
    }

    public Student(int id, String name, int roll_No, String currentClass, String parentPhoneNo, int age, String gender) {
        this.id = id;
        this.name = name;
        this.rollNo = roll_No;
        this.currentClass = currentClass;
        this.parentPhoneNo = parentPhoneNo;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll_No() {
        return rollNo;
    }

    public void setRoll_No(int roll_No) {
        this.rollNo = roll_No;
    }

    public String getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    public String getParentPhoneNo() {
        return parentPhoneNo;
    }

    public void setParentPhoneNo(String parentPhoneNo) {
        this.parentPhoneNo = parentPhoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

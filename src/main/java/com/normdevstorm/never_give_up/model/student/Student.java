package com.normdevstorm.never_give_up.model.student;

import jakarta.persistence.*;

import java.util.Date;

@Table
@Entity
public class Student {

    @Id
    private String id;

    @Column
    private  String name;

    @Column
    private  java.sql.Date dob;

    @Column
    private  int age;

    public Student(String id, String name, java.sql.Date dob, int age) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;
    }

    public Student() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

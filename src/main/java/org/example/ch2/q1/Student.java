package org.example.ch2.q1;

public class Student {
    private String id;
    private String name;
    private String gender;
    private String major;
    private String grade;

    public Student() {}

    public Student(String id, String name, String gender, String major, String grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.grade = grade;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "学号：" + id +
                " 姓名：" + name +
                " 性别：" + gender +
                " 专业：" + major +
                " 年级：" + grade;
    }
}
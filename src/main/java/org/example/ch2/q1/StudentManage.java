package org.example.ch2.q1;

import java.util.ArrayList;
import java.util.List;

public class StudentManage {
    private List<Student> studentList;

    public StudentManage() {
        studentList = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        for (Student s : studentList) {
            if (s.getId().equals(student.getId())) {
                return false;
            }
        }
        studentList.add(student);
        return true;
    }

    public boolean deleteStudent(String id) {
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                studentList.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(student.getId())) {
                studentList.set(i, student);
                return true;
            }
        }
        return false;
    }

    public Student findStudent(String id) {
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return studentList;
    }
}
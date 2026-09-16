package org.example.ch2.q8;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentManageMap {
    private Map<String, Student> studentMap;

    public StudentManageMap() {
        studentMap = new HashMap<>();
    }

    public boolean addStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            return false;
        }
        studentMap.put(student.getId(), student);
        return true;
    }

    public boolean deleteStudent(String id) {
        if (studentMap.containsKey(id)) {
            studentMap.remove(id);
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return true;
        }
        return false;
    }

    public Student findStudent(String id) {
        return studentMap.get(id);
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }
}
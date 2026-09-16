package org.example.ch3.q4;

import java.io.*;
import java.util.*;

public class StudentManageMap {
    private Map<String, Student> studentMap;
    private final String FILE_NAME = "student.info";

    public StudentManageMap() {
        studentMap = new HashMap<>();
        loadFromFile();
    }

    // 从文件加载数据
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            studentMap = (Map<String, Student>) ois.readObject();
        } catch (Exception e) {
            studentMap = new HashMap<>();
        }
    }

    // 保存到文件
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addStudent(Student student) {
        if (studentMap.containsKey(student.getId())) return false;
        studentMap.put(student.getId(), student);
        saveToFile();
        return true;
    }

    public boolean deleteStudent(String id) {
        if (!studentMap.containsKey(id)) return false;
        studentMap.remove(id);
        saveToFile();
        return true;
    }

    public boolean updateStudent(Student student) {
        if (!studentMap.containsKey(student.getId())) return false;
        studentMap.put(student.getId(), student);
        saveToFile();
        return true;
    }

    public Student findStudent(String id) {
        return studentMap.get(id);
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }
}
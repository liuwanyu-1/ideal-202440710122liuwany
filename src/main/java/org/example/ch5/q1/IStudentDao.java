package org.example.ch5.q1;

import java.util.List;

public interface IStudentDao {
    boolean add(Student student);

    boolean remove(String id);


    boolean modify(Student student);

    Student getStudentById(String id);

    List<Student> getAll();
}

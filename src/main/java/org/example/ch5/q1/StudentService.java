package org.example.ch5.q1;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentDao studentDao = new StudentDao();

    @Override
    public boolean add(Student student) {
        if (student == null || student.getId() == null || student.getId().length() == 0) {
            return false;
        }
        return studentDao.add(student);
    }

    @Override
    public boolean remove(String id) {
        return studentDao.remove(id);
    }

    @Override
    public boolean modify(Student student) {
        return studentDao.modify(student);
    }

    @Override
    public Student getStudentById(String id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }
}

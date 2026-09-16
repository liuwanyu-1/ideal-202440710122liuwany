package org.example.ch5.q1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao {
    @Override
    public boolean add(Student student) {
        String sql = "insert into student(id,name,gender,major,grade) values(?,?,?,?,?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getMajor());
            ps.setString(5, student.getGrade());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(String id) {
        String sql = "delete from student where id=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modify(Student student) {
        String sql = "update student set name=?,gender=?,major=?,grade=? where id=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getGender());
            ps.setString(3, student.getMajor());
            ps.setString(4, student.getGrade());
            ps.setString(5, student.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student getStudentById(String id) {
        String sql = "select * from student where id=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return toStudent(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = new ArrayList<Student>();
        String sql = "select * from student order by id";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(toStudent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Student toStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getString("id"));
        student.setName(rs.getString("name"));
        student.setGender(rs.getString("gender"));
        student.setMajor(rs.getString("major"));
        student.setGrade(rs.getString("grade"));
        return student;
    }
}

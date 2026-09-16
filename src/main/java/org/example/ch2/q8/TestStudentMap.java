package org.example.ch2.q8;

import java.util.Collection;
import java.util.Scanner;

public class TestStudentMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManageMap manage = new StudentManageMap();

        while (true) {
            System.out.println("=====学生信息管理系统(Map版)=====");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.显示所有学生");
            System.out.println("0.退出系统");
            System.out.print("请选择功能：");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("请输入学号：");
                    String id = sc.nextLine();
                    System.out.print("请输入姓名：");
                    String name = sc.nextLine();
                    System.out.print("请输入性别：");
                    String gender = sc.nextLine();
                    System.out.print("请输入专业：");
                    String major = sc.nextLine();
                    System.out.print("请输入年级：");
                    String grade = sc.nextLine();

                    Student stu = new Student(id, name, gender, major, grade);
                    boolean add = manage.addStudent(stu);
                    if (add) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("学号重复，添加失败");
                    }
                    break;

                case 2:
                    System.out.print("请输入要删除的学号：");
                    String delId = sc.nextLine();
                    boolean del = manage.deleteStudent(delId);
                    if (del) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("未找到该学生");
                    }
                    break;

                case 3:
                    System.out.print("请输入要修改的学号：");
                    String upId = sc.nextLine();
                    Student upStu = manage.findStudent(upId);
                    if (upStu == null) {
                        System.out.println("未找到学生");
                        break;
                    }
                    System.out.print("请输入新姓名：");
                    upStu.setName(sc.nextLine());
                    System.out.print("请输入新性别：");
                    upStu.setGender(sc.nextLine());
                    System.out.print("请输入新专业：");
                    upStu.setMajor(sc.nextLine());
                    System.out.print("请输入新年级：");
                    upStu.setGrade(sc.nextLine());
                    manage.updateStudent(upStu);
                    System.out.println("修改成功");
                    break;

                case 4:
                    System.out.print("请输入要查询的学号：");
                    String findId = sc.nextLine();
                    Student find = manage.findStudent(findId);
                    if (find == null) {
                        System.out.println("未找到");
                    } else {
                        System.out.println(find);
                    }
                    break;

                case 5:
                    Collection<Student> list = manage.getAllStudents();
                    if (list.isEmpty()) {
                        System.out.println("暂无学生");
                        break;
                    }
                    for (Student s : list) {
                        System.out.println(s);
                    }
                    break;

                case 0:
                    System.out.println("退出系统");
                    sc.close();
                    return;

                default:
                    System.out.println("输入错误");
            }
        }
    }
}
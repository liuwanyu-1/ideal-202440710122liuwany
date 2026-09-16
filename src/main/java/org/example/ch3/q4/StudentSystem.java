package org.example.ch3.q4;

import java.util.Collection;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManageMap manage = new StudentManageMap();

        System.out.println("===== 学生信息管理系统（持久化版）=====");

        while (true) {
            System.out.println("\n1.添加学生  2.删除学生  3.修改学生  4.查询学生  5.显示所有  0.退出");
            System.out.print("请选择：");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("学号：");
                    String id = sc.nextLine();
                    System.out.print("姓名：");
                    String name = sc.nextLine();
                    System.out.print("性别：");
                    String gender = sc.nextLine();
                    System.out.print("专业：");
                    String major = sc.nextLine();
                    System.out.print("年级：");
                    String grade = sc.nextLine();

                    Student stu = new Student(id, name, gender, major, grade);
                    System.out.println(manage.addStudent(stu) ? "添加成功" : "学号重复");
                    break;

                case 2:
                    System.out.print("输入要删除的学号：");
                    String delId = sc.nextLine();
                    System.out.println(manage.deleteStudent(delId) ? "删除成功" : "未找到");
                    break;

                case 3:
                    System.out.print("输入要修改的学号：");
                    String upId = sc.nextLine();
                    Student upStu = manage.findStudent(upId);
                    if (upStu == null) {
                        System.out.println("未找到");
                        break;
                    }
                    System.out.print("新姓名：");
                    upStu.setName(sc.nextLine());
                    System.out.print("新性别：");
                    upStu.setGender(sc.nextLine());
                    System.out.print("新专业：");
                    upStu.setMajor(sc.nextLine());
                    System.out.print("新年级：");
                    upStu.setGrade(sc.nextLine());
                    manage.updateStudent(upStu);
                    System.out.println("修改成功");
                    break;

                case 4:
                    System.out.print("输入查询学号：");
                    Student find = manage.findStudent(sc.nextLine());
                    System.out.println(find == null ? "未找到" : find);
                    break;

                case 5:
                    Collection<Student> list = manage.getAllStudents();
                    if (list.isEmpty()) {
                        System.out.println("暂无学生");
                        break;
                    }
                    for (Student s : list) System.out.println(s);
                    break;

                case 0:
                    System.out.println("系统退出，数据已保存");
                    sc.close();
                    return;

                default:
                    System.out.println("输入错误");
            }
        }
    }
}
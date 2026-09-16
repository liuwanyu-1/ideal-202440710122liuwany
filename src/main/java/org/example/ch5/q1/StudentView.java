package org.example.ch5.q1;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IStudentService service = new StudentService();

        while (true) {
            System.out.println("\n===== 学生信息管理系统(MySQL版) =====");
            System.out.println("1.添加  2.删除  3.修改  4.查询  5.显示全部  0.退出");
            System.out.print("请选择：");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    Student addStudent = inputStudent(scanner);
                    System.out.println(service.add(addStudent) ? "添加成功" : "添加失败");
                    break;
                case 2:
                    System.out.print("请输入学号：");
                    System.out.println(service.remove(scanner.nextLine()) ? "删除成功" : "删除失败");
                    break;
                case 3:
                    Student updateStudent = inputStudent(scanner);
                    System.out.println(service.modify(updateStudent) ? "修改成功" : "修改失败");
                    break;
                case 4:
                    System.out.print("请输入学号：");
                    Student student = service.getStudentById(scanner.nextLine());
                    System.out.println(student == null ? "没有找到" : student);
                    break;
                case 5:
                    List<Student> list = service.getAll();
                    for (Student s : list) {
                        System.out.println(s);
                    }
                    break;
                default:
                    System.out.println("输入错误");
            }
        }

        scanner.close();
    }

    private static Student inputStudent(Scanner scanner) {
        System.out.print("学号：");
        String id = scanner.nextLine();
        System.out.print("姓名：");
        String name = scanner.nextLine();
        System.out.print("性别：");
        String gender = scanner.nextLine();
        System.out.print("专业：");
        String major = scanner.nextLine();
        System.out.print("年级：");
        String grade = scanner.nextLine();
        return new Student(id, name, gender, major, grade);
    }
}

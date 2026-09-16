package org.example.ch1.q6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Student[] stuArr=new Student[20];

        for(int i=0;i<stuArr.length;i++){
            Student stu=new Student();
            System.out.println("请输入第"+(i+1)+"个学生信息：");
            String sid;
            while(true){
                System.out.print("学号(11位数字)：");
                sid=sc.next();
                if(stu.checkId(sid)){
                    stu.setId(sid);
                    break;
                }
                System.out.println("学号格式错误！");
            }

            String sname;
            while(true){
                System.out.print("姓名(至少2个汉字)：");
                sname=sc.next();
                if(stu.checkName(sname)){
                    stu.setName(sname);
                    break;
                }
                System.out.println("姓名格式错误！");
            }

            String sgender;
            while(true){
                System.out.print("性别(男/女)：");
                sgender=sc.next();
                if(stu.checkGender(sgender)){
                    stu.setGender(sgender);
                    break;
                }
                System.out.println("性别格式错误！");
            }

            int sage;
            while(true){
                System.out.print("年龄(18-45)：");
                sage=sc.nextInt();
                if(stu.checkAge(sage)){
                    stu.setAge(sage);
                    break;
                }
                System.out.println("年龄范围错误！");
            }

            String smajor;
            while(true){
                System.out.print("专业(至少3个汉字)：");
                smajor=sc.next();
                if(stu.checkMajor(smajor)){
                    stu.setMajor(smajor);
                    break;
                }
                System.out.println("专业格式错误！");
            }
            stuArr[i]=stu;
        }

        System.out.println("==========按学号自然升序==========");
        Arrays.sort(stuArr);
        for(Student s:stuArr){
            System.out.println(s);
        }

        System.out.println("=======按专业+学号升序排序=======");
        Arrays.sort(stuArr,new Comparator<Student>(){
            @Override
            public int compare(Student o1,Student o2){
                int res=o1.getMajor().compareTo(o2.getMajor());
                if(res==0){
                    res=o1.getId().compareTo(o2.getId());
                }
                return res;
            }
        });
        for(Student s:stuArr){
            System.out.println(s);
        }
        sc.close();
    }
}
package org.example.ch1.q6;

public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private String gender;
    private int age;
    private String major;

    public Student(){}

    public Student(String id,String name,String gender,int age,String major){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.major=major;
    }

    public boolean checkId(String id){
        return id.matches("\\d{11}");
    }

    public boolean checkName(String name){
        return name.matches("[\\u4e00-\\u9fa5]{2,}");
    }

    public boolean checkGender(String gender){
        return "男".equals(gender)||"女".equals(gender);
    }

    public boolean checkAge(int age){
        return age>=18&&age<=45;
    }

    public boolean checkMajor(String major){
        return major.matches("[\\u4e00-\\u9fa5]{3,}");
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getMajor(){
        return major;
    }
    public void setMajor(String major){
        this.major=major;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null||getClass()!=o.getClass()) return false;
        Student student=(Student)o;
        return id.equals(student.id)&&name.equals(student.name);
    }

    @Override
    public int compareTo(Student s){
        return this.id.compareTo(s.id);
    }

    @Override
    public String toString(){
        return "学号："+id+" 姓名："+name+" 性别："+gender+" 年龄："+age+" 专业："+major;
    }
}
package ch02;

public class Student {
    // 学号
    private int stuNo;

    // 姓名
    private String name;

    // 性别
    private String sex;

    // 年龄
    private int age;

    public Student(int stuNo, String name, String sex, int age) {
        this.stuNo = stuNo;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void display() {
        System.out.println("学号:" + stuNo + ",姓名:" + name
                + ",性别:" + sex + ",年龄:" + age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }


}

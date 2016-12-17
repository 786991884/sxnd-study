package day01;

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Reftest {
    private static void refChg(Student stu) {
        stu.name = "王五";
        stu.age = 10;
    }

    public static void main(String[] args) {
        Student stu1 = new Student("张三", 23);
        Student stu2 = stu1;
        refChg(stu2);
        System.out.println(stu1.name + " , " + stu1.age);
    }
}

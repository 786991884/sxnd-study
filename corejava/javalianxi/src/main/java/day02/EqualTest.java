package day02;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 比较方法，只有姓名和年龄都相等才相等
    public boolean equals(Object obj) {
        Student stu = (Student) obj;
        return this.name.equals(stu.name) && this.age == stu.age;
    }
}

public class EqualTest {
    public static void main(String[] args) {
        // 比较两个学生对象是否相等
        Student stu1 = new Student("张三", 10);
        Student stu2 = new Student("张三", 10);
        System.out.println(stu1.equals(stu2));
    }
}

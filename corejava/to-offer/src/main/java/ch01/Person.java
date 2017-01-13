package ch01;

public class Person {
    // 用户姓名
    private String name;

    // 用户年龄
    private int age;

    // 用户性别
    private String sex;

    public Person(String name, int age, String sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public void display() {
        System.out.print("姓名:" + this.name);
        System.out.print(".年龄:" + this.age);
        System.out.print(".性别:" + this.sex);
        System.out.println();
    }

}

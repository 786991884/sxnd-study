package day02;

//动物类
class Animal {
    void breath() {// 呼吸
        System.out.println("Breath...");
    }

    void cry() {// 叫
        System.out.println("cry...");
    }
}

// 猫类,继承自动物类
class Cat extends Animal {
    void cry() {// 覆盖cry()方法
        System.out.println("苗...");
    }
}

public class ExtendTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        animal.breath();
        animal.cry();
        cat.breath();
        cat.cry();
    }
}

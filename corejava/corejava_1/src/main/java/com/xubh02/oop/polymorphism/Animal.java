package com.xubh02.oop.polymorphism;

public class Animal {
    String str;

    public void voice() {
        System.out.println("普通动物叫声！");
    }
}

class Cat extends Animal {
    public void voice() {
        System.out.println("喵喵喵");
    }

    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}

class Dog extends Animal {
    public void voice() {
        System.out.println("汪汪汪");
    }

    public void seeDoor() {
        System.out.println("看门！");
    }

}

class Tiger extends Animal {
    public void voice() {
        System.out.println("哇哇哇");
    }


}

class Pig extends Animal {
    public void voice() {
        System.out.println("哼哼哼");
    }
}

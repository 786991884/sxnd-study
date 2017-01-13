package ch01;

public class TestPersonArray {

    public static void main(String[] args) {
        PersonArray pa = new PersonArray();

        //创建对象
        Person p1 = new Person("张三", 20, "男");
        Person p2 = new Person("李四", 21, "男");
        Person p3 = new Person("王五", 22, "女");
        Person p4 = new Person("赵六", 23, "男");
        Person p5 = new Person("李斯", 24, "男");

        // 插入操作
        pa.insert(p1);
        pa.insert(p2);
        pa.insert(p3);
        pa.insert(p4);
        pa.insert(p5);

        pa.display();

        // 删除操作
        pa.delete(p4);
        pa.display();

        pa.delete("李斯");
        pa.display();

        //修改操作
        Person newPerson = new Person("历风行", 40, "男");
        pa.change(p1, newPerson);
        pa.display();
    }

}

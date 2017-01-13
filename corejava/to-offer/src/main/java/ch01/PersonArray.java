package ch01;

public class PersonArray {
    // 数组
    private Person[] arr;

    // 数组中有效数据的大小
    private int elems;

    //默认构造函数
    public PersonArray() {
        arr = new Person[50];
    }

    public PersonArray(int max) {
        arr = new Person[max];
    }

    // 插入数据
    public void insert(Person person) {
        arr[elems] = person;
        elems++;
    }

    // 显示数据
    public void display() {
        for (int i = 0; i < elems; i++) {
            arr[i].display();
        }
        System.out.println();
    }

    // 查找数据
    public int find(String name) {
        int i;
        for (i = 0; i < elems; i++) {
            if (name.equals(arr[i].getName())) {
                break;
            }
        }

        if (i == arr.length) {
            return -1;
        } else {
            return i;
        }
    }

    // 删除数据
    public void delete(Person person) {

        if (find(person.getName()) == -1) {
            System.out.println("查找不到指定数据，删除失败");
        } else {
            for (int i = find(person.getName()); i < elems; i++) {
                arr[i] = arr[i + 1];
            }
        }
        elems--;
    }

    //	 删除数据
    public void delete(String name) {

        if (find(name) == -1) {
            System.out.println("查找不到指定数据，删除失败");
        } else {
            for (int i = find(name); i < elems; i++) {
                arr[i] = arr[i + 1];
            }
        }
        elems--;
    }

    // 修改数据
    public void change(Person oldPerson, Person newPerson) {
        if (find(oldPerson.getName()) == -1) {
            System.out.println("查找不到指定数据，修改失败");
        } else {
            arr[find(oldPerson.getName())] = newPerson;
        }
    }
}

package day05;

import java.util.HashSet;

//定义狗类
class Dog {
	private String name;// 名字
	private int age;// 年龄
	// 用于对象的对象池
	public static HashSet<Dog> pool = new HashSet<Dog>();

	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 使用对象池来得到对象的方法
	public static Dog newInstance(String name, int age) {
		// 循环遍历对象池
		for (Dog dog : pool) {
			if (dog.name.equals(name) && dog.age == age) {
				return dog;
			}
		}
		// 如果找不到值相同的Dog对象，则创建一个Dog对象
		// 并把它加到对象池中然后返回该对象
		Dog dog = new Dog(name, age);
		pool.add(dog);
		return dog;
	}
}

public class StringPoolTest {
	public static void main(String[] args) {
		// 对象池中取
		Dog dog1 = Dog.newInstance("lele", 30);
		Dog dog2 = Dog.newInstance("lele", 30);
		// 重新创建，所以dog1!=dog3
		Dog dog3 = new Dog("lele", 30);
		System.out.println(dog1 == dog2);
		System.out.println(dog1 == dog3);
	}
}

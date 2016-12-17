package day12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MethodTestClass {
	public void m1() {// 测试方法1
		System.out.println("m1 is called...");
	}

	public void m2() {// 测试方法2
		System.out.println("m2 is called...");
	}
}

public class CallMethodTest {
	public static void main(String[] args) {
		// 得到方法名参数
		String methodName = args[0];
		if (methodName != null) {
			// 得到class实例
			Class<MethodTestClass> clazz = MethodTestClass.class;

			try {
				// 获得指定方法名的method对象
				Method m = clazz.getDeclaredMethod(methodName);
				if (m != null) {
					// 创建一个新对象
					MethodTestClass obj = clazz.newInstance();
					m.invoke(obj);// 调用obj对象的指定方法
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}

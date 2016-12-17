package action;

import com.opensymphony.xwork2.ActionSupport;

public class MethodAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String method1() {
		System.out.println("MethodAction.method1()方法执行");
		return ActionSupport.SUCCESS;
	}

	public String method2() {
		System.out.println("MethodAction.method2()方法执行");
		return ActionSupport.SUCCESS;
	}

	public String method3() {
		System.out.println("MethodAction.method3()方法执行");
		return ActionSupport.SUCCESS;
	}

	public String method4() {
		System.out.println("MethodAction.method4()方法执行");
		return ActionSupport.SUCCESS;
	}
}

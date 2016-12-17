package com.xubh02.exception.test;


import java.io.FileNotFoundException;
import java.io.IOException;

public class A {
    public void method() throws IOException {
    }
}

class B extends A {
    public void method() throws FileNotFoundException {
    }
}

class C extends A {
    public void method() {
    }
}

//	class D extends A {		public void method() throws Exception {	}     //超过父类异常的范围，会报错！
//	}

class E extends A {
    public void method() throws IOException, FileNotFoundException {
    }
}

class F extends A {
    public void method() throws IOException, ArithmeticException {
    }
}
//	class G extends A {		public void method() throws IOException, ParseException {	}
//	}



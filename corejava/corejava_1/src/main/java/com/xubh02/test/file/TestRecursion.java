package com.xubh02.test.file;

/**
 * 测试递归算法
 */
public class TestRecursion {

    long test(long n) {
        if (n == 1) {
            return 1;
        } else {
            return n * test(n - 1);
        }
    }

    public static void main(String[] args) {
        long d1 = System.currentTimeMillis();
        System.out.println(new TestRecursion().test(20));
        long d2 = System.currentTimeMillis();
        System.out.println(d2 - d1);

        //5*4*3*2*1
        int i = 5;
        int result = 1;
        while (i > 1) {
            result *= i * (i - 1);
            i -= 2;
        }
        System.out.println("结果是：" + result + "最后i=" + i);
        System.out.printf("结果是：%d最后i=%d，字符串：%s", result, i, "uuuuu");

    }
}

package day04;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        System.out.println(0.05 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);
        BigDecimal v1 = new BigDecimal(Double.toString(0.05));
        BigDecimal v2 = BigDecimal.valueOf(0.01);
        double a = add(0.05, 0.01);
        System.out.println(a);
    }

    // 提供精确加法计算的add方法
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        // 返回计算好以后的值
        return b1.add(b2).doubleValue();
    }
}

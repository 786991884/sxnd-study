package day01;

public class AutoBoxDemo {
    public static void main(String[] args) {
        Integer data1 = 10;
        Integer data2 = 20;
        // 转为double值再除以3
        System.out.println(data1.doubleValue() / 3);
        // 进行两个值的比较
        System.out.println(data1.compareTo(data2));
        // 自动装箱
        Integer fooIngeter = 10;
        int fooPrimitive = fooIngeter;
        // 运算时的自动装箱与自动拆箱
        Integer i = 10;
        System.out.println(i + 10);
        System.out.println(i++);
    }
}

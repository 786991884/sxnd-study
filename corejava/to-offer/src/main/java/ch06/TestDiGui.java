package ch06;

public class TestDiGui {

    public static void main(String[] args) {
        TestDiGui.test(0);
    }

    public static void test(int i) {
        if (i < 100) {
            System.out.println("Hello, World" + i);
            test(++i);
            System.out.println("Hello, Java" + i);
            System.out.println("Hello, Html" + i);
        }
    }

}

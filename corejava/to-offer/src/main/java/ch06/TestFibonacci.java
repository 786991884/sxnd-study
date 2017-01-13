package ch06;

public class TestFibonacci {

    public static void main(String[] args) {
        System.out.println(Fibonacci(1));
        System.out.println(Fibonacci(2));
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(4));
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci(6));
    }

    public static int Fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

}

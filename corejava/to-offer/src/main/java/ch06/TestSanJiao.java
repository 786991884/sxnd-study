package ch06;

public class TestSanJiao {

    public static void main(String[] args) {
        System.out.println(SanJiao(1));
        System.out.println(SanJiao(2));
        System.out.println(SanJiao(3));
        System.out.println(SanJiao(4));

        System.out.println(SanJiaoDiGui(1));
        System.out.println(SanJiaoDiGui(2));
        System.out.println(SanJiaoDiGui(3));
        System.out.println(SanJiaoDiGui(4));
    }

    public static int SanJiao(int n) {
        int total = 0;
        while (n > 0) {
            total = total + n;
            n--;
        }
        return total;
    }

    public static int SanJiaoDiGui(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + SanJiaoDiGui(--n);
        }
    }
}

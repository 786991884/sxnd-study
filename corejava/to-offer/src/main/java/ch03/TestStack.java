package ch03;

public class TestStack {

    public static void main(String[] args) {
        MyStack ms = new MyStack(10);
        ms.push(40);
        ms.push(30);
        ms.push(20);
        ms.push(10);
        ms.push(-10);
        ms.push(-20);

        while (!ms.isEmpty()) {
            System.out.println(ms.pop());
        }
    }

}

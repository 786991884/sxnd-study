package ch04;

public class TestQueue {

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        System.out.println(queue.isEmpty());

        queue.insert(50);
        queue.insert(20);
        queue.insert(10);
        queue.insert(2);
        queue.insert(1);

        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        queue.insert(10);
    }

}

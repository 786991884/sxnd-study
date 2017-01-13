package ch04;

public class TestPQ {

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(30);
        pq.insert(45);
        pq.insert(15);
        pq.insert(2);
        pq.insert(1);

        while (!pq.isEmpty()) {
            long value = pq.remove();
            System.out.print(value + " ");
        }

    }

}

package ch01;

public class TestMyOrderedArray {

    public static void main(String[] args) {
        MyOrderedArray moa = new MyOrderedArray();
        moa.insert(1);
        moa.insert(787);
        moa.insert(123);
        moa.insert(45);
        moa.insert(4);

        moa.display();

        System.out.println(moa.find(123));
        System.out.println(moa.binaryFind(123));
    }

}

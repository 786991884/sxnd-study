package ch01;

public class TestMyArray {

    public static void main(String[] args) {
        MyArray myArray = new MyArray();

        myArray.insert(20);
        myArray.insert(545);
        myArray.insert(3);
        myArray.insert(545);
        myArray.insert(6565);

        myArray.display();

        System.out.println(myArray.find(3));

        myArray.delete(3);
        myArray.display();

        myArray.change(545, 778);
        myArray.display();
    }

}

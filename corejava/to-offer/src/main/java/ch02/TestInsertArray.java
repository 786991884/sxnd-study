package ch02;

public class TestInsertArray {
    public static void main(String[] args) {
        InsertArray iArr = new InsertArray();
        iArr.insert(85);
        iArr.insert(7856);
        iArr.insert(12);
        iArr.insert(8);
        iArr.insert(5);
        iArr.insert(56);

        iArr.display();
        iArr.insertSort();
        iArr.display();
    }

}

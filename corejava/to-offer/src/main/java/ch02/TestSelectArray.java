package ch02;

public class TestSelectArray {

    public static void main(String[] args) {
        SelectArray sArr = new SelectArray();
        sArr.insert(89);
        sArr.insert(54);
        sArr.insert(667);
        sArr.insert(7);
        sArr.insert(12);
        sArr.insert(43);
        sArr.insert(12);

        sArr.display();
        sArr.selectSort();
        sArr.display();

    }

}

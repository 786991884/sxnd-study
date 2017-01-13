package ch07;

public class TestTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(80, 80);
        tree.insert(49, 49);
        tree.insert(42, 42);
        tree.insert(30, 30);
        tree.insert(45, 45);
        tree.insert(90, 90);
        tree.insert(150, 150);
        tree.insert(130, 130);
        tree.insert(82, 82);

        tree.endOrder(tree.getRoot());


    }

}

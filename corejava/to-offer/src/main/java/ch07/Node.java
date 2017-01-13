package ch07;

public class Node {
    // 关键字
    private int keyData;

    // 其他数据
    private int otherData;

    // 左子节点
    private Node leftNode;

    // 右子节点
    private Node rightNode;

    public Node(int keyData, int otherDate) {
        this.keyData = keyData;
        this.otherData = otherDate;
    }


    public int getKeyData() {
        return keyData;
    }


    public void setKeyData(int keyData) {
        this.keyData = keyData;
    }


    public Node getLeftNode() {
        return leftNode;
    }


    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }


    public int getOtherData() {
        return otherData;
    }


    public void setOtherData(int otherData) {
        this.otherData = otherData;
    }


    public Node getRightNode() {
        return rightNode;
    }


    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }


    // 显示方法
    public void display() {
        System.out.println(keyData + "," + otherData);
    }


}

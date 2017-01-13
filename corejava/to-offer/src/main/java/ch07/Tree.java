package ch07;

public class Tree {
    // 根
    private Node root;

    // 插入方法
    public void insert(int keyData, int otherData) {
        Node newNode = new Node(keyData, otherData);

        // 如果说没有节点
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (keyData < current.getKeyData()) {
                    current = current.getLeftNode();
                    if (current == null) {
                        parent.setLeftNode(newNode);
                        return;
                    }
                } else {
                    current = current.getRightNode();
                    if (current == null) {
                        parent.setRightNode(newNode);
                        return;
                    }
                }
            }
        }
    }

    // 查找方法
    public Node find(int keyData) {
        Node current = root;
        while (current.getKeyData() != keyData) {
            if (keyData < current.getKeyData()) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    // 修改方法
    public void change(int keyData, int newOtherData) {
        Node findNode = find(keyData);
        findNode.setOtherData(newOtherData);
    }

    // 先序遍历
    public void preOrder(Node node) {
        if (node != null) {
            node.display();
            preOrder(node.getLeftNode());
            preOrder(node.getRightNode());
        }
    }

    // 中序遍历
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeftNode());
            node.display();
            inOrder(node.getRightNode());
        }
    }

    // 后序遍历
    public void endOrder(Node node) {
        if (node != null) {
            endOrder(node.getLeftNode());
            endOrder(node.getRightNode());
            node.display();
        }
    }

    public Node getRoot() {
        return root;
    }
}

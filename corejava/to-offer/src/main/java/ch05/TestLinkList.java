package ch05;

public class TestLinkList {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();

        linkList.insert(40);
        linkList.insert(12);
        linkList.insert(23);
        linkList.insert(10);

        linkList.displayAll();
        System.out.println("找到结点，数据为 " + linkList.find(23).getData());

        linkList.insert(20, 0);
        System.out.println("-----------------------");
        linkList.displayAll();

        linkList.delete(12);
        System.out.println("-----------------------");
        linkList.displayAll();
    }

}

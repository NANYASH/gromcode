package algorithms;


public class Demo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(4);

        myLinkedList.getAll();
        System.out.println(myLinkedList.head.val);
        System.out.println(myLinkedList.tail.val);




    }
}

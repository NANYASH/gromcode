package algorithms;


public class Demo {
    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        System.out.println(linkedList.get(0));
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        linkedList.addAtIndex(0,1);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        /*linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList.get(1));
*/
        //myLinkedList.getAll();
        //System.out.println(myLinkedList.head.val);
        //System.out.println(myLinkedList.tail.val);




    }
}

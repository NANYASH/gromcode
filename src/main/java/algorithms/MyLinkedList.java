package algorithms;

class MyLinkedList {
    SinglyListNode head;
    SinglyListNode tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int i = 0;
        SinglyListNode current = head;
        while (i != index && current.next != null) {
            current = current.next;
            i++;
        }
        if (i == index && current != null)
            return current.val;
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        SinglyListNode singlyListNode = new SinglyListNode(val);
        if (head == null) {
            head = singlyListNode;
            tail = singlyListNode;
            return;
        }
        singlyListNode.next = head;
        head = singlyListNode;

    }


    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        SinglyListNode singlyListNode = new SinglyListNode(val);
        if (head == null) {
            head = singlyListNode;
            tail = singlyListNode;
            return;
        }
        SinglyListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = singlyListNode;
        tail = singlyListNode;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        int i = 0;
        SinglyListNode newNode = new SinglyListNode(val);
        SinglyListNode prev = head;
        SinglyListNode current = head;
        while (i != index && current.next != null) {
            prev = current;
            current = current.next;
            i++;
        }
        if (i == index && current!=null) {
            newNode.next = current;
            prev.next = newNode;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        int i = 0;
        SinglyListNode prev = head;
        SinglyListNode current = head;
        while (i != index && current.next != null) {
            prev = current;
            current = current.next;
            i++;
        }
        if (i == index) {
            prev.next = current.next;
        }

    }




}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
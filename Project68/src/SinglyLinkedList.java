import sun.security.util.Length;

import java.util.List;

/**
 *    //03-25.
 */

// tjdals9745
// edit from work PC


public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode{

        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(ListNode head){
        if(head == null) return;
        ListNode currentNode = head;

        while(currentNode != null){
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }

        System.out.println(currentNode);
    }

    public int length(ListNode head){
        int size  = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public ListNode insertAtPosition(ListNode head, int data, int position){
        //ListNode currentNode = null;
        //ListNode prevNode = null;
        int size = length(head);

        if(position < 1 || position > size + 1){
            System.out.println("invalid position. insert 1 from  " + (size+1));
            return head;
        }

        ListNode nodeToInsert = new ListNode(data);

        if(position == 1) {
            nodeToInsert.next = head;
            return nodeToInsert;
        }else {
            ListNode prevNode = head;
            for (int i = 1; i < position-1; i++) {
                prevNode = prevNode.next;
            }
            ListNode currNode = prevNode.next;
            prevNode.next = nodeToInsert;
            nodeToInsert.next = currNode;
        }

        if(head == null){
            System.out.println("Empty List, position doesn't matter");
            return head;

        }
        this.head = head;
        return head;
    }

    /**
     *
     *
     * @param head
     * @return deletedNode
     */
    public ListNode deleteAtBeg(ListNode head){
        if(head == null) return head;

        ListNode tmp = head;
        head = head.next;
        tmp.next = null;

        return tmp;
    }

    public ListNode deleteLast(ListNode head){
        if(head == null) return null;
/*        ListNode prevNode = head;
        int size = length(head);
        for(int i = 1; i < size -1; i++){
            prevNode = prevNode.next;
        }
        //ListNode currentNode = prevNode.next;
        prevNode.next = null;
        return prevNode;*/

        ListNode prevToLast = null;
        ListNode last = head;

        while(last.next != null){
            prevToLast = last;
            last = last.next;
        }

        prevToLast.next = null;
        return last;
    }

    ListNode deleteAtPosition(ListNode head, int position) {
        if (head == null) return head;

        int size = length(head);

        if (position < 1 || position > size) {
            System.out.println("Invalid position");
        }

        if (position == 1) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
            return tmp;
        } else {
            ListNode prevNode = head;
            for (int i = 1; i < position - 1; i++) {
                prevNode = prevNode.next;
            }
            ListNode currNode = prevNode.next;
            //ListNode nextNode = currNode.next;

            prevNode.next = currNode.next;
            currNode.next = null;

            return currNode;
        }
    }

    public ListNode searchAtFirst(ListNode head, int data){
        ListNode curNode = head;

        if(head == null){
            return null;

        }
        while(curNode != null){
            if(curNode.data == data){
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public ListNode reverseList (ListNode head){
        if(head == null){
            return head;
        }

        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode;

        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;

        }
        return prevNode;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(11);

        //attach Nodes

        head.next = second;
        second.next = third;
        third.next = fourth;


        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        head = singlyLinkedList.insertAtPosition(head, 21, 1);
        head = singlyLinkedList.insertAtPosition(head, 42, 4);


        singlyLinkedList.display(head);

        System.out.println(singlyLinkedList.length(head));
        //d///isplay(head);

    }
}

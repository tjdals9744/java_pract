import sun.security.util.Length;

import javax.swing.undo.CannotUndoException;
import java.util.Hashtable;
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

        @Override
        public String toString(){
            return Integer.toString(this.data);
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
        //his.head = head;
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

    public ListNode findStartOfCycleInLinkedListFloydDetection(ListNode head){
        boolean hasLoop = false;
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null){
            fast = fast.next;
            if(fast == slow){
                hasLoop = true;
                slow = head;
                while( slow == fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
            if(fast == null) return null;
            fast = fast.next;
            if(fast == slow){ //found!
                hasLoop = true;
                slow = head;
                while( slow == fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
            slow = slow.next;
        }
        return null;
    }

    public boolean hasCycleInLinkedListHashTable(ListNode head){
        Hashtable<ListNode,Integer> myTable = new Hashtable<ListNode,Integer>();
        boolean isFound = false;

        if(head == null){
            System.out.println("LL is empty");
            return isFound;
        }
        int position = 1;
        int loopPos = 0;

        ListNode current = head;
        myTable.put(current, position);
        current = current.next;

        while(current != null){
            if(myTable.containsKey(current)) {
                loopPos = myTable.get(current);
                System.out.println("loop found at position " + loopPos);
                isFound = true;
                break;
            }else{
                myTable.put(current,position);
            }
            current = current.next;
            position++;
        }
        return isFound;
    }

    public static void main(String[] args){

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        ListNode head = new ListNode(2);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(11);
        ListNode fifth = new ListNode(25);
        ListNode sixth = new ListNode(136);
        ListNode seventh = new ListNode(857);
        ListNode eighth = new ListNode(3332);

        //attach Nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        //eighth.next = third;

        //singlyLinkedList.display(head);
        //System.out.println("sdsfd");
        //System.out.println(singlyLinkedList.hasCycleInLinkedListHashTable(head));
       // System.out.println(singlyLinkedList.hasCycleInLinkedListFloydDetection(head));
        //head = singlyLinkedList.insertAtPosition(head, 21, 1);
        //head = singlyLinkedList.insertAtPosition(head, 42, 4);
        //singlyLinkedList.display(head);
        //System.out.println(singlyLinkedList.length(head));

        singlyLinkedList.display(head);
//.insertInSortedLinkedList(head,100);
        singlyLinkedList.insertInSortedLinkedList(head,1);


        singlyLinkedList.display(head);

        //System.out.println(singlyLinkedList.findStartOfCycleInLinkedListFloydDetection(head));
    }


    private ListNode insertInSortedLL(ListNode head, int data){
        ListNode current = head;
        ListNode newNode = new ListNode(data);
        ListNode prevToCur = null;
        if(head == null) return newNode;

        while(current != null && current.data < data){
            prevToCur = current;
            current = current.next;
        }
        prevToCur.next = newNode;
        newNode.next = current;
        return head;
    }



        private ListNode insertInSortedLinkedListSolution(ListNode head, int data) {
            ListNode current = head;
            ListNode newNode = new ListNode(data);
            ListNode prevToCurrent = null;
            if(head == null) return newNode;

            while(current != null && current.data < data){
            //    current = current.next;
                prevToCurrent = current;
                current = current.next;
            }
            newNode.next = current;
            prevToCurrent.next =newNode;
            return head;
        }

        private void insertInSortedLinkedList(ListNode head, int data) {
        ListNode nodeToInsert = new ListNode(data);
        ListNode current = head;
        ListNode prevToCurrent = null;
        if(current == null) {
            head = nodeToInsert;
            return;
        }else{
            while(current != null){
                if(current.data < data){
                    prevToCurrent = current;
                    current = current.next;
                }else{//bigger node found insert the node before this one.

                    //first node is bigger
                    if(prevToCurrent == null){
                        nodeToInsert.next = head;
                        head = nodeToInsert;
                    }else{
                        prevToCurrent.next = nodeToInsert;
                        nodeToInsert.next = current;
                    }
                    break;
                }
            }
        }
    }
}

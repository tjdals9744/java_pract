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

    /**
     *
     * @param head
     * @param nodeToInsert
     * @return return head of the modified node
     */
    public ListNode insertAtEndWithNode(ListNode head, ListNode nodeToInsert){
        //ListNode nodeToInsert = new ListNode(data);
        ListNode current = head;
        ListNode header = head;

        if(head == null){
            return nodeToInsert;
        }

        //reach last node current => lastnode
        while(current.next != null){
            current = current.next;
        }

        current.next = nodeToInsert;
        return header;
    }


    /**
     *
     * @param head
     * @param data
     * @return return head of the modified node
     */
    public ListNode insertAtEnd(ListNode head, int data){
        ListNode nodeToInsert = new ListNode(data);
        ListNode current = head;
        ListNode header = head;

        if(head == null){
            return nodeToInsert;
        }

        //reach last node current => lastnode
        while(current.next != null){
            current = current.next;
        }

        current.next = nodeToInsert;
        return header;
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

        ListNode head1 = new ListNode(2);
        ListNode second1 = new ListNode(4);
        ListNode third1 = new ListNode(10);
        ListNode fourth1 = new ListNode(11);
        ListNode fifth1 = new ListNode(100);

        ListNode head2 = new ListNode(1);
        ListNode second2 = new ListNode(4);
        ListNode third2 = new ListNode(7);
        ListNode fourth2 = new ListNode(59);
        ListNode fifth2 = new ListNode(111);


        //ListNode fifth = new ListNode(25);
/*        ListNode sixth = new ListNode(136);
        ListNode seventh = new ListNode(857);*/
        //ListNode eighth = new ListNode(3332);

        //attach Nodes
        head1.next = second1;
        second1.next = third1;
        third1.next = fourth1;
        fourth1.next = fifth1;

        //attach Nodes
        head2.next = second2;
        second2.next = third2;
        third2.next = fourth2;
        fourth2.next = fifth2;


/*        fifth.next = sixth;
        sixth.next = seventh;*/
        //seventh.next = eighth;
        //eighth.next = third;

        //singlyLinkedList.display(head);
        //System.out.println("sdsfd");
        //System.out.println(singlyLinkedList.hasCycleInLinkedListHashTable(head));
       // System.out.println(singlyLinkedList.hasCycleInLinkedListFloydDetection(head));
        //head = singlyLinkedList.insertAtPosition(head, 21, 1);
        //head = singlyLinkedList.insertAtPosition(head, 42, 4);
        //singlyLinkedList.display(head);
        //System.out.println(singlyLinkedList.length(head));

        //singlyLinkedList.display(head);
//.insertInSortedLinkedList(head,100);
        //singlyLinkedList.insertInSortedLinkedList(head,1);


        singlyLinkedList.display(head1);

        singlyLinkedList.display(head2);
        System.out.println(singlyLinkedList.mergeTwoSortedLL(head1,head2));

        //int[] A = {2,36,2667,42,6,2,5};
        //int[] B = {36,2667,42,6,2,5};
        //System.out.println(checkDuplicatesBruteForce(A));
        //System.out.println(checkDuplicatesBruteForce(B));
        //System.out.println(singlyLinkedList.findMiddle(head));
        //System.out.println(singlyLinkedList.findMiddle(head));
        //findMiddleSolutiontwoPointer
        //System.out.println(singlyLinkedList.findStartOfCycleInLinkedListFloydDetection(head));
        //printListBackward
        //System.out.println(singlyLinkedList.findMiddleWithOneSearch(head));
        //System.out.println("sdsdf");
        //singlyLinkedList.printListBackward(head);
        //System.out.println(singlyLinkedList.findMiddleSolutiontwoPointer(head));
    }


    private ListNode mergeTwoSortedLL(ListNode head1, ListNode head2){
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode head3 = null;

        if(cur1 == null) return head2;
        if(cur2 == null) return head1;

        SinglyLinkedList mySLL= new SinglyLinkedList();
        while(cur1 != null || cur2 != null){
            if(cur1.data > cur2.data){
                ListNode nodeToInsert = new ListNode(cur2.data);
                mySLL.insertAtEndWithNode(head3, nodeToInsert);
                cur2 = cur2.next;
            }else{
                mySLL.insertAtEnd(head3, cur1.data);
                cur1 = cur1.next;
            }
        }

        //same length
        if(cur1 != null && cur2 == null){
            return head1;

        //list1 iteration ended faster than list2
        }else if(cur1 == null && cur2 != null){
            return mySLL.insertAtEndWithNode(head3, cur2);
        }else{//list2 iteration ended faster than list1
            return mySLL.insertAtEndWithNode(head3, cur1);
        }

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

    private static boolean checkDuplicatesBruteForce(int A[]){
        for(int i=0; i<A.length; i++){
            for(int j= i+1; j < A.length; j++){
                if(A[i] == A[j]) return true;
            }
        }
        return false;
    }

    ListNode findIntersectingNode(ListNode list1, ListNode list2){
        int L1=0, L2=0, diff=0;
        ListNode head1 = list1, head2 = list2;
        while(head1 != null){
            L1++;
            head1 = head1.next;
        }
        while(head2 != null){
            L2++;
            head2 = head2.next;
        }

        diff = L1-L2;

        if(L1 < L2){
            head1 = list2;
            head2 = list1;
            diff = L2 - L1;
            diff = L2 - L1;
        }

        for(int i=0; i< diff; i++){
            head1 = head1.next;
        }

        while(head1 != null && head2 != null){
            if(head1 == head2){
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    ListNode findMiddle(ListNode head){
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        if(count %2 == 0){
            System.out.println("list is even ");
            return null;
        }else{
            count/=2;
            cur = head;
            for(int i=1; i<= count; i++){
                cur=cur.next;
            }
            return cur;
        }
    }

    ListNode findMiddleWithOneSearch(ListNode head){
        ListNode slow = head, fast= head;
        if(head == null){
            System.out.println("empty list");
            return null;
        }

        /*slow = slow.next;
        fast = fast.next;
        */
        while(fast != null){
            fast = fast.next;

            if(fast == null){
                System.out.println("ODD ! return slow ");
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }//if null, it means the list is even
        System.out.println("Even list, return null");
        return null;
    }

    ListNode findMiddleSolutiontwoPointer(ListNode head){
        ListNode ptr1x, ptr2x;
        ptr1x = ptr2x = head;

        int i=0;
        //repeat until reaching the end
        //next value after last node is null

        while(ptr1x.next != null){
            if(i == 0){
                ptr1x = ptr1x.next;
                i = 1;
            }else if(i==1){
                ptr1x = ptr1x.next;
                //increase both
                ptr2x = ptr2x.next;
                i=0;
            }
        }
        return ptr2x;
    }

    void printListBackward(ListNode head){
        ListNode tmp;
        ListNode current = head;

        //initial condition
        if(current == null){
            System.out.println(" null");
            return;
        }

        if(current.next == null){
            System.out.print(" null --> " + current + " --> ");
            return;
        }

        tmp = current;
        current = current.next;

        printListBackward(current);
        System.out.print(tmp + " --> ");
    }

    void PrintFromEndRecursive(ListNode head){
        if(head == null) return;
        PrintFromEndRecursive(head.next);
        System.out.print(head + " -> ");

    }

    boolean IsLinkedListLengthEven(ListNode head){
        while(head != null && head.next != null) {
            head = head.next.next;
        }if(head != null){
            System.out.println("Odd");
            return false;
        }else return true;

    }
}

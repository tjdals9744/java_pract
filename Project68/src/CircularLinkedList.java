/**
 * Created by sjeon on 2017-03-26.
 */
public class CircularLinkedList {
    private CLNode head;


    public int CircularListLength( CLNode head){
/*            if(head == null) return 0;

            CLNode currentNode = head;
            int count = 1;
            while(currentNode.next != head){
                currentNode = currentNode.next;
                count++;
            }
            return count;*/
        int length = 0;
        CLNode currentNode = head;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
            if(currentNode == head) break;
        }
        return length;
    }

    private void PrintCircularListData(CLNode head){
        if(head == null) {
            System.out.println("Empty List");
            return;
        }
/*
        CLNode currentNode = head;
        System.out.println(currentNode.data + " --> ");
        currentNode = currentNode.next;

        while(currentNode !=null){
            if(currentNode == head) break;
            System.out.println(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }

*/
//        CLNode currentNode = head;
//        do{
//            System.out.print(currentNode.data + " --> ");
//            currentNode = currentNode.next;
//        }while(currentNode != null && currentNode != head);
        CLNode currentNode = head;

        while(currentNode != null){
            System.out.print(currentNode.data + "  -->  ");
            currentNode = currentNode.next;
            if(currentNode == head) break;
        }
        System.out.println("(" + currentNode.data + ")headNode");
    }

    public CLNode insertAtEndInCLL(CLNode head, int data){
        CLNode currentNode = head;
        while(currentNode.next != head){
            currentNode = currentNode.next;
        }

        CLNode nodeToInsert = new CLNode(data);
        nodeToInsert.next = nodeToInsert;
        if(head == null) return nodeToInsert;


        currentNode.next = nodeToInsert;
        nodeToInsert.next = head;
        return head;
    }

    CLNode insertAtBeginInCLL(CLNode head, int data){
        CLNode nodeToInsert = new CLNode(data);

        CLNode currentNode = head;

        while(currentNode.next != head){
            currentNode = currentNode.next;
        }
        nodeToInsert.next = nodeToInsert;

        if(head == null) {
            return nodeToInsert;
        }else{
            currentNode.next = nodeToInsert;
            nodeToInsert.next = head;
            head = nodeToInsert;
        }
        return head;
    }

    CLNode deleteAtFirst(CLNode head){
        if(head == null) return null;
        CLNode currentNode = head;
        CLNode tmpNode = head;

       while(currentNode.next != head){
            currentNode = currentNode.next;
        }
        currentNode.next = head.next;
        head = head.next;
        tmpNode = null;
        return head;
        /*

        while(currentNode.next == head)
*/




    }


    public static void main(String[] args){
        CLNode head = new CLNode(3);
        CLNode second = new CLNode(15);
        CLNode third = new CLNode(7);
        CLNode fourth = new CLNode(40);

        head.next = second;
        second.next = third;
        third.next = fourth ;
        fourth.next = head;

        CircularLinkedList myCLL = new CircularLinkedList();
        System.out.println("size = "  + myCLL.CircularListLength(head));
        myCLL.PrintCircularListData(head);
        head = myCLL.insertAtEndInCLL(head, 99);
        myCLL.PrintCircularListData(head);
        myCLL.insertAtEndInCLL(head, 999999);
        head = myCLL.insertAtBeginInCLL(head, 111111);

        myCLL.PrintCircularListData(head);

        System.out.println("deleteAtFirst");
        head = myCLL.deleteAtFirst(head);
        myCLL.PrintCircularListData(head);
    }

    private static class CLNode{
        private int data;
        private CLNode next;

        public CLNode(int data){
            this.data = data;
            this.next = next;
        }


    }
}

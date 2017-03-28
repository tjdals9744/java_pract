/**
 * Created by sjeon on 2017-03-24.
 */
public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data){
        this.data = data;
    //    this.next= null;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public ListNode getNext(){
        return this.next;
    }

    int ListLength(ListNode headNode){
        int ListCount = 0;
        ListNode nextNode = headNode;
        while(nextNode != null){
            nextNode = nextNode.getNext();
            ListCount++;
        }
        return ListCount;
    }

    public ListNode insertInLinkedList (ListNode headNode, ListNode nodeToInsert, int position)throws PositionOutOfBoundsLException{
        //empty LL
        if(headNode == null) return nodeToInsert;

        int size = ListLength(headNode);
        if(position > size + 1 || position < 1 ){
            System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
            throw new PositionOutOfBoundsLException("Asdf");
        }

        if(position == 1){
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        }else{
            ListNode previousNode = headNode;
            int count = 1;
            while(count < position -1) {
                previousNode = (previousNode.getNext());
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
            //nodeToInsert = previousNode.getNext();
        }
        return headNode;
    }


    ListNode DeleteNodeFromLinkedList(ListNode headNode, int position){
        int size = ListLength(headNode);
        if(headNode == null){
            return headNode;
        }

        if(position < 1 || position > size){
            System.out.println("wrong position");
            return headNode;
        }

        if(position == 1){ //delete the first node
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        } else{  //delete node
            ListNode previousNode = headNode;
            int count = 1;
            while(count < position -1){
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }



}

class PositionOutOfBoundsLException extends Exception{
    public PositionOutOfBoundsLException(){
        super();
    }

    public PositionOutOfBoundsLException(String s){
        super(s);
    }
}

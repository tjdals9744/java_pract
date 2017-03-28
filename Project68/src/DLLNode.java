/**
 * Created by sjeon on 2017-03-24.
 */
public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;
    public DLLNode(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(DLLNode next){
        this.next = next;
    }

    public DLLNode getNext(){
        return this.next;
    }

    public void setPrevious(DLLNode prevNode){
        this.previous = prevNode;
    }

    public DLLNode getPrevious(){
        return this.previous;
    }

    public int DLLLength(DLLNode headNode){
       if(headNode == null) return 0;

        DLLNode currentNode = headNode;

        int count = 1;
        while(currentNode.getNext() != null){
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

/*    int DLLListLength(DLLNode headnode){

        int length = 0;
        DLLNode currentNode = headnode;

    }*/

    public DLLNode insertDLLNode(DLLNode headNode, DLLNode nodeToInsert, int position){
        if(headNode == null){
            return nodeToInsert;
        }

        int DLLSize = DLLLength(headNode);

        if(position < 1 || position > DLLSize + 1) {
            System.out.println("position invalid, Please insert position between 1 and " + DLLSize + 1);
            return headNode;
        }

        DLLNode newNode = nodeToInsert;
        DLLNode head = headNode;

        if(position == 1){
            newNode.next = head;
            //newNode.previous = null; //needed?
            head.previous = newNode;
            newNode = head;
            return newNode;
        }else{
            DLLNode currNode = head;

            for(int i=1; i <= position; i++){
                currNode = currNode.next;
            }
            DLLNode prevNode = currNode.previous;


            newNode.next = currNode;
            if(currNode != null){
                currNode.previous = newNode;
            }

            prevNode.next = newNode;
            newNode.previous = prevNode;

            return head;
        }
    }

    /**
     *
     * @param head
     * @param position
     * @return deleteNode
     */
    DLLNode deleteAtPosition(DLLNode head, int position){
        if(head == null) return null;
        int size = DLLLength(head);

        if(position < 1 || size > position){
            System.out.println("invalid position, please put position 1 or greater and less or equal to " + position);
            return head;
        }

        DLLNode currNode = head;

        if(position == 1){
            head = currNode.next;
            head.previous = null;
            //currNode.next = null;
            currNode = null;
        }else{
            DLLNode prevNode;
            DLLNode nextNode;
            for(int i=1; i < position; i++){
                currNode = currNode.next;
            }

            nextNode = currNode.next;
            prevNode = currNode.previous;

            if(nextNode == null){
                prevNode.next = null;
                return head;
            }

            prevNode.next = nextNode;
            nextNode.previous = prevNode;

            currNode = null;
        }
        return head;
    }
}

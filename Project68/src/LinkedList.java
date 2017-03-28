/**
 * Created by sjeon on 2017-03-26.
 */
import java.util.Hashtable;

public class LinkedList <T> {

    private Node<T> head = null;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void addFirst(T data) {
        Node<T> newFirst = new Node<T>(data);
        newFirst.next = head;
        head = newFirst;
    }

    public Node<T> returnHead(){
        return head;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        } else {
            Node<T> oldFirst = head;
            head = head.next;
            //oldFirst = null;
            head = oldFirst;
            return oldFirst.data;
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }
    //isEmpty


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            //System.out.printf(first.data + " --> ");
            sb.append(current.data).append(" --> ");
            current = current.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<Integer>();
        myList.addFirst(32);
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addFirst(42);
        System.out.println(myList.toString());

        Node head = myList.returnHead();
        System.out.println(myList.countfromCurrentNode(head));

        //System.out.println(myList.countnThFromEndBruteForce(3));
        //System.out.println(myList.countnThFromEndHashTable(3));
        //System.out.println(myList.countnThFromEndNoHashTable(3));
        System.out.println(myList.countnThFromEndOneIteration(3));
    }


    /**
     * Fuction to count from the current node to the end.
     *
     * @param currentNode
     * @return
     */
    public int countfromCurrentNode(Node currentNode){
        int count=0;
        if(currentNode == null){
            return 0;
        }else{
            while(currentNode != null){
                count++;
                currentNode = currentNode.next;
            }
            return count;
        }
    }

    public Node countnThFromEndNoHashTable(int nThFromBack){
        int count = countfromCurrentNode(head);
        if(count < nThFromBack){
            System.out.println("invalid");
            return null;
        }else{
            Node current = head;
            for(int position = 1; position <= (count - nThFromBack +1); position++){
                current = current.next;
            }
            return current;
        }
    }

    public Node countnThFromEndOneIteration(int nThFromBack){
        Node pNthNode = head;
        Node pTemp = head;

        for(int i=1; i < nThFromBack; i++){
            pNthNode = pNthNode.next;
            if(pNthNode == null) {
                System.out.println("invalid");
                return null;
            }
        }//finish moving

        while(pNthNode != null){
            pNthNode = pNthNode.next;
            pTemp = pTemp.next;
        }
        return pTemp;
    }

    public Node countnThFromEndHashTable(int nThfromBack){
        Hashtable<Integer,Node > myTable = new Hashtable<Integer, Node>();
        Node current = head;
        if(current == null) {
            return null;
        }else{
            int position = 1, count = 1;
            while(current != null){
                myTable.put(position, current);
                current = current.next;
                position++;
                count++;
            }

            if( myTable.containsKey((count - nThfromBack + 1 ))){
                return myTable.get((count - nThfromBack + 1 ));
            }else{
                return null;
            }
        }
    }


    public Node countnThFromEndBruteForce(int nThfromBack) {
        System.out.println();
        System.out.println();


        Node current = head;
        Node nodeToReturn = null;

            //traversing the linkedlist
        while (current != null) {
            int count = 0;
            count = countfromCurrentNode(current);
            if(count < nThfromBack){
                System.out.println("list too short");
                return null;
            }else if(count > nThfromBack){
                current = current.next;
            }else if(count == nThfromBack)
                //System.out.println(current.data.toString());
                //System.out.println(current.toString());
                return current;
        }// reached end (null)
        return  nodeToReturn;
    }
}






/*class LinkedListStack<T>{
    private final LinkedList<T> linkedList = new LinkedList<>();

    public void push(T data){
        linkedList.addFirst(data);
    }

    public T pop(){
        return linkedList.removeFirst();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    @Override
    public String toString(){
        return linkedList.toString();
    }


    public void testPushAndPop(){

        LinkedListStack<Integer> st = new LinkedListStack<>();
        st.push(50);
        st.push(70);
        st.push(190);

        st.toString();


    }
}*/

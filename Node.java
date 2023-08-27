package ch14;

/**
 * Node of LinkedList.
 * It only shows the node next towards the tail of the list.
 */
public class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

//    public void setValue(int value){
//        this.value = value;
//    }

    public Node next(){
        return next;
    }

    public void next(Node nextNode){
        next = nextNode;
    }

    public int value() {
        return value;
    }
}

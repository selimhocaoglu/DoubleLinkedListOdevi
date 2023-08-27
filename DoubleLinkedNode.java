package ch14;

public class DoubleLinkedNode extends Node{
    DoubleLinkedNode dln;
    public DoubleLinkedNode(int value, Node next, DoubleLinkedNode dln) {
        super(value, next);
        this.dln = dln;
    }


    public DoubleLinkedNode getDln() {
        return dln;
    }

    public void setDln(DoubleLinkedNode dln) {
        this.dln = dln;
    }
}

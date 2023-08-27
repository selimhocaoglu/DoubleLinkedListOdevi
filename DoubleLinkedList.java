package ch14;

public class DoubleLinkedList extends LinkedList{
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    private int size;
    public DoubleLinkedList(){
        super();
    }

    public void addHead(int value) {
        DoubleLinkedNode newNode = new DoubleLinkedNode(value, head, null);
        if (head != null) {
            head.setDln(newNode);
        }
        head = newNode;
        if (size == 0) {
            tail = head;
        }

    }

    private void addTail(int value) {
        DoubleLinkedNode newNode = new DoubleLinkedNode(value, null, tail);
        if (tail != null) {
            tail.setDln(newNode);
        }
        tail = newNode;
    }

    public boolean add(int index, int value) {
//        Add to the head: Make the new node head.
        if (index == 0)
            addHead(value);

//      Add to the tail. Make the new node tail
        else if (index == size) {
            addTail(value);
        }
//      Add somewhere between head and tail.
        else {
            int cursor = 1;
            DoubleLinkedNode pointer = head;
            while (cursor < index) {
                cursor++;
                pointer = pointer.getDln();
            }
            // cursor = index - 1 now
            DoubleLinkedNode insertionNode = pointer.getDln();
            DoubleLinkedNode newNode = new DoubleLinkedNode(value, insertionNode, pointer);
            if(insertionNode == null){
                tail = newNode;
            }
            else{
                newNode.next(insertionNode);
                insertionNode.setDln(newNode);
            }
            pointer.next(newNode);
        }
        size++;
        return true;
    }
}

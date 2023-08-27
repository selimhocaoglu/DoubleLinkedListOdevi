package ch14;

public class LinkedList {
    // 0th element
    private Node head;
    // Last element
    private Node tail;
//     Number of elements in the list
    private int size;

    public LinkedList() {

    }

    /**
     * Adds parameter at the tail of the list.
     *
     * @param value to be added.
     */
    public boolean add(int value) {
        return add(size, value);
    }

    /**
     * Adds parameter at the given index of the list.
     * @param value to be added.
     */
    public boolean add(int index, int value) {
//        Add to the head: Make the new node head.
        if (index == 0)
            addHead(value);

//      Add to the tail. Make the new node tail
        else if (index == size)
            addTail(value);

//      Add somewhere between head and tail.
        else {
            int cursor = 0;
            Node pointer = head;
            while (cursor < index - 1) {
                cursor++;
                pointer = pointer.next();
            }
            // cursor = index - 1 now
            Node insertionNode = pointer.next();
            Node newNode = new Node(value, insertionNode);
            pointer.next(newNode);
        }
        size++;
        return true;
    }

    private void addHead(int value) {
        Node newNode = new Node(value, head);
        head = newNode;
        if (size == 0)
            tail = head;
    }

    private void addTail(int value) {
        Node newNode = new Node(value, null);
        tail.next(newNode);
        tail = newNode;
    }

    public boolean contains(int value) {
        Node pointer = head;
        int cursor = 0;
        if(size == 0)
            return false;
        if(head.value() == value || tail.value() == value)
            return true;
        while (cursor < size - 1) { // Go to size - 1 because of the fact that if cursor = size-1 that means it is tail!
            pointer = pointer.next();
            if(pointer.value() == value)
                return true;
            cursor++;
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     * Note that this list does not throw any exception. So it just prints error message when index is greater than size and returns Integer.MIN_VALUE.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        if(index > size) {
            System.err.println("ERROR: " + index + " is greater than size " + size);
            return Integer.MIN_VALUE;
        }

        // return head
        if(index == 0)
            return head.value();

        // return tail
        if(index == size)
            return tail.value();

        // Search for index
        Node pointer = head;
        int cursor = 0;
        while (cursor != index) {
            pointer = pointer.next();
            cursor++;
        }
        return pointer.value();
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param value element ot search for
     * @return index of the element if it is contained in the list otherwise -1.
     */
    public int indexOf(int value) {
        if(size == 0)
            return -1;
        if(head.value() == value)
            return 0;
        Node pointer = head;
        int cursor = 0;
        while (cursor != size) {
            pointer = pointer.next();
            cursor++;
            if(pointer != null && pointer.value() == value)
                return cursor;
        }
        return -1;
    }

//    public int removeAtIndex(int index){
//        Find the value at given index and remove and return it.
//        return 0;
//    }

//    public boolean remove(int value){
//      Find the value if exists and remove and return true otherwise return false.
//        return false;
//    }

    public void clear(){
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Returns the number of elements in this list.
     * @return The number of elements in this list.
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void list() {
        System.out.println("\n" + size + " values in the list:");
        System.out.println("___________________________________");
        Node pointer = head;
        int cursor = 0;
        while (cursor < size) {
            System.out.println(pointer.value());
            pointer = pointer.next();
            cursor++;
        }
        System.out.println();
    }

    public boolean remove(int value){
        if (size == 0) {
            return false;
        }
        if(head.value() == value){
            head = head.next();
            if(size ==1){
                tail = null;
            }
            size--;
            return true;
        }
        Node m = head;
        while(m.next() != null){
            if(m.next().value() == value){
                m.next().next();
                if(m.next() == null){
                    tail =m;
                }
                size--;
                return true;
            }
            m = m.next();
        }
        return false;
    }

    public int removeAtIndex(int index){
        int removedNumberAtIndex;
        if(index<0 ||index >= size){
            System.out.println("Hata");
        }
        if(index == 0){
            removedNumberAtIndex = head.value();
            head = head.next();
            if(size == 1){
                tail = null;
            }
        }
        else {
            int cursor = 0;
            Node m = head;
            while(cursor <= index){
                cursor++;
                m = m.next();
            }
            removedNumberAtIndex = m.next().value();
            m.next().next();
            if(index == size - 1){
                tail = m;
            }
        }
        size--;
        return removedNumberAtIndex;
    }
}

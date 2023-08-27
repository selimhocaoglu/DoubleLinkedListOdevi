package ch14;

public class DoubleLinkedListTest{
    public static void main(String[] args) {
        testAddHead();
//        testAddTail();
//        testAdd();
//        testGet();
//        testContains();
//        testIndexOf();
//        testIsEmpty();
//        testClear();
        testDoubleLinkedList();
    }

    public static void testDoubleLinkedList(){
        System.out.println("\n testDoubleLinkedList() \n");
        DoubleLinkedList list = new DoubleLinkedList();
        System.out.println(list.add(0,1));
        System.out.println(list.add(0,8));
        System.out.println(list.add(0,16));
        list.list();
    }

    public static void testAddHead() {
        System.out.println("\n testAddHead() \n");
        DoubleLinkedList list = new DoubleLinkedList();
        System.out.println(list.add(0,0));
        list.list();
        System.out.println(list.add(0, 1));
        list.list();
        System.out.println(list.add(0, 2));
        list.list();
    }

    public static void testAddTail() {
        System.out.println("\n testAddTail() \n");
        DoubleLinkedList list = new DoubleLinkedList();
        System.out.println(list.add(0));
        list.list();
        System.out.println(list.add(1));
        list.list();
        System.out.println(list.add(2));
        list.list();
    }

    public static void testAdd() {
        System.out.println("\n testAdd() \n");
        DoubleLinkedList list = new DoubleLinkedList();
        for (int i = 0; i < 10; i++)
            System.out.println(list.add(i));
        list.list();

        int size = list.size();
        System.out.println("Size is " + size + "\n");

        // Be careful not to go more than size!
        for (int i = size; i > 0; i--)
            list.add(i, i * 10);
        list.list();

        size = list.size();
        System.out.println("Size is " + size + "\n");

        // Be careful not to go more than size!
        for (int i = 0; i < size; i++)
            if (i % 3 == 0)
                list.add(i, 999);
        list.list();
    }

    public static void testGet() {
        System.out.println("\n testGet() \n");
        DoubleLinkedList list = new DoubleLinkedList();
        for (int i = 0; i < 10; i++)
            list.add(i * 10);

        list.list();

        for (int i = 0; i < 10; i++)
            System.out.printf("Element at index %d %d\n", i, list.get(i));

//      Get from head
        System.out.printf("\nElement at head %d\n", list.get(0));

//      Get from tail
        System.out.printf("\nElement at tail %d\n", list.get(list.size()));

        list.add(0, -999);
        list.add(list.size(), 999);
        list.list();

//       Get from head
        System.out.printf("\nElement at head %d\n", list.get(0));

//      Get from tail
        System.out.printf("\nElement at tail %d\n", list.get(list.size()));

        // Error case
        System.out.printf("\nElement at index %d %d\n", 20, list.get(200));
    }

    public static void testContains() {
        System.out.println("\n testContains() \n");
        DoubleLinkedList list = new DoubleLinkedList();
        for (int i = 0; i < 10; i++)
            System.out.println(list.add(i * 10));

        list.list();

        for (int i = 0; i < 10; i++)
            System.out.printf("List contains %d %b\n", i * 10, list.contains(i * 10));

        for (int i = 0; i < 10; i++)
            System.out.printf("List contains %d %b\n", i * 10 + 1, list.contains(i * 10 + 1));
    }

    public static void testIndexOf() {
        System.out.println("\n testIndexOf() \n");
        DoubleLinkedList list = new DoubleLinkedList();
        for (int i = 0; i < 10; i++)
            list.add(i * 10);

        list.list();

        for (int i = 0; i < 10; i++)
            System.out.printf("Index of %d %d\n", i * 10, list.indexOf(i * 10));

        list.add(1, 1);
        list.add(4, 41);
        list.add(7, 71);

        for (int i = 0; i < 10; i++)
            System.out.printf("Index of %d %d\n", i * 10 + 1, list.indexOf(i * 10 + 1));

        list.list();
    }

    public static void testIsEmpty() {
        System.out.println("\n testIsEmpty() \n");
        DoubleLinkedList list = new DoubleLinkedList();
        System.out.println("Is empty: " + list.isEmpty());
        list.add(10);
        System.out.println("Is empty: " + list.isEmpty());
    }

    public static void testClear() {
        System.out.println("\n testClear() \n");
        DoubleLinkedList list = new DoubleLinkedList();
        for (int i = 0; i < 10; i++)
            list.add(i * 10);

        list.list();
        System.out.println("Is empty: " + list.isEmpty());

        list.clear();

        list.list();
        System.out.println("Is empty: " + list.isEmpty());
    }
}

package hw9;

public class MyLinkedListTest {
    public static MyLinkedList<String> myLinkedList = new MyLinkedList<>();

    private static void print(String message) {
        System.out.println(message);
        System.out.println("Size of LinkedList: " + myLinkedList.size() + " Data in LinkedList: " );
        myLinkedList.print();
        System.out.println();
    }

    public static void myLinkedListTest() {
        print("Created LinkedList");
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");
        myLinkedList.add("5");
        myLinkedList.add("6");
        print("Add to LinkedList 6 el");
        print("GET - element with index 0 is: " + myLinkedList.get(0));
        print("GET - element with index 1 is: " + myLinkedList.get(1));
        print("GET - element with index 2 is: " + myLinkedList.get(2));
        print("GET - element with index 3 is: " + myLinkedList.get(3));
        print("GET - element with index 4 is: " + myLinkedList.get(4));
        print("GET - element with index 5 is: " + myLinkedList.get(5));
        myLinkedList.remove(2);
        print("LinkedList after delete element with index 2 - REMOVE");
        myLinkedList.remove(myLinkedList.size()-1);
        print("LinkedList after delete LAST element - REMOVE");
        myLinkedList.remove(0);
        print("LinkedList after delete FIRST element - REMOVE");
        myLinkedList.clear();
        print("LinkedList after clear");
    }
}

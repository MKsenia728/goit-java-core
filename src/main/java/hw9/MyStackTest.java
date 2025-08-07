package hw9;

public class MyStackTest {
    public static MyStack<String> myStack = new MyStack<>();

    private static void print(String message) {
        System.out.println(message);
        System.out.println("Size of Stack: " + myStack.size() + " Data in Stack " + myStack + "\n");
    }

    public static void myStackTest() {
        print("Created MyStack");
        myStack.push("First");
        myStack.push("Second");
        myStack.push("Third");
        myStack.push("Forth");
        myStack.push("Last");
        print("Add to MyStack 5 el");
        myStack.remove(2);
        print("MyStack after delete element with index 2 - REMOVE");
        print("work PEEK, last element is: " + myStack.peek());
        print("work POP, last element is: " + myStack.pop());
        myStack.clear();
        print("MyStack after clear");
    }
}

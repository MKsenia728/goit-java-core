package hw9;

public class MyQueueTest {
    public static MyQueue<Integer> myQueue = new MyQueue<>();

    private static void print(String message) {
        System.out.println(message);
        System.out.println("Size of Queue: " + myQueue.size() + " Data in Queue " + myQueue + "\n");
    }

    public static void myQueueTest() {
        print("Created MyQueue");
        myQueue.add(11);
        myQueue.add(22);
        myQueue.add(33);
        myQueue.add(44);
        print("Add to MyQueue 4 el");
        print("work PEEK, first element is: " + myQueue.peek());
        print("work POLL, first element is: " + myQueue.poll());
        print("work POLL, first element is: " + myQueue.poll());
        print("work POLL, first element is: " + myQueue.poll());
        print("work POLL, first element is: " + myQueue.poll());
        myQueue.clear();
        print("MyQueue after clear");
    }
}

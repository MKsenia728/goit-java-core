package hw9;

public class MyArrayListTest {
    public static MyArrayList<String> myArrayList = new MyArrayList<>();

    private static void print(String message) {
        System.out.println(message);
        System.out.println("Size of ArrayList: " + myArrayList.size() + " Data in ArrayList " + myArrayList + "\n");
    }

    public static void myArrayTest() {
        print("ArrayList was created");
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        print("ArrayList after adding 5 elements - ADD");
        myArrayList.remove(1);
        print("ArrayList after delete element with index 1 - REMOVE");
        System.out.println("This is element with index 3: " + myArrayList.get(3) + " GET");
        myArrayList.clear();
        print("ArrayList after clear()");
    }
}

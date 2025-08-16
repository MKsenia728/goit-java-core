package hw9;

public class MyHashMapTest {
    public static MyHashMap<String, String> myHashMap = new MyHashMap<>();

    private static void print(String message) {
        System.out.println(message);
        System.out.println("Size of HashMap: " + myHashMap.size() + " Data in HashMap ");
        myHashMap.print();
        System.out.println();
    }

    public static void myHashMapTest() {
        print("HashMap was created");

        myHashMap.put("ivan@ivan.com", "Ivan");
        myHashMap.put("ivan@ivan.com", "Petro");
        myHashMap.put("anna@ivan.com", "Anna");
        myHashMap.put("olena@ivan.com", "Olena");
        myHashMap.put("jan@ivan.com", "Jan");

        print("Add 5 element in HashMap, 2 with the same key ivan@ivan.com");

        myHashMap.remove("anna@ivan.com");
//        myHashMap.remove("ivan@ivan.com");
        print("Remove element with key anna@ivan.com ");

        print("Get element value with key \"olena@ivan.com\" - " + myHashMap.get("olena@ivan.com"));

        myHashMap.clear();
        print("After clear");

        for (int i = 0; i < 30; i++) {
            myHashMap.put(String.valueOf(i*2 + i), "name" + i*10);
        }
        print("test working ");
        System.out.println(" Amount of backed: " + myHashMap.getLength());
        for (int i = 0; i < myHashMap.getLength(); i++) {
            System.out.println("Backed : " + i + " length of list in backed : " + myHashMap.list[i].size());
        }
    }
}


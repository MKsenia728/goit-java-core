package hw9;

public class MyHashMap<K, V> {
    protected SingleLinkedList<K, V>[] list;
    static int DEFAULT_SIZE = 10;
    static int DEFAULT_CHANGE_RATE = 2;
    static float DEFAULT_CHANGE_THRESHOLD = 0.7f;
    int size;
    int changeRate;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        size = DEFAULT_SIZE;
        changeRate = DEFAULT_CHANGE_RATE;
        list = (SingleLinkedList<K, V>[]) new SingleLinkedList[DEFAULT_SIZE];
        for (int i = 0; i < size; i++) {
            list[i] = new SingleLinkedList<>();
        }
    }

    private boolean needIncrease() {
        for (int i = 0; i < size; i++) {
//        Перевіряю, якщо довжина списку хоча б в одному бакеті більша 0.7 частини довжини самої мапи (мапа 10, у списку 8 і більше), то збільшуємо масив, потрібне перерозподілення
            if (list[i].size() > DEFAULT_CHANGE_THRESHOLD * size) return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        int newSize = size * changeRate;
        SingleLinkedList<K, V>[] newList = (SingleLinkedList<K, V>[]) new SingleLinkedList[newSize];
        for (int i = 0; i < newSize; i++) {
            newList[i] = new SingleLinkedList<>();
        }
        for (int i = 0; i < size; i++) {
            Node<K, V> currentNode = list[i].getHead();

            while (currentNode != null) {
                int backed = Math.abs(currentNode.getKey().hashCode()) % newSize;
                newList[backed].add(currentNode.getKey(), currentNode.getValue());
                currentNode = currentNode.getNext();
            }
        }
        size = newSize;
        list = newList;
    }

    private int getBacked(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            Node<K, V> currentNode = list[i].getHead();
            while (currentNode != null) {
                System.out.println("Key : " + currentNode.getKey() + " Value : " + currentNode.getValue());
                currentNode = currentNode.getNext();
            }
        }
    }

    public void put(K key, V value) {
        if (needIncrease()) increase();
        int backed = getBacked(key);
        if (list[backed].size() != 0) {
            if (list[backed].contains(key)) {
                Node<K, V> currentNode = list[backed].getHead();
                while (currentNode != null) {
                    if (key.equals(currentNode.getKey())) {
                        currentNode.setKey(key);
                        currentNode.setValue(value);
                        return;
                    }
                    currentNode = currentNode.getNext();
                }
            }
        }
        list[backed].add(key, value);
    }

    public void remove(K key) {
        int backed = getBacked(key);
        list[backed].remove(key);
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i].clear();
        }
    }

    public int size() {
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += list[i].size();
        }
        return length;
    }

    public V get(K key) {
        return list[getBacked(key)].get(key);
    }
}
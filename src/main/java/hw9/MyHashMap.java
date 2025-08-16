package hw9;

import lombok.Getter;

public class MyHashMap<K, V> {
    protected SingleLinkedList<K, V>[] list;
    static int DEFAULT_SIZE = 16;
    static int DEFAULT_CHANGE_RATE = 2;
    static float DEFAULT_CHANGE_THRESHOLD = 0.75f;
    private int size;
    @Getter
    private int length;
    private final int changeRate;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        length = DEFAULT_SIZE;
        size = 0;
        changeRate = DEFAULT_CHANGE_RATE;
        list = (SingleLinkedList<K, V>[]) new SingleLinkedList[DEFAULT_SIZE];
        for (int i = 0; i < length; i++) {
            list[i] = new SingleLinkedList<>();
        }
    }

    private boolean needIncrease() {
        for (int i = 0; i < length; i++) {
//        Перевіряю, якщо довжина списку хоча б в одному бакеті більша 0.7 частини довжини самої мапи (мапа 10, у списку 8 і більше), то збільшуємо масив, потрібне перерозподілення
            if (list[i].size() > DEFAULT_CHANGE_THRESHOLD * length) return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        int newSize = length * changeRate;
        SingleLinkedList<K, V>[] newList = (SingleLinkedList<K, V>[]) new SingleLinkedList[newSize];
        for (int i = 0; i < newSize; i++) {
            newList[i] = new SingleLinkedList<>();
        }
        for (int i = 0; i < length; i++) {
            Node<K, V> currentNode = list[i].getHead();

            while (currentNode != null) {
                int backed = Math.abs(currentNode.getKey().hashCode()) % newSize;
                newList[backed].add(currentNode.getKey(), currentNode.getValue());
                currentNode = currentNode.getNext();
            }
        }
        length = newSize;
        list = newList;
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % length;
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            Node<K, V> currentNode = list[i].getHead();
            while (currentNode != null) {
                System.out.println("Key : " + currentNode.getKey() + " Value : " + currentNode.getValue());
                currentNode = currentNode.getNext();
            }
        }
    }

    public void put(K key, V value) {
        if (needIncrease()) increase();
        int backed = getBucketIndex(key);
        if (list[backed].size() != 0) {
            Node<K, V> currentNode = list[backed].getHead();
            while (currentNode != null) {
                if (key.equals(currentNode.getKey())) {
                    currentNode.setValue(value);
                    return;
                }
                currentNode = currentNode.getNext();
            }
        }
        list[backed].add(key, value);
        size++;
    }

    public void remove(K key) {
        int backed = getBucketIndex(key);
        list[backed].remove(key);
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i].clear();
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        return list[getBucketIndex(key)].get(key);
    }

}
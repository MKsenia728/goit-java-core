package hw9;

import java.util.Arrays;

public class MyArrayCollection {
    Object[] list;
    static int DEFAULT_SIZE = 10;
    static int DEFAULT_CHANGE_RATE = 2;
    static float DEFAULT_CHANGE_THRESHOLD = 0.7f;
    int size;
    int changeRate;
    int pointer;

    public MyArrayCollection() {
        size = DEFAULT_SIZE;
        list = new Object[size];
        changeRate = DEFAULT_CHANGE_RATE;
        pointer = -1;
    }

    public MyArrayCollection(int size) {
        this.size = size;
        list = new Object[size];
        changeRate = DEFAULT_CHANGE_RATE;
        pointer = -1;
    }

    void increase() {
        int newSize = size * changeRate;
        list = Arrays.copyOf(list, newSize);
        size = newSize;
    }

    boolean needIncrease() {
        return (pointer >= size * DEFAULT_CHANGE_THRESHOLD);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= pointer; i++) {
            if (i != pointer) {
                sb.append(list[i]).append(", ");
            } else {
                sb.append(list[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

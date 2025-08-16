package hw9;

public class MyQueue<T> extends MyArrayCollection {

    public void add(T value) {
        if (needIncrease()) increase();
        list[++pointer] = value;
    }

    public void clear() {
        for (int i = 0; i <= pointer; i++) {
            list[i] = null;
        }
        pointer = -1;
    }

    public int size() {
        return pointer + 1;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (pointer > -1) return (T) list[0];
        return null;
    }

    private void removeFirst() {
        if (pointer > -1) {
            int firstIndex = 0;
            System.arraycopy(list, firstIndex + 1, list, firstIndex, pointer - firstIndex);
            list[pointer--] = null;
        }
    }

    public T poll() {
        T first = peek();
        removeFirst();
        return first;
    }
}

package hw9;

public class MyStack<T> extends MyArrayCollection {
    public void push(T value) {
        if (needIncrease()) increase();
        list[++pointer] = value;
    }

    private boolean checkIndex(int index) throws IndexOutOfBoundsException {
        if (index > pointer || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Size: " + (pointer + 1));
        return true;
    }

    public void remove(int index) {
        if (checkIndex(index) && index < pointer) {
            System.arraycopy(list, index + 1, list, index, pointer - index);
        }
        list[pointer--] = null;
    }

    public void clear() {
        for (int i = 0; i < pointer; i++) {
            list[i] = null;
        }
        pointer = -1;
    }

    public int size() {
        return pointer + 1;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (pointer > -1) return (T) list[pointer];
        return null;
    }

    public T pop() {
        T lastEl = peek();
        list[pointer--] = null;
        return lastEl;
    }
}

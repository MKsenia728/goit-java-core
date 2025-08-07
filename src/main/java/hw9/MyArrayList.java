package hw9;

public class MyArrayList<T> extends MyArrayCollection implements MyListCollection<T> {

    public MyArrayList() {
    }

    public MyArrayList(int size) {
        super(size);
    }

    private boolean checkIndex(int index) throws IndexOutOfBoundsException{
        if (index > pointer || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Size: " + (pointer + 1));
        return true;
    }

    @Override
    public void add(T value) {
        if (needIncrease()) increase();
        list[++pointer] = value;
    }

    @Override
    public void remove(int index) {
        if (checkIndex(index) && index < pointer) {
            System.arraycopy(list, index + 1, list, index, pointer - index);
        }
        list[pointer--] = null;
    }

    @Override
    public void clear() {
        for(int i = 0; i < pointer; i++) {
            list[i] = null;
        }
        pointer = -1;
    }

    @Override
    public int size() {
        return pointer + 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (checkIndex(index)) return (T) list[index];
        return null;
    }
}

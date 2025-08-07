package hw9;

public class MyLinkedList<T> implements MyListCollection<T> {
    private Node2<T> head;
    private Node2<T> tail;
    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public void print() {
        if (head == null) {
            System.out.println("No data");
        } else {
            Node2<T> currentNode2 = head;
            do {
                System.out.print(currentNode2.getData() + " ");
                currentNode2 = currentNode2.getNext();
            } while (currentNode2 != null);
        }
    }

    @Override
    public void add(T value) {
        Node2<T> newNode2 = new Node2<>(value);
        if (head == null) {
            head = newNode2;
        } else if (tail == null) {
            tail = newNode2;
            tail.setPrevious(head);
            head.setNext(tail);
        } else {
            tail.setNext(newNode2);
            newNode2.setPrevious(tail);
            tail = newNode2;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (checkIndex(index)) {
            if (size == 1) {
                head = null;
            } else if (index == 0) {
                head.getNext().setPrevious(null);
                head = head.getNext();
            } else if (index == size - 1) {
                tail.getPrevious().setNext(null);
                tail = tail.getPrevious();
            } else {
                Node2<T> deletedNode2 = getNodeByIndex(index);
                deletedNode2.getPrevious().setNext(deletedNode2.getNext());
                deletedNode2.getNext().setPrevious(deletedNode2.getPrevious());
            }
            size--;
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (checkIndex(index)) {
            return getNodeByIndex(index).getData();
        }
        return null;
    }

    private boolean checkIndex(int index) throws IndexOutOfBoundsException {
        if (index > size - 1 || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Size: " + size);
        return true;
    }

    private Node2<T> getNodeByIndex(int index) {
        Node2<T> currentdNode2;
        if (index <= size / 2) { //start from head
            currentdNode2 = head;
            for (int i = 1; i <= index; i++) {
                currentdNode2 = currentdNode2.getNext();
            }
        } else { //start from tail
            currentdNode2 = tail;
            for (int i = size; i >= index; i--) {
                currentdNode2 = currentdNode2.getPrevious();
            }
        }
        return currentdNode2;
    }
}

package hw9;

import lombok.Getter;
import lombok.Setter;

public class MyLinkedList<T> implements MyListCollection<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public void print() {
        if (head == null) {
            System.out.println("No data");
        } else {
            Node<T> currentNode2 = head;
            do {
                System.out.print(currentNode2.getData() + " ");
                currentNode2 = currentNode2.getNext();
            } while (currentNode2 != null);
        }
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
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
                Node<T> deletedNode = getNodeByIndex(index);
                deletedNode.getPrevious().setNext(deletedNode.getNext());
                deletedNode.getNext().setPrevious(deletedNode.getPrevious());
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

    private Node<T> getNodeByIndex(int index) {
        Node<T> currentdNode;
        if (index <= size / 2) { //start from head
            currentdNode = head;
            for (int i = 0; i < index; i++) {
                currentdNode = currentdNode.getNext();
            }
        } else { //start from tail
            currentdNode = tail;
            for (int i = size-1; i > index; i--) {
                currentdNode = currentdNode.getPrevious();
            }
        }
        return currentdNode;
    }

    @Setter
    @Getter
    public class Node<V> {
        private V data;
        private Node<V> next;
        private Node<V> previous;

        public Node(V data) {
            this.data = data;
        }
    }
}

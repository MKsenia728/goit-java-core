package hw9;

import lombok.Getter;

@Getter
public class SingleLinkedList<K, V> {
    private Node<K, V> head;
    private int size;

    public SingleLinkedList() {
        this.size = 0;
    }

    public void add(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
        size++;
    }

    public void remove(K key) {
        if (head.getKey().equals(key)) {
            if (size == 1) {
                head = null;
            } else {
                head = head.getNext();
            }
            size--;
        } else if (size > 1) {
            Node<K, V> previousNode = getPreviousNodeByKey(key);
            if (previousNode != null) {
                previousNode.setNext(previousNode.getNext().getNext());
                size--;
            }
        }
    }

    public boolean contains(K key) {
        Node<K, V> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private Node<K, V> getPreviousNodeByKey(K key) {
        if (head != null) {
            Node<K, V> previousNode = head;
            while (previousNode.getNext() != null) {
                if (key.equals(previousNode.getNext().getKey())) {
                    return previousNode;
                } else {
                    previousNode = previousNode.getNext();
                }
            }
        }
        return null;
    }

    public V get(K key) {
        if (head != null && head.getKey().equals(key)) {
            return head.getValue();
        } else {
            Node<K, V> previousNode = getPreviousNodeByKey(key);
            if (previousNode != null) {
                return previousNode.getNext().getValue();
            }
        }
        return null;
    }
}

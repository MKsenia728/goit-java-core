package hw9;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node2<T> {
    private T data;
    private Node2<T> next;
    private Node2<T> previous;

    public Node2(T data) {
        this.data = data;
    }
}

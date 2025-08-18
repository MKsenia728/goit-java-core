package hw11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list2 = List.of(11, 22, 33, 44, 55, 66, 77, 88, 99, 1010, 1111, 2222);
        Stream<Integer> first = list1.stream();
        Stream<Integer> second = list2.stream();
        Stream<Integer> res = zip(first, second);
        res.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firsrtIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        List<T> result = new ArrayList<>();
        boolean isFirst = true;
        while (firsrtIterator.hasNext() && secondIterator.hasNext()) {
            if (isFirst) {
                result.add(firsrtIterator.next());
            } else {
                result.add(secondIterator.next());
            }
            isFirst = !isFirst;
        }
        return result.stream();
    }
}

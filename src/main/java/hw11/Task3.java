package hw11;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        String[] data = new String[]{"1, 2, 0", "4, 5", "44, 1, ee", "-1"};
        System.out.println(getSortedNumber(data));
    }

    public static String getSortedNumber(String[] data) {
        return Arrays.stream(data)
                .map(d -> d.split(", "))
                .flatMap(Arrays::stream)
                .filter(d -> d.matches("\\d+"))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}

package hw11;

import java.util.Comparator;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Anna", "Nata", "Jon", "Pavel", "Inna", "Oleh", "Igor", "Olga");
        System.out.println(getSortedUpperCasedList(names));
    }

    public static List<String> getSortedUpperCasedList(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();
    }
}

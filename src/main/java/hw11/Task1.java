package hw11;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Anna", "Nata", "Jon", "Pavel", "Inna", "Oleh", "Igor", "Olga");
        Optional<String> oddNames = getOddName(names);
        oddNames.ifPresent(System.out::println);
    }

    public static Optional<String> getOddName(List<String> names) {
        String result = IntStream.range(0, names.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> i + "." + names.get(i))
                .collect(Collectors.joining(", "));

        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }
}

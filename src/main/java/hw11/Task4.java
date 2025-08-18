package hw11;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        Stream<Long> numbers = generateNumbers(25214903917L, 11L, (long) Math.pow(2, 48), 55, 15);
        numbers.forEach(System.out::println);
    }

    public static Stream<Long> generateNumbers(long a, long c, long m, long seed, int limit) {
        return Stream.iterate(seed, x -> (BigInteger.valueOf(a * x).add(BigInteger.valueOf(c)).mod(BigInteger.valueOf(m)).longValue()))
                .limit(limit);
    }
}

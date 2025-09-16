package hw12;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class FizzBuzz {
    @Setter
    @Getter
    private int n;
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private final AtomicBoolean isChange = new AtomicBoolean(false);
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void createFizzBuzz() {
        executor.submit(this::number); // запускаем сразу

        int i = 1;
        while (i <= n) {
            isChange.set(false);
            int num = i;

            Future<?> fizz = executor.submit(() -> checkNumber(num, this::fizz));
            Future<?> buzz = executor.submit(() -> checkNumber(num, this::buzz));
            Future<?> fizzbuzz = executor.submit(() -> checkNumber(num, this::fizzbuzz));

            try {
                fizz.get();
                buzz.get();
                fizzbuzz.get();
                if (!isChange.get()) {
                    queue.put(String.valueOf(num));
                }
                i++;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
    }

    private void checkNumber(int num, CheckCallback callback) {
        String res = callback.check(num);
        if (res != null) {
            try {
                isChange.set(true);
                queue.put(res);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String fizz(int num) {
        return num % 3 == 0 && num % 5 != 0 ? "fizz" : null;
    }

    private String buzz(int num) {
        return (num % 3 != 0 && num % 5 == 0) ? "buzz" : null;
    }

    private String fizzbuzz(int num) {
        return (num % 15 == 0) ? "fizzbuzz" : null;
    }

    private void number() {
        try {
            for (int i = 1; i <= n; i++) {
                String value = queue.take();
                if (i == n ) {
                    System.out.print(value);
                } else {
                    System.out.print(value + ",");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
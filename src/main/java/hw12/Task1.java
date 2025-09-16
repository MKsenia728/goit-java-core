package hw12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) {
        ScheduledExecutorService schedules = Executors.newScheduledThreadPool(2);
        long start = System.nanoTime();
        schedules.scheduleAtFixedRate(
                () -> System.out.println((System.nanoTime() - start)/ 1_000_000_000),
                0,
                1,
                TimeUnit.SECONDS);

        schedules.scheduleAtFixedRate(
                () -> System.out.println("Минуло 5 секунд"),
                5,
                5,
                TimeUnit.SECONDS);
    }
}

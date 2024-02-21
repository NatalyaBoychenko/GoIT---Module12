package task2.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(() -> {
            try {
                fizzBuzz.fizz(()-> System.out.println("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(() -> {
            try {
                fizzBuzz.buzz(()-> System.out.println("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(() -> {
            try {
                fizzBuzz.fizzbuzz(()-> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}

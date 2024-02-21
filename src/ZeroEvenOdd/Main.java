package ZeroEvenOdd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> {
            try {
                zeroEvenOdd.zero(number -> System.out.print(number));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        executor.execute(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

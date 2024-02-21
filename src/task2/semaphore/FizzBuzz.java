package task2.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private Semaphore lock;
    private int initial = 1;


    public FizzBuzz(int n) {
        this.n = n;
        this.lock = new Semaphore(1);

    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {

        while (initial< n) {

            if (initial % 3 == 0 && initial % 5 != 0) { lock.acquire();
                printFizz.run();
                initial++;lock.release();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {


        while (initial < n) {

            if (initial % 5 == 0 && initial % 3 != 0) {lock.acquire();
                printBuzz.run();
                initial++;lock.release();
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {


        while (initial < n) {

            if (initial % 15 == 0) {  lock.acquire();
                printFizzBuzz.run();
                initial++;lock.release();
            }

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {


        while (initial < n) {

            if (initial % 3 != 0 && initial % 5 != 0) { lock.acquire();
                printNumber.accept(initial);
                initial++;lock.release();
            }

        }
    }
}
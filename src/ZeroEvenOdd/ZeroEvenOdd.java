package ZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private Semaphore s0;
    private Semaphore sEven;
    private Semaphore sOdd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.s0 = new Semaphore(1);
        this.sEven = new Semaphore(0);
        this.sOdd = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            s0.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                sEven.release();
            }else {
                sOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= this.n; i += 2) {
            sEven.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i += 2) {
            sOdd.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }
}

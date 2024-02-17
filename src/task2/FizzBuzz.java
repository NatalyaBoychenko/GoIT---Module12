package task2;

public class FizzBuzz {
    private int initial = 1;
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() {
        while (initial <= n) {
            if (initial % 3 == 0 && initial % 5 != 0) {
                System.out.print("fizz");
                if (initial != n){
                    System.out.print(", ");
                }
                initial++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz() {
        while (initial <= n) {
            if (initial % 5 == 0 && initial % 3 != 0) {
                System.out.print("buzz");
                if (initial != n){
                    System.out.print(", ");
                }
                initial++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzBuzz() {
        while (initial <= n) {
            if (initial % 3 == 0 && initial % 5 == 0) {
                System.out.print("fizzbuzz");
                if (initial != n){
                    System.out.print(", ");
                }
                initial++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void number() {
        while (initial <= n) {
            if (initial % 3 != 0 && initial % 5 != 0) {
                System.out.print(initial );
                if (initial != n){
                    System.out.print(", ");
                }
                initial++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

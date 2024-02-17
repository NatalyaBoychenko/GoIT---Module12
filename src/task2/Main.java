package task2;

public class Main {
    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread A = new Thread(fizzBuzz::fizz);
        Thread B = new Thread(fizzBuzz::buzz);
        Thread C = new Thread(fizzBuzz::fizzBuzz);
        Thread D = new Thread(fizzBuzz::number);

        A.start();
        B.start();
        C.start();
        D.start();
    }
}

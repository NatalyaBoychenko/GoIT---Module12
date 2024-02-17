public class Task1 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() ->
        {

            long begin = System.currentTimeMillis();
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Program was started " + (System.currentTimeMillis() - begin)/1000 + " sec ago");
            }
        });

        Thread thread2 = new Thread(() ->
        {
            while(true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("5 minutes have passed");
            }
        });

        thread1.start();
        thread2.start();
    }
}

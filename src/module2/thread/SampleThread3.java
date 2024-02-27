package module2.thread;

public class SampleThread3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for (int i = 1; i <= 100; i++)  {
                System.out.println("Printing..." + i);
            }
        });
        thread1.start();
    }
}

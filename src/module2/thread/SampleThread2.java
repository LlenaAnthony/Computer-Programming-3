package module2.thread;

public class SampleThread2 {
    public static void main(String[] args) {


        Thread thread1 = new Thread(new SampleThread1(20, "Thread 1"));
        Thread thread2 = new Thread(new SampleThread1(5, "Thread 2"));
        Thread thread3 = new Thread(new SampleThread1(15, "Thread 3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

package module2.thread;

public class SampleThread1 extends Thread{
    private int max;

    public SampleThread1(int number, String id){
        super(id);
        max = number;
    }

    public void run(){
        for (int i = 1; i <= max; i++){
            System.out.println(this.getName()+": printing" + i);
        }
    }

    public static void main(String[] args){
        SampleThread1 thread1 = new SampleThread1(10, "Thread 1");
        SampleThread1 thread2 = new SampleThread1(5, " Thread 2");
        SampleThread1 thread3 = new SampleThread1(15, "Thread 3");

        try {
            thread1.join();
            thread2.join();
            thread2.join();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Main thread is about to be exit... ");
    }
}

public class MyFirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("Threading has started");
        System.out.println("Thread is " + Thread.currentThread().getName());
    }
}
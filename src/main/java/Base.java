public class Base {
    public static void main(String[] args) {
        System.out.println("Beep boop! Main thread is: " + Thread.currentThread().getName());

        Runnable runnable = () -> System.out.println("Current thread is: " + Thread.currentThread().getName());

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        MyFirstThread thread3 = new MyFirstThread();
        thread3.start();
        thread1.start();
        thread2.start();
        System.out.println("Beep boop! Leaving main thread");
    }
}

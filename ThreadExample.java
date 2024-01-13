class MyThread extends Thread {
    public void run() {
        // Code that will run in a separate thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + Thread.currentThread().getId() + ", Count: " + i);
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        // Start the threads
        thread1.start();
        thread2.start();
    }
}

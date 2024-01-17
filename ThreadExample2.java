class MyRunnable implements Runnable {
    public void run() {
        // Code that will run in a separate thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + Thread.currentThread().getId() + ", Count: " + i);
        }
    }
}

public class ThreadExample2 {
    public static void main(String args[]) {
        MyRunnable myRunnable = new MyRunnable();

        // Create threads using the Runnable interface
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);

        // Start the threads
        thread1.start();
        thread2.start();
    }
}

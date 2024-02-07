import java.util.concurrent.atomic.AtomicInteger;

class SharedResource {
    // Using volatile keyword to ensure visibility across threads
    private volatile int sharedVariable = 0;

    // Using Atomic class for thread-safe operations
    private AtomicInteger atomicCounter = new AtomicInteger(0);

    // Method using synchronized keyword for mutually exclusive access
    public synchronized void synchronizedMethod() {
        // Critical section - only one thread can execute this block at a time
        sharedVariable++;
    }

    // Method using volatile for visibility and Atomic class for atomic increment
    public void atomicMethod() {
        // Atomic operation using AtomicInteger
        atomicCounter.incrementAndGet();
    }

    // Getter for sharedVariable
    public int getSharedVariable() {
        return sharedVariable;
    }

    // Getter for atomicCounter
    public int getAtomicCounter() {
        return atomicCounter.get();
    }
}

public class ThreadSafetyExample {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Creating two threads to access the shared resource
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedResource.synchronizedMethod();
                sharedResource.atomicMethod();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedResource.synchronizedMethod();
                sharedResource.atomicMethod();
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the results
        System.out.println("Shared Variable (using synchronized): " + sharedResource.getSharedVariable());
        System.out.println("Atomic Counter (using Atomic class): " + sharedResource.getAtomicCounter());
    }
}

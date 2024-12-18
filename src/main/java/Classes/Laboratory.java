package Classes;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class Laboratory {
    private String name;
    private String location;
    private String[] testTypes;
    private String[] results;
    private int testCount;

    // Connection Pool (5 connections)
    private final BlockingQueue<Connection> connectionPool;
    private final ExecutorService threadPool; // Thread pool with 7 threads

    public Laboratory(String name, String location, int maxTests) {
        this.name = name;
        this.location = location;
        this.testTypes = new String[maxTests];
        this.results = new String[maxTests];
        this.testCount = 0;

        // Initialize connection pool with 5 available connections
        this.connectionPool = new LinkedBlockingQueue<>(5);  // Max size of 5 connections
        this.threadPool = Executors.newFixedThreadPool(7);  // 7 threads to simulate requests

        // Initialize the pool with 5 connections
        for (int i = 0; i < 5; i++) {
            connectionPool.offer(new Connection(i + 1));  // Adding 5connections to the pool
        }
    }

    public CompletableFuture<Void> addTestAsync(int threadId, String testType, String result) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Connection connection = connectionPool.take();  // Block if the pool is empty
                System.out.println("Thread " + threadId + " acquired connection: " + connection.getId());

                addTest(testType, result);
                Thread.sleep(2000);
                connectionPool.offer(connection);  // Put the connection back to the pool

                System.out.println("Thread " + threadId + " released connection: " + connection.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread " + threadId + " was interrupted.");
            }
            return null;
        }, threadPool);
    }

    // Simulate adding test details
    public void addTest(String testType, String result) {
        if (testCount < testTypes.length) {
            testTypes[testCount] = testType;
            results[testCount] = result;
            testCount++;
        } else {
            System.out.println("No more tests can be added.");
        }
    }

    // Return a string representation of the laboratory details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Laboratory Name: ").append(name).append("\n")
          .append("Location: ").append(location).append("\n")
          .append("Tests and Results:\n");
        for (int i = 0; i < testCount; i++) {
            sb.append("Test: ").append(testTypes[i])
              .append(" - Result: ").append(results[i]).append("\n");
        }
        return sb.toString();
    }

    // Shutdown the thread pool
    public void shutdown() {
        try {
            threadPool.shutdown();
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
        }
    }

    public static void main(String[] args) {
        Laboratory lab = new Laboratory("Central Lab", "New York", 10);

        // Start 7 threads to simulate test requests
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            final int threadId = i;
            futures.add(lab.addTestAsync(threadId, "Test-" + threadId, "Result-" + threadId));
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        lab.shutdown();
        System.out.println("All threads have finished processing.");
    }
}

// Connection class to simulate a connection
class Connection {
    private final int id;

    public Connection(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Connection-" + id;
    }
}

package Classes;

public class InsuranceRunnable implements Runnable {
    private Insurance insurance;

    // Constructor to initialize Insurance
    public InsuranceRunnable(Insurance insurance) {
        this.insurance = insurance;
    }

    @Override
    public void run() {
        System.out.println("Processing Insurance in Runnable: " + insurance);
        // Simulating some processing delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package Classes;

public enum TransactionStatus {
    PENDING("Pending", 0),
    COMPLETED("Completed", 1),
    FAILED("Failed", -1),
    CANCELLED("Cancelled", -2);

    private final String status;
    private final int code;

    TransactionStatus(String status, int code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    // Method to check if the transaction was successful
    public boolean isSuccessful() {
        return code == 1;
    }

    @Override
    public String toString() {
        return status + " (Code: " + code + ")";
    }
}

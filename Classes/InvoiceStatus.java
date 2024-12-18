package Classes;

public enum InvoiceStatus {
    UNPAID("Unpaid", 0),
    PAID("Paid", 1),
    PARTIALLY_PAID("Partially Paid", 0.5),
    CANCELED("Canceled", -1);

    private final String status;
    private final double paymentStatus;

    InvoiceStatus(String status, double paymentStatus) {
        this.status = status;
        this.paymentStatus = paymentStatus;
    }

    public String getStatus() {
        return status;
    }

    public double getPaymentStatus() {
        return paymentStatus;
    }

    // Method to check if the invoice is fully paid
    public boolean isPaid() {
        return paymentStatus == 1;
    }

    @Override
    public String toString() {
        return status + " (Payment Status: " + paymentStatus * 100 + "%)";
    }
}

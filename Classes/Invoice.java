package Classes;

import java.util.Date;

public final class Invoice {
    private final String invoiceNumber;   
    private final String customerName;    
    private final Date invoiceDate;     
    private final String serviceName;   
    private int quantity;          
    private double unitPrice;      
    private double totalAmount;    //calculated as quantity * unitPrice
    private boolean paymentStatus; //the payment has been made (true if paid)

    //Constructor
    public Invoice(String invoiceNumber, String customerName, Date invoiceDate, String serviceName, int quantity, double unitPrice) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.serviceName = serviceName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalAmount = quantity * unitPrice; //calculate total amount based on quantity and unit price
        this.paymentStatus = false; //default payment status is unpaid
    }

    //get - set
    public final String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
    }

    public final String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
    }

    public final Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
    }

    public final String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
    }

    public int getQuantity() {
        return quantity;
    }

    //updates totalAmount when quantity changes
    public final void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalAmount = quantity * unitPrice; //recalculate total amount
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        this.totalAmount = quantity * unitPrice;
    }

    public final double getTotalAmount() {
        return totalAmount;
    }

    // Getter for paymentStatus (returns true if paid)
    public final boolean isPaymentStatus() {
        return paymentStatus;
    }

    public final void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public final void markAsPaid() {
        this.paymentStatus = true; //set payment status to true when payment is made
    }

    //to return a string representation of the invoice details
    @Override
    public final String toString() {
        return "Invoice{" +
                "Invoice Number='" + invoiceNumber + '\'' +
                ", Customer Name='" + customerName + '\'' +
                ", Invoice Date=" + invoiceDate +
                ", Service Name='" + serviceName + '\'' +
                ", Quantity=" + quantity +
                ", Unit Price=" + unitPrice +
                ", Total Amount=" + totalAmount +
                ", Payment Status=" + (paymentStatus ? "Paid" : "Unpaid") +  // Display payment status
                '}';
    }
}

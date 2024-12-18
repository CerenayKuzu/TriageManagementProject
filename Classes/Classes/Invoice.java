package Classes;

import Exceptions.InvalidInvoiceException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class Invoice {
    private final String invoiceNumber;
    private final String customerName;
    private final Date invoiceDate;
    private final String serviceName;
    private int quantity;
    private double unitPrice;
    private double totalAmount;
    private InvoiceStatus status; // InvoiceStatus yerine eski boolean paymentStatus

    // Constructor
    public Invoice(String invoiceNumber, String customerName, Date invoiceDate, String serviceName, int quantity, double unitPrice) throws InvalidInvoiceException {
        if (quantity <= 0) {
            throw new InvalidInvoiceException("Quantity must be greater than zero.");
        }

        if (unitPrice <= 0) {
            throw new InvalidInvoiceException("Unit price must be greater than zero.");
        }

        if (invoiceNumber == null || invoiceNumber.isEmpty()) {
            throw new InvalidInvoiceException("Invoice number cannot be null or empty.");
        }

        if (customerName == null || customerName.isEmpty()) {
            throw new InvalidInvoiceException("Customer name cannot be null or empty.");
        }

        if (invoiceDate == null) {
            throw new InvalidInvoiceException("Invoice date cannot be null.");
        }

        if (serviceName == null || serviceName.isEmpty()) {
            throw new InvalidInvoiceException("Service name cannot be null or empty.");
        }

        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.serviceName = serviceName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalAmount = quantity * unitPrice;
        this.status = InvoiceStatus.UNPAID; // Default status is UNPAID
    }

    // Getters and Setters
    public final String getInvoiceNumber() {
        return invoiceNumber;
    }

    public final String getCustomerName() {
        return customerName;
    }

    public final Date getInvoiceDate() {
        return invoiceDate;
    }

    public final String getServiceName() {
        return serviceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) throws InvalidInvoiceException {
        if (quantity <= 0) {
            throw new InvalidInvoiceException("Quantity must be greater than zero.");
        }

        this.quantity = quantity;
        this.totalAmount = quantity * unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(double unitPrice) throws InvalidInvoiceException {
        if (unitPrice <= 0) {
            throw new InvalidInvoiceException("Unit price must be greater than zero.");
        }

        this.unitPrice = unitPrice;
        this.totalAmount = quantity * unitPrice;
    }

    public final double getTotalAmount() {
        return totalAmount;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    // Set the payment status using InvoiceStatus
    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public void markAsPaid() {
        this.status = InvoiceStatus.PAID; // Change the status to PAID
    }

    public void markAsPartiallyPaid() {
        this.status = InvoiceStatus.PARTIALLY_PAID; // Change the status to PARTIALLY PAID
    }

    public void cancelInvoice() {
        this.status = InvoiceStatus.CANCELED; // Change the status to CANCELED
    }

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
                ", Payment Status=" + status.getStatus() + " (" + status.getPaymentStatus() * 100 + "%)" + 
                '}';
    }

    // Lambda-based methods
    public static List<Invoice> filterUnpaidInvoices(List<Invoice> invoices) {
        // Filter unpaid invoices using lambda
        return invoices.stream()
                .filter(invoice -> invoice.getStatus() == InvoiceStatus.UNPAID)
                .collect(Collectors.toList());
    }

    public static List<Invoice> filterInvoicesByCustomer(List<Invoice> invoices, String customerName) {
        // Filter invoices by customer name using lambda
        return invoices.stream()
                .filter(invoice -> invoice.getCustomerName().equalsIgnoreCase(customerName))
                .collect(Collectors.toList());
    }

    public static double calculateTotalRevenue(List<Invoice> invoices) {
        // Calculate total revenue using lambda
        return invoices.stream()
                .filter(invoice -> invoice.getStatus() == InvoiceStatus.PAID) // Only include paid invoices
                .mapToDouble(Invoice::getTotalAmount)
                .sum();
    }

    public static void updateQuantities(List<Invoice> invoices, int increment) {
        // Increment quantities for all invoices using lambda
        invoices.forEach(invoice -> {
            try {
                invoice.setQuantity(invoice.getQuantity() + increment);
            } catch (InvalidInvoiceException e) {
                System.out.println("Error updating quantity for invoice: " + invoice.getInvoiceNumber());
            }
        });
    }
}

package Classes;

import Exceptions.TransactionFailedException;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionRecord {
    private String transactionId;
    private int patientId;
    private String transactionType;
    private double amount;
    private String date;
    private String description;
    private TransactionStatus status;  // Transaction status'ı ekledik

    // Constructor
    public TransactionRecord(String transactionId, int patientId, String transactionType, double amount, String date, String description) throws TransactionFailedException {
        this.transactionId = transactionId;
        this.patientId = patientId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.status = TransactionStatus.PENDING;  // Başlangıç durumu PENDING olarak ayarlandı
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    // Process the transaction and update the status
    public void processTransaction() throws TransactionFailedException {
        if (amount <= 0) {
            status = TransactionStatus.FAILED; // Eğer işlem tutarı sıfır ya da negatifse işlem başarısız olarak işaretlenir
            throw new TransactionFailedException("Transaction amount must be greater than zero. Transaction ID: " + transactionId);
        }

        status = TransactionStatus.COMPLETED;  // İşlem başarılıysa durumu COMPLETED olarak ayarlarız
        System.out.println("Transaction processed successfully: " + this);
    }

    // Lambda-based methods
    public static List<TransactionRecord> filterTransactionsByType(List<TransactionRecord> transactions, String type) {
        // Filter transactions by type using a lambda
        return transactions.stream()
                .filter(transaction -> transaction.getTransactionType().equalsIgnoreCase(type) && transaction.getStatus().isSuccessful())
                .collect(Collectors.toList());
    }

    public static List<TransactionRecord> updateDescriptions(List<TransactionRecord> transactions, String newDescription) {
        // Update descriptions for all transactions using a lambda
        transactions.forEach(transaction -> transaction.setDescription(newDescription));
        return transactions;
    }

    public static double calculateTotalAmount(List<TransactionRecord> transactions) {
        // Calculate the total amount using a lambda (only successful transactions)
        return transactions.stream()
                .filter(transaction -> transaction.getStatus().isSuccessful())  // Only successful transactions
                .mapToDouble(TransactionRecord::getAmount)
                .sum();
    }

    // Represent the TransactionRecord object as a string
    @Override
    public String toString() {
        return "TransactionRecord{" +
                "Transaction ID='" + transactionId + '\'' +
                ", Patient ID=" + patientId +
                ", Transaction Type='" + transactionType + '\'' +
                ", Amount=" + amount +
                ", Date='" + date + '\'' +
                ", Description='" + description + '\'' +
                ", Status=" + status +  // Durumu da string olarak ekledik
                '}';
    }
}

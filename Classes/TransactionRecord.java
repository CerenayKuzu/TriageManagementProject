package Classes;

public class TransactionRecord {
    private String transactionId;
    private int patientId;
    private String transactionType;
    private double amount;
    private String date;
    private String description;

    //Constructor
    public TransactionRecord(String transactionId, int patientId, String transactionType, double amount, String date, String description){
        this.transactionId = transactionId;
        this.patientId = patientId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    //get - set
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

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //to represent the TransactionRecord object as a string
    @Override
    public String toString() {
        return "TransactionRecord{" +
                "Transaction ID='" + transactionId + '\'' +
                ", Patient ID=" + patientId +
                ", Transaction Type='" + transactionType + '\'' +
                ", Amount=" + amount +
                ", Date='" + date + '\'' +
                ", Description='" + description + '\'' +
                '}';
    }




}
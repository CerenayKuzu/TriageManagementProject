import java.util.concurrent.TimeUnit;

public class PatientRecord {
    private String patient;
    private String date;
    private String details;

    private static ConnectionPool connectionPool = new ConnectionPool();

    // Constructor
    public PatientRecord(String patient, String date, String details) {
        this.patient = patient;
        this.date = date;
        this.details = details;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void saveToDatabase() {
        try {
            Connection connection = connectionPool.getConnection();
            connection.connect(); 


            System.out.println("Patient record is added to the database: " + this.toString());


            TimeUnit.SECONDS.sleep(2); 

            connection.disconnect(); 
            connectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Patient: " + patient + ", Date: " + date + ", Details: " + details;
    }
}

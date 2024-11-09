package Classes;

public class PatientRecord {
    private String patient;
    private String date;
    private String details;
    
    //Constructor
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
    
    //easier to display the record's information
    @Override
    public String toString() {
        return details;
    }
    
}

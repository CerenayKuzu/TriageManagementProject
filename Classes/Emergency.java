package Classes;

public abstract class Emergency {
    private int emergencyId;
    private int patientId;
    private String emergencyType;
    private String symptoms;
    private String severity;
    private boolean isTreated; //Flag indicating whether the emergency has been treated (true if treated)


    //Constructor
    public Emergency(int emergencyId, int patientId, String emergencyType, String symptoms, String severity){
        this.emergencyId = emergencyId;
        this.patientId = patientId;
        this.emergencyType = emergencyType;
        this.symptoms = symptoms;
        this.severity = severity;
        this.isTreated = false; // Initially, the emergency is not treated
    }

    //get - set
    public int getEmergencyId(){
        return emergencyId;
    }
    public void setEmergencyId(int emergencyId){
        this.emergencyId = emergencyId;
    }
    
    public int getPatientId(){
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getEmergencyType(){
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType){
        this.emergencyType = emergencyType;
    }
    
    public String getSymptoms(){
        return symptoms;
    }

    public void setSymptoms(String symptoms){
        this.symptoms = symptoms;
    }

    public String getSeverity(){
        return severity;
    }

    public void setSeverity(String severity){
        this.severity = severity;
    }

    //checks if the emergency has been treated
    public boolean isTreated() {
        return isTreated;
    }

    public void setTreated(boolean treated){
        isTreated = treated;
    }

    //method to mark the emergency as treated
    public void treatEmergency() {
        this.isTreated = true; //change the status to treated
    }

    //provide a string representation of the emergency
    @Override
    public String toString(){
        return "Emergency{" +
                "emergencyId=" + emergencyId +
                ", patientId=" + patientId +
                ", emergencyType='" + emergencyType + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", severity='" + severity + '\'' +
                ", isTreated=" + (isTreated ? "Treated" : "Not treated") + //display whether the emergency is treated or not
                '}';
    }

    public abstract void handleEmergency();


}

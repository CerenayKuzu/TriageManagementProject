package Classes;

public class MedicalHistory {
    private String patientId;
    private String previousIllnesses;
    private String surgeries;
    private String allergies;
    private String medications;

    //Constructor
    public MedicalHistory(String patientId, String previousIllnesses, String surgeries, String allergies, String medications) {
        this.patientId = patientId;
        this.previousIllnesses = previousIllnesses;
        this.surgeries = surgeries;
        this.allergies = allergies;
        this.medications = medications;
    }

    //get - set
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPreviousIllnesses() {
        return previousIllnesses;
    }

    public void setPreviousIllnesses(String previousIllnesses) {
        this.previousIllnesses = previousIllnesses;
    }

    public String getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(String surgeies) {
        this.surgeries = surgeies;
    }

    public String getAllegies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }
    
    //to display the medical history details in a readable format
    @Override
    public String toString() {
        return "MedicalHistory{" +
                "Patient ID='" + patientId + '\'' +
                ", Previous Illnesses='" + previousIllnesses + '\'' +
                ", Surgeries='" + surgeries + '\'' +
                ", Allergies='" + allergies + '\'' +
                ", Medications='" + medications + '\'' +
                '}';
    }

}

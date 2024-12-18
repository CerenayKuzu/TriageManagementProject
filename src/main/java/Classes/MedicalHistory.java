package Classes;

import Interfaces.IMedicalHistory;

public class MedicalHistory implements IMedicalHistory {
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

    @Override
    public String getPatientId() {
        return patientId;
    }
    
    @Override
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @Override
    public String getPreviousIllnesses() {
        return previousIllnesses;
    }

    @Override
    public void setPreviousIllnesses(String previousIllnesses) {
        this.previousIllnesses = previousIllnesses;
    }
    
    @Override
    public String getSurgeries() {
        return surgeries;
    }

    @Override
    public void setSurgeries(String surgeies) {
        this.surgeries = surgeies;
    }

    @Override
    public String getAllergies() {
        return allergies;
    }
    
    @Override
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    
    @Override
    public String getMedications() {
        return medications;
    }

    @Override
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

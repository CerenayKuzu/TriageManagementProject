package Interfaces;

public interface IMedicalHistory {
    String getPatientId();
    String getPreviousIllnesses();
    String getSurgeries();
    String getAllergies();
    String getMedications();

    void setPatientId(String patientId);
    void setPreviousIllnesses(String previousIllnesses);
    void setSurgeries(String surgeries);
    void setAllergies(String allergies);
    void setMedications(String medications);
}

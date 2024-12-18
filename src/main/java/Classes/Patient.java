package Classes;

import Interfaces.IMedicalHistory;

public class Patient implements IMedicalHistory {
    private int id;
    private String name;
    private String surname;

    private String previousIllnesses;
    private String surgeries;
    private String allergies;
    private String medications;

    private PatientStatus status;  // Enum ekleniyor

    private static int patientCount = 0;

    public Patient(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.previousIllnesses = "Unknown";
        this.surgeries = "None";
        this.allergies = "None";
        this.medications = "None";
        this.status = PatientStatus.STABLE;  // Varsayılan durum
        patientCount++;
    }

    // Constructor with full details
    public Patient(int id, String name, String surname, String previousIllnesses, String surgeries, String allergies, String medications, PatientStatus status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.previousIllnesses = previousIllnesses;
        this.surgeries = surgeries;
        this.allergies = allergies;
        this.medications = medications;
        this.status = status;  // Patient status is set
        patientCount++;
    }

    static {
        System.out.println("Patient class loaded. Ready to manage patients.");
    }

    // Getter and Setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static int getPatientCount() {
        return patientCount;
    }

    // Enum Getter and Setter for PatientStatus
    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
        this.status.performAction();  // Status değiştiğinde ilgili aksiyon çağrılır
    }

    // Medical History methods from IMedicalHistory
    @Override
    public String getPatientId() {
        return String.valueOf(this.id);
    }

    @Override
    public String getPreviousIllnesses() {
        return previousIllnesses;
    }

    @Override
    public String getSurgeries() {
        return surgeries;
    }

    @Override
    public String getAllergies() {
        return allergies;
    }

    @Override
    public String getMedications() {
        return medications;
    }

    @Override
    public void setPatientId(String patientId) {
        this.id = Integer.parseInt(patientId);
    }

    @Override
    public void setPreviousIllnesses(String previousIllnesses) {
        this.previousIllnesses = previousIllnesses;
    }

    @Override
    public void setSurgeries(String surgeries) {
        this.surgeries = surgeries;
    }

    @Override
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public void setMedications(String medications) {
        this.medications = medications;
    }

    public static void displayPatientInfo() {
        System.out.println("This is a generic patient. More details can be added as needed.");
    }

    @Override
    public String toString() {
        return "Patient{id=" + id + 
               ", name='" + name + 
               "', surname='" + surname + 
               "', previousIllnesses='" + previousIllnesses + 
               "', surgeries='" + surgeries + 
               "', allergies='" + allergies + 
               "', medications='" + medications + 
               "', status=" + status + 
               '}';
    }
}

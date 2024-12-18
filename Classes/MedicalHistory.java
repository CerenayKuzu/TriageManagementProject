package Classes;

import Interfaces.IMedicalHistory;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class MedicalHistory implements IMedicalHistory {
    private String patientId;
    private String previousIllnesses;
    private String surgeries;
    private String allergies;
    private String medications;

    // Constructor
    public MedicalHistory(String patientId, String previousIllnesses, String surgeries, String allergies, String medications) {
        this.patientId = patientId;
        this.previousIllnesses = previousIllnesses;
        this.surgeries = surgeries;
        this.allergies = allergies;
        this.medications = medications;
    }

    // Getter and Setter methods
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
    public void setSurgeries(String surgeries) {
        this.surgeries = surgeries;
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

    // to display the medical history details in a readable format
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

    // Lambda Functions (Generic)

    public static void applyToMedicalHistory(List<MedicalHistory> medicalHistories, Function<MedicalHistory, String> function) {
        for (MedicalHistory medicalHistory : medicalHistories) {
            System.out.println(function.apply(medicalHistory));
        }
    }

    public static void filterMedicalHistories(List<MedicalHistory> medicalHistories, Predicate<MedicalHistory> predicate) {
        for (MedicalHistory medicalHistory : medicalHistories) {
            if (predicate.test(medicalHistory)) {
                System.out.println(medicalHistory);
            }
        }
    }

    public static void printMedicalHistoryDetails(List<MedicalHistory> medicalHistories, Consumer<MedicalHistory> consumer) {
        for (MedicalHistory medicalHistory : medicalHistories) {
            consumer.accept(medicalHistory);
        }
    }

    public static void main(String[] args) {
        List<MedicalHistory> medicalHistories = Arrays.asList(
                new MedicalHistory("P123", "Asthma", "Knee Surgery", "Penicillin", "Albuterol"),
                new MedicalHistory("P124", "Diabetes", "Appendectomy", "None", "Metformin"),
                new MedicalHistory("P125", "Hypertension", "No Surgeries", "Shellfish", "Amlodipine")
        );


        applyToMedicalHistory(medicalHistories, medicalHistory -> "Patient " + medicalHistory.getPatientId() + " has allergies to " + medicalHistory.getAllergies());


        filterMedicalHistories(medicalHistories, medicalHistory -> "Penicillin".equals(medicalHistory.getAllergies()));


        printMedicalHistoryDetails(medicalHistories, medicalHistory -> System.out.println(medicalHistory.toString()));
    }
}

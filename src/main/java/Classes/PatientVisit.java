package Classes;

import java.util.ArrayList;
import java.util.List;

public class PatientVisit {
    private int patientId;
    private List<VisitRecord> visitRecords; // List to store multiple visit records for a patient

    // Constructor
    public PatientVisit(int patientId) {
        this.patientId = patientId;
        this.visitRecords = new ArrayList<>(); // Initialize the visitRecords list
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public List<VisitRecord> getVisitRecords() {
        return visitRecords;
    }

    // Add a new visit record
    public void addVisit(String visitorName, String visitDate) {
        VisitRecord newVisit = new VisitRecord(visitorName, visitDate);
        visitRecords.add(newVisit);
        System.out.println("New visit added: " + newVisit);
    }

    // Remove a specific visit record
    public void removeVisit(String visitorName, String visitDate) {
        visitRecords.removeIf(visit -> visit.getVisitorName().equals(visitorName) && visit.getVisitDate().equals(visitDate));
        System.out.println("Visit by " + visitorName + " on " + visitDate + " removed.");
    }

    // Clear all visit records
    public void clearVisits() {
        visitRecords.clear();
        System.out.println("All visit records cleared.");
    }

    @Override
    public String toString() {
        return "PatientVisit{" +
                "Patient ID=" + patientId +
                ", Visit Records=" + visitRecords +
                '}';
    }

    // Inner class to represent individual visit records
    private static class VisitRecord {
        private String visitorName;
        private String visitDate;

        public VisitRecord(String visitorName, String visitDate) {
            this.visitorName = visitorName;
            this.visitDate = visitDate;
        }

        public String getVisitorName() {
            return visitorName;
        }

        public String getVisitDate() {
            return visitDate;
        }

        @Override
        public String toString() {
            return "VisitRecord{" +
                    "Visitor Name='" + visitorName + '\'' +
                    ", Visit Date='" + visitDate + '\'' +
                    '}';
        }
    }
}

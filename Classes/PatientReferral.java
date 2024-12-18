package Classes;

import Exceptions.InvalidReferralException;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PatientReferral {
    private int patientId;
    private String patientName;
    private String referralDepartment;
    private String referralReason;
    private String referralDate;
    private String referredBy; // The medical professional who made the referral
    private List<String> notes; // List of notes for the referral

    // Constructor
    public PatientReferral(int patientId, String patientName, String referralDepartment, String referralReason, String referralDate, String referredBy) throws InvalidReferralException {
        if (referralDepartment == null || referralDepartment.isEmpty()) {
            throw new InvalidReferralException("Referral department cannot be empty.");
        }
        if (referralReason == null || referralReason.isEmpty()) {
            throw new InvalidReferralException("Referral reason cannot be empty.");
        }

        this.patientId = patientId;
        this.patientName = patientName;
        this.referralDepartment = referralDepartment;
        this.referralReason = referralReason;
        this.referralDate = referralDate;
        this.referredBy = referredBy;
        this.notes = new ArrayList<>(); // Initialize notes as an empty list
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getReferralDepartment() {
        return referralDepartment;
    }

    public void setReferralDepartment(String referralDepartment) throws InvalidReferralException {
        if (referralDepartment == null || referralDepartment.isEmpty()) {
            throw new InvalidReferralException("Referral department cannot be empty.");
        }
        this.referralDepartment = referralDepartment;
    }

    public String getReferralReason() {
        return referralReason;
    }

    public void setReferralReason(String referralReason) throws InvalidReferralException {
        if (referralReason == null || referralReason.isEmpty()) {
            throw new InvalidReferralException("Referral reason cannot be empty.");
        }
        this.referralReason = referralReason;
    }

    public String getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(String referralDate) {
        this.referralDate = referralDate;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void addNote(String note) {
        notes.add(note);
        System.out.println("Note added: " + note);
    }

    public void removeNote(String note) {
        if (notes.remove(note)) {
            System.out.println("Note removed: " + note);
        } else {
            System.out.println("Note not found.");
        }
    }

    // Collection Streaming Methods

    public static List<PatientReferral> filterReferralsByDepartment(List<PatientReferral> referrals, String department) {
        return referrals.stream()
                .filter(referral -> referral.getReferralDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }


    public List<String> getSortedReferralReasons(List<PatientReferral> referrals) {
        return referrals.stream()
                .map(PatientReferral::getReferralReason)  
                .sorted() 
                .collect(Collectors.toList());
    }

    public static long countReferralsByDepartment(List<PatientReferral> referrals, String department) {
        return referrals.stream()
                .filter(referral -> referral.getReferralDepartment().equalsIgnoreCase(department))
                .count();
    }

    public static PatientReferral getReferralByReferredBy(List<PatientReferral> referrals, String referredBy) {
        return referrals.stream()
                .filter(referral -> referral.getReferredBy().equalsIgnoreCase(referredBy))
                .findFirst()
                .orElse(null); // If no match, return null
    }


    public long countNotes() {
        return notes.stream().count();
    }

    public boolean hasNotes() {
        return notes.stream().anyMatch(note -> note != null && !note.isEmpty());
    }

    @Override
    public String toString() {
        return "PatientReferral{" +
                "Patient ID=" + patientId +
                ", Patient Name='" + patientName + '\'' +
                ", Referral Department='" + referralDepartment + '\'' +
                ", Referral Reason='" + referralReason + '\'' +
                ", Referral Date='" + referralDate + '\'' +
                ", Referred By='" + referredBy + '\'' +
                ", Notes=" + notes +
                '}';
    }
}

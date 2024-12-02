package Classes;

import Exceptions.InvalidReferralException;

public class PatientReferral {
    private int patientId;
    private String patientName;
    private String referralDepartment;
    private String referralReason;
    private String referralDate;
    private String referredBy; // The medical professional who made the referral

    //Constructor
    public PatientReferral(int patientId, String patientName, String referralDepartment, String referralReason, String referralDate, String referredBy) throws InvalidReferralException{
        if(referralDepartment == null || referralDepartment.isEmpty()){
            throw new InvalidReferralException("Referral department cannot be empty.");
        }
        if(referralReason == null || referralReason.isEmpty()){
            throw new InvalidReferralException("Referral reason cannot be empty.");
        }

        this.patientId = patientId;
        this.patientName = patientName;
        this.referralDepartment = referralDepartment;
        this.referralReason = referralReason;
        this.referralDate = referralDate;
        this.referredBy = referredBy;
    }

    //get - set
    public int getPatientId(){
        return patientId;
    }

    public void setPatientId(int patientId){
        this.patientId = patientId;
    }

    public String getPatientName(){
        return patientName;
    }

    public void setPatientName(String patientName){
        this.patientName = patientName;
    }

    public String getReferralDepartment(){
        return referralDepartment;
    }

    public void setReferralDepartment(String referralDepartment) throws InvalidReferralException{
        if(referralDepartment == null || referralDepartment.isEmpty()){
            throw new InvalidReferralException("Referral department cannot be empty.");
        }

        this.referralDepartment = referralDepartment;
    }

    public String getReferralReason(){
        return referralReason;
    }

    public void setReferralReason(String referralReason) throws InvalidReferralException{
        if(referralReason == null || referralReason.isEmpty()){
            throw new InvalidReferralException("Referral reason cannot be empty.");
        }

        this.referralReason = referralReason;
    }

    public String getReferralDate(){
        return referralDate;
    }

    public void setReferralDate(String referralDate) {
        this.referralDate = referralDate;
    }

    public String getReferredBy(){
        return referredBy;
    }

    public void setReferredBy(String refferedBy) {
        this.referredBy = refferedBy;
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
                '}';
    }

}

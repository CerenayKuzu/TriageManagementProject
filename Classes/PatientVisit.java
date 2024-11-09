package Classes;

public class PatientVisit {
    private int patientId;
    private String visitorName;
    private String visitDate;

    //Constructor
    public PatientVisit(int patientId, String visitorName, String visitDate) {
        this.patientId = patientId;
        this.visitorName = visitorName;
        this.visitDate = visitDate;
    }

    //get - set
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return "PatientVisit{" +
                "Patient ID=" + patientId +
                ", Visitor Name='" + visitorName + '\'' +
                ", Visit Date='" + visitDate + '\'' +
                '}';
    }
}

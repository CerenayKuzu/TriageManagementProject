package Interfaces;

public interface IEmergency {
    int getEmergencyId();
    void setEmergencyId(int emergencyId);

    int getPatientId();
    void setPatientId(int patientId);

    String getEmergencyType();
    void setEmergencyType(String emergencyType);

    String getSymptoms();
    void setSymptoms(String symptoms);

    String getSeverity();
    void setSeverity(String severity);

    boolean isTreated();
    void setTreated(boolean treated);

    void treatEmergency();

    String toString();
}

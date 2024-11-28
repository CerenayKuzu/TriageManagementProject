package Classes;

public class TraumaEmergency extends Emergency{
    private String injuryType;
    private Patient[] assignedPatients;

    public TraumaEmergency(int emergencyId, int patientId, String symptoms, String severity, String injuryType, int maxPatients) {
        super(emergencyId, patientId, "Trauma Emergency", symptoms, severity);
        this.injuryType = injuryType;
        this.assignedPatients = new Patient[maxPatients];
    }

    public String getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(String injuryType) {
        this.injuryType = injuryType;
    }

    public Patient[] getAssignedPatients(){
        return assignedPatients;
    }

    public boolean assignPatient(Patient patient) {
        for (int i = 0; i < assignedPatients.length; i++) {
            if (assignedPatients[i] == null) {
                assignedPatients[i] = patient;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder patientsInfo = new StringBuilder();
        for (Patient patient : assignedPatients) {
            if (patient != null) {
                patientsInfo.append(patient.getName()).append(" ").append(patient.getSurname()).append(", ");
            }
        }
        return super.toString() + ", InjuryType='" + injuryType + "', Assigned Patients: " + patientsInfo.toString();
    }
    
    @Override
    public void handleEmergency() {

    }
}

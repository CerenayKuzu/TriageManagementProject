package Classes;

public class TraumaEmergency extends Emergency{
    private String injuryType;

    public TraumaEmergency(int emergencyId, int patientId, String symptoms, String severity, String injuryType) {
        super(emergencyId, patientId, "Trauma Emergency", symptoms, severity);
        this.injuryType = injuryType;
    }

    public String getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(String injuryType) {
        this.injuryType = injuryType;
    }

    @Override
    public String toString() {
        return super.toString() + ", InjuryType='" + injuryType + "'";
    }
    
    @Override
    public void handleEmergency() {
        System.out.println("Handling trauma emergency...");
    }
}

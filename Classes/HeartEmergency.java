package Classes;

public class HeartEmergency extends Emergency {

    public HeartEmergency(int emergencyId, int patientId, String symptoms, String severity, String heartCondition) {
        super(emergencyId, patientId, "Heart Emergency", symptoms, severity);
    }

    @Override
    public void handleEmergency() {
        System.out.println("Handling heart emergency...");
    }
}

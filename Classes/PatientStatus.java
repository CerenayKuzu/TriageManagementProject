package Classes;

public enum PatientStatus {
    STABLE("Stable", "No immediate medical intervention required"),
    CRITICAL("Critical", "Immediate attention required"),
    DISCHARGED("Discharged", "Patient has left the hospital"),
    UNDER_OBSERVATION("Under Observation", "Requires further monitoring");

    private final String status;
    private final String action;

    PatientStatus(String status, String action) {
        this.status = status;
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public String getAction() {
        return action;
    }

    // Method to perform actions based on status
    public void performAction() {
        System.out.println("Status: " + status + " - Action: " + action);
    }

    @Override
    public String toString() {
        return status + " (" + action + ")";
    }
}

package Classes;

public class EmergencyIntervention {
    private int interventionId;
    private int emergencyId;
    private String interventionType;
    private String interventionTime;
    private String staffName;
    private String interventionDetails;
    private boolean isSuccessful; // Flag indicating whether the intervention was successful (true if successful)


    //Constructor
    public EmergencyIntervention(int interventionId, int emergencyId, String interventionType, String interventionTime, String staffName, String interventionDetails){
        this.interventionId = interventionId;
        this.emergencyId = emergencyId;
        this.interventionType = interventionType;
        this.interventionTime = interventionTime;
        this.staffName = staffName;
        this.interventionDetails = interventionDetails;
        this.isSuccessful = false; //the intervention is not marked as successful
    }

    //get - set
    public int getInterventionId() {
        return interventionId;
    }

    public void setInterventionId(int interventionId) {
        this.interventionId = interventionId;
    }

    public int getEmergencyId() {
        return emergencyId;
    }

    public void setEmergencyId(int emergencyId) {
        this.emergencyId = emergencyId;
    }

    public String getInterventionType() {
        return interventionType;
    }

    public void setInterventionType(String interventionType) {
        this.interventionType = interventionType;
    }

    public String getInterventionTime() {
        return interventionTime;
    }

    public void setInterventionTime(String interventionTime) {
        this.interventionTime = interventionTime;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getInterventionDetails() {
        return interventionDetails;
    }

    public void setInterventionDetails(String interventionDetails) {
        this.interventionDetails = interventionDetails;
    }

    //checks if the intervention was successful
    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public void markAsSuccessful() {
        this.isSuccessful = true; //set isSuccessful to true when the intervention is successful
    }

    //representation of the emergency intervention
    @Override
    public String toString() {
        return "EmergencyIntervention{" +
                "interventionId=" + interventionId +
                ", emergencyId=" + emergencyId +
                ", interventionType='" + interventionType + '\'' +
                ", interventionTime='" + interventionTime + '\'' +
                ", staffName='" + staffName + '\'' +
                ", interventionDetails='" + interventionDetails + '\'' +
                ", isSuccessful=" + (isSuccessful ? "Successful" : "Failed") + //display whether the intervention was successful or not
                '}';
    }


}

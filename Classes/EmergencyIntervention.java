package Classes;

import java.util.ArrayList;
import java.util.List;

public class EmergencyIntervention {
    private int interventionId;
    private int emergencyId;
    private String interventionType;
    private String interventionTime;
    private String staffName;
    private String interventionDetails;
    private boolean isSuccessful; // Flag indicating whether the intervention was successful (true if successful)
    private List<String> toolUsed;
    private List<String> notes;

    //Constructor
    public EmergencyIntervention(int interventionId, int emergencyId, String interventionType, String interventionTime, String staffName, String interventionDetails){
        this.interventionId = interventionId;
        this.emergencyId = emergencyId;
        this.interventionType = interventionType;
        this.interventionTime = interventionTime;
        this.staffName = staffName;
        this.interventionDetails = interventionDetails;
        this.isSuccessful = false; //the intervention is not marked as successful
        this.toolUsed = new ArrayList<>();
        this.notes = new ArrayList<>();
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

    public List<String> getToolUsed(){
        return toolUsed;
    }

    public List<String> getNotes(){
        return notes;
    }

    public void addToolUsed(String tool){
        toolUsed.add(tool);
        System.out.println("Tool added: " + tool);
    }

    public void removeToolUsed(String tool) {
        if (toolUsed.remove(tool)) {
            System.out.println("Tool removed: " + tool);
        } else {
            System.out.println("Tool not found.");
        }
    }

    public void addNote(String note) {
        notes.add(note);
        System.out.println("Note added: " + note);
    }

    // Clear all notes
    public void clearNotes() {
        notes.clear();
        System.out.println("All notes cleared.");
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
                ", isSuccessful=" + (isSuccessful ? "Successful" : "Failed") +
                ", toolsUsed=" + toolUsed +
                ", notes=" + notes +
                '}';
    }


}

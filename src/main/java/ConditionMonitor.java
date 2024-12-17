package Classes;

public class ConditionMonitor {
    private String patientName;
    private String conditionNotes; // Notes related to the patient's condition

    //Constructor
    public ConditionMonitor(String patientName) {
        this.patientName = patientName;
        this.conditionNotes = ""; // Initialize the condition notes as empty
    }

    //get - set
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getConditionNotes() {
        return conditionNotes;
    }

    public void setConditionNotes(String conditionNotes) {
        this.conditionNotes = conditionNotes;
    }

    //add a new note to the condition notes
    public void addConditionNote(String note) {
         // If conditionNotes is empty, just set the note
        if (this.conditionNotes.isEmpty()) {
            this.conditionNotes = note;
        } else {
         // If there are existing notes, append the new note with a newline
            this.conditionNotes += "\n" + note;
        }
    }

    // update the patient's condition 
    public void updateCondition(String newCondition) {
        this.conditionNotes = newCondition;
    }

    //return a readable format of the ConditionMonitor object
    @Override
    public String toString() {
        return "ConditionMonitor{" +
                "patientName='" + patientName + '\'' +
                ", conditionNotes='" + conditionNotes + '\'' +
                '}';
    }
}

package Classes;

public class ConditionMonitor extends Thread {
    private String patientName;
    private String conditionNotes;

    // Constructor
    public ConditionMonitor(String patientName) {
        this.patientName = patientName;
        this.conditionNotes = "";
    }

    // Getters and setters
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

    public void addConditionNote(String note) {
        if (this.conditionNotes.isEmpty()) {
            this.conditionNotes = note;
        } else {
            this.conditionNotes += "\n" + note;
        }
    }

    public void updateCondition(String newCondition) {
        this.conditionNotes = newCondition;
    }

    @Override
    public void run() {
        System.out.println("Updating condition for patient: " + patientName);
        try {
            Thread.sleep(2000); 
            this.conditionNotes += "\nCondition updated at: " + System.currentTimeMillis();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ConditionMonitor{" +
                "patientName='" + patientName + '\'' +
                ", conditionNotes='" + conditionNotes + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ConditionMonitor monitor = new ConditionMonitor("John Doe");

        monitor.addConditionNote("Patient is stable.");

        monitor.start();

        monitor.addConditionNote("Monitoring ongoing...");

        try {
            monitor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(monitor.toString());
    }
}

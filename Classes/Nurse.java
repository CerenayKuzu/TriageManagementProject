package Classes;

public class Nurse {
    private String name;
    private int id;
    private boolean isOnDuty; //the nurse is on duty or not

    //Constructor
    public Nurse(int id, String name, boolean isOnDuty) {
        this.id = id;
        this.name = name;
        this.isOnDuty = isOnDuty;
    }

    //get - set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //check if the nurse is currently on duty
    public boolean isOnDuty() {
        return isOnDuty;
    }
    //change the nurse's duty status
    public void setOnDuty(boolean onDuty) {
        isOnDuty = onDuty;
    }
}

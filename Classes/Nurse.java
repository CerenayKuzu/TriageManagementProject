package Classes;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Nurse {
    private String name;
    private int id;
    private boolean isOnDuty;
    // Constructor
    public Nurse(int id, String name, boolean isOnDuty) {
        this.id = id;
        this.name = name;
        this.isOnDuty = isOnDuty;
        logDebug("Nurse created with initial values.");
    }

    public int getId() {
        logDebug("getId() called. Returning: " + id);
        return id;
    }

    public void setId(int id) {
        logDebug("setId() called. Old ID: " + this.id + ", New ID: " + id);
        this.id = id;
    }

    public String getName() {
        logDebug("getName() called. Returning: " + name);
        return name;
    }

    public void setName(String name) {
        logDebug("setName() called. Old Name: " + this.name + ", New Name: " + name);
        this.name = name;
    }

    public boolean isOnDuty() {
        logDebug("isOnDuty() called. Returning: " + isOnDuty);
        return isOnDuty;
    }

    public void setOnDuty(boolean onDuty) {
        logDebug("setOnDuty() called. Old Duty Status: " + this.isOnDuty + ", New Duty Status: " + onDuty);
        this.isOnDuty = onDuty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("name", name)
                .append("id", id)
                .append("isOnDuty", isOnDuty)
                .toString();
    }

    private void logDebug(String message) {
        System.out.println("[DEBUG] " + message + " | Current State: " + this.toString());
    }
}


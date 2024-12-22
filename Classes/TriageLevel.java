import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class TriageLevel {
    private int patientId;
    private String color;

    // Constructor
    public TriageLevel(int id, String color) {
        Validate.isTrue(id > 0, "Patient ID must be positive.");
        this.patientId = id;
        this.color = StringUtils.defaultIfEmpty(color, "Undefined");
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int id) {
        Validate.isTrue(id > 0, "Patient ID must be positive.");
        this.patientId = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = StringUtils.defaultIfEmpty(color, "Undefined");
    }

    public boolean isValidColor() {
        return StringUtils.equalsAnyIgnoreCase(color, "Red", "Yellow", "Green", "Blue");
    }

    @Override
    public String toString() {
        return String.format("TriageLevel{Patient ID=%d, Color='%s'}", patientId, color);
    }
}
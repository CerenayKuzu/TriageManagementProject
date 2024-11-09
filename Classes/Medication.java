package Classes;

public class Medication {
    private String name;
    private String dosage;
    private String usageInstructions;
    private String type;

    //Constructor
    public Medication(String name, String dosage, String usageInstructions, String type) {
        this.name = name;
        this.dosage = dosage;
        this.usageInstructions = usageInstructions;
        this.type = type;
    }

    //get - set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // return a string representation of the medication object
    @Override
    public String toString() {
        return "Medication{" +
                "Name='" + name + '\'' +
                ", Dosage='" + dosage + '\'' +
                ", Usage Instructions='" + usageInstructions + '\'' +
                ", Type='" + type + '\'' +
                '}';
    }



}

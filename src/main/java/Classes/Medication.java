package Classes;

import Exceptions.MedicationNotFoundException;

public class Medication {
    private String name;
    private String dosage;
    private String usageInstructions;
    private MedicationType type; 

    // Constructor
    public Medication(String name, String dosage, String usageInstructions, MedicationType type) {
        this.name = name;
        this.dosage = dosage;
        this.usageInstructions = usageInstructions;
        this.type = type;
    }

    // Getter and Setter methods
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

    public MedicationType getType() {
        return type;
    }

    public void setType(MedicationType type) {
        this.type = type;
    }

    public static Medication findMedication(String name) throws MedicationNotFoundException {
        if (!"Paracetamol".equalsIgnoreCase(name)) {
            throw new MedicationNotFoundException("Medication '" + name + "' not found in the system.");
        }

        return new Medication("Paracetamol", "500mg", "Twice a day after meals", MedicationType.TABLET);
    }

    public boolean isValid(int daysPassed) {
        return type.isValid(daysPassed); 
    }

    // To display the medication information
    @Override
    public String toString() {
        return "Medication{" +
                "Name='" + name + '\'' +
                ", Dosage='" + dosage + '\'' +
                ", Usage Instructions='" + usageInstructions + '\'' +
                ", Type=" + type + 
                '}';
    }
}

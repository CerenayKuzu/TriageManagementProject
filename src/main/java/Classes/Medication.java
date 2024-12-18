package Classes;

import Exceptions.MedicationNotFoundException;

public class Medication {
    private String name;
    private String dosage;
    private String usageInstructions;
    private MedicationType type;  // Değişiklik: type artık MedicationType enum'ı olacak

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

    // Static method to find a medication (this example uses a fixed medication, but this could be extended)
    public static Medication findMedication(String name) throws MedicationNotFoundException {
        if (!"Paracetamol".equalsIgnoreCase(name)) {
            throw new MedicationNotFoundException("Medication '" + name + "' not found in the system.");
        }

        // Default medication return (using MedicationType enum)
        return new Medication("Paracetamol", "500mg", "Twice a day after meals", MedicationType.TABLET);
    }

    // Method to check if the medication is still valid based on shelf life
    public boolean isValid(int daysPassed) {
        return type.isValid(daysPassed);  // Uses the isValid method from the MedicationType enum
    }

    // To display the medication information
    @Override
    public String toString() {
        return "Medication{" +
                "Name='" + name + '\'' +
                ", Dosage='" + dosage + '\'' +
                ", Usage Instructions='" + usageInstructions + '\'' +
                ", Type=" + type + // Displays MedicationType enum information
                '}';
    }
}

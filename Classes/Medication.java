package Classes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Medication {
    private String name;
    private String dosage;
    private String usageInstructions;
    private String type;

    // Constructor
    public Medication(String name, String dosage, String usageInstructions, String type) {
        this.name = name;
        this.dosage = dosage;
        this.usageInstructions = usageInstructions;
        this.type = type;
    }

    // Getters and Setters
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

    public static Medication findMedication(String name) throws MedicationNotFoundException {
        if (!"Paracetamol".equalsIgnoreCase(name)) {
            throw new MedicationNotFoundException("Medication '" + name + "' not found in the system.");
        }

        return new Medication("Paracetamol", "500mg", "Twice a day after meals", "Tablet");
    }

    // Lambda functions (generic)
    public static void applyToMedication(List<Medication> medications, Function<Medication, String> function) {
        for (Medication medication : medications) {
            System.out.println(function.apply(medication));
        }
    }

    public static void findMedicationByName(List<Medication> medications, Predicate<Medication> predicate) {
        for (Medication medication : medications) {
            if (predicate.test(medication)) {
                System.out.println(medication);
            }
        }
    }

    public static void printMedicationDetails(List<Medication> medications, Consumer<Medication> consumer) {
        for (Medication medication : medications) {
            consumer.accept(medication);
        }
    }

    @Override
    public String toString() {
        return "Medication{" +
                "Name='" + name + '\'' +
                ", Dosage='" + dosage + '\'' +
                ", Usage Instructions='" + usageInstructions + '\'' +
                ", Type='" + type + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Sample medication list
        List<Medication> medications = Arrays.asList(
                new Medication("Paracetamol", "500mg", "Twice a day after meals", "Tablet"),
                new Medication("Ibuprofen", "200mg", "Three times a day", "Tablet"),
                new Medication("Aspirin", "300mg", "Once a day", "Tablet")
        );

        // Apply lambda function to get dosage
        applyToMedication(medications, medication -> "Dosage for " + medication.getName() + ": " + medication.getDosage());

        // Find medications with name 'Paracetamol'
        findMedicationByName(medications, medication -> "Paracetamol".equalsIgnoreCase(medication.getName()));

        // Print medication details
        printMedicationDetails(medications, medication -> System.out.println(medication.toString()));
    }
}

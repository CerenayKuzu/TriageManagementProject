import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;

public class TriageRoom {
    private List<String> patients = Arrays.asList("John", "Jane", "Paul");

    public void printPatients() {
        // Lambda expression to print each patient
        patients.forEach(patient -> System.out.println(patient));
    }

    public void modifyPatientList() {
        // Lambda expression to modify the list
        patients.replaceAll(patient -> patient.toUpperCase());
    }

    public static void main(String[] args) {
        TriageRoom triageRoom = new TriageRoom();
        triageRoom.printPatients();
        triageRoom.modifyPatientList();
        triageRoom.printPatients();
    }
}

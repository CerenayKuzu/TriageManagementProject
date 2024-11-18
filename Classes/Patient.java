package Classes;

public class Patient {
    private int id;
    private String name;
    private String surname;

    private static int patientCount = 0;
    //Constructor
    public Patient(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        patientCount++;
    }

    static {
        System.out.println("Patient class loaded. Ready to manage patients.");
    }

    //get-set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public static int getPatientCount() {
        return patientCount;
    }

    @Override
    public String toString() {
        return "Patient{id=" + id + ", name='" + name + "', surname='" + surname + "'}";
    }

    @Override
    public int hashCode() {
        return 31 * id + name.hashCode() + surname.hashCode();  // Using id, name, and surname to compute hashCode
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patient that = (Patient) obj;
        return id == that.id && name.equals(that.name) && surname.equals(that.surname);
    }
    public static void displayPatientInfo() {
        System.out.println("This is a generic patient. More details can be added as needed.");
    }
}

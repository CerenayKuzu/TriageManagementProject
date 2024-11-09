package Classes;

public class Patient {
    private int id;
    private String name;
    private String surname;

    //Constructor
    public Patient(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

}

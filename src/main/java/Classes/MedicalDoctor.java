package Classes;


public class MedicalDoctor extends MedicalProfessional{
    private String speciality;

    //Constructor
    public MedicalDoctor(String name, int id, String speciality) {
        super(name, id); 
        this.speciality = speciality;
    }

    //get - set
    public String getSpeciality(){
        return speciality;
    }

    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    //from the MedicalProfessional class to specify the doctor's duty
    @Override
    public void performDuty() {
        System.out.println("Doctor " + name + " is performing a medical procedure.");
    }
}

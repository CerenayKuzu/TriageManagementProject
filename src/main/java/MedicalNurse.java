package Classes;

public class MedicalNurse extends MedicalProfessional {
    private String department;
    
    //Constructor
    public MedicalNurse(String name, int id, String department){
        super(name, id); //calling the constructor of the superclass (MedicalProfessional)
        this.department = department;
    }

    //get - set
    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    //the performDuty method from the MedicalProfessional class
    @Override
    public void performDuty() {
        //the nurse's duty involves assisting in the specified department
        System.out.println("Nurse " + name + " is assisting in the " + department + " department.");
    }

    
}

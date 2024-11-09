package Classes;

public abstract class MedicalProfessional {
    protected String name;
    protected int id;

    //Constructor
    public MedicalProfessional(String name, int id){
        this.name =name;
        this.id = id;
    }

    //get - set
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //abstract method to be implemented by subclasses, defining the professional's duties
    public abstract void performDuty();
}
package Interfaces;

public abstract class IMedicalStaff {
    private String name;
    private String speciality;

    public IMedicalStaff(String name, String speciality){
        this.name = name;
        this.speciality = speciality;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSpeciality(){
        return speciality;
    }

    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    public abstract void performDuty();
    
}

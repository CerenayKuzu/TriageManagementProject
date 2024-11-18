package Classes;

import Interfaces.IMedicalStaff;

public class Doctor implements IMedicalStaff {
    private String doctorName;
    private String speciality;

    //Constructor
    public Doctor(String doctorName, String speciality) {
        this.doctorName = doctorName;
        this.speciality = speciality;
    }

    //get - set
    public String getName(){
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality(){
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    
}
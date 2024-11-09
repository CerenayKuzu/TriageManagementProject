package Classes;

public class Doctor {
    private String doctorName;
    private String speciality;

    //Constructor
    public Doctor(String DoctorName, String speciality) {
        this.doctorName = DoctorName;
        this.speciality = speciality;
    }

    //get - set
    public String getDoctorName(){
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
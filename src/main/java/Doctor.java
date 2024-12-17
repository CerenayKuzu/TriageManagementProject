package Classes;

import Interfaces.IMedicalStaff;

public class Doctor extends IMedicalStaff {

    //Constructor
    public Doctor(String doctorName, String speciality) {
        super(doctorName, speciality);
    }

   @Override
   public void performDuty(){

   }

   @Override
   public String toString() {
       return "Doctor{name='" + getName() + "', speciality='" + getSpeciality() + "'}";
   }


}
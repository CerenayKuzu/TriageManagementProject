package Classes;

import java.util.ArrayList;
import java.util.List;

public abstract class MedicalProfessional {
    protected String name;
    protected int id;
    protected List<String> certifications;
    protected List<String> patientsHandled;

    //Constructor
    public MedicalProfessional(String name, int id){
        this.name =name;
        this.id = id;
        this.certifications = new ArrayList<>();
        this.patientsHandled = new ArrayList<>();
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

    public List<String> getCertifications(){
        return certifications;
    }

    public List<String> getPatientHandled(){
        return patientsHandled;
    }

    public void addCertification(String certification){
        certifications.add(certification);
        System.out.println("Certification added: " + certification);
    }

    public void removeCertification(String certification){
        if(certifications.remove(certification)){
            System.out.println("Certification removed: " + certification);
        } else{
            System.out.println("Certification not found.");
        }
    }

    public void addPatient(String patientName){
        patientsHandled.add(patientName);
        System.out.println("Patient added to handled list: " + patientName);
    }

    //abstract method to be implemented by subclasses, defining the professional's duties
    public abstract void performDuty();

    @Override
    public String toString() {
        return "MedicalProfessional{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", certifications=" + certifications +
                ", patientsHandled=" + patientsHandled +
                '}';
    }
}
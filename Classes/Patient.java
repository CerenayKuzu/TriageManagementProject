package Classes;

import Interfaces.IMedicalHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Patient implements IMedicalHistory {
    private int id;
    private String name;
    private String surname;
    private String previousIllnesses;
    private String surgeries;
    private String allergies;
    private String medications;

    private static int patientCount = 0;
    private static List<Patient> patientList = new ArrayList<>(); 

    public Patient(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.previousIllnesses = "Unknown";
        this.surgeries = "None";
        this.allergies = "None";
        this.medications = "None";
        patientCount++;
        patientList.add(this); 
    }

    public Patient(int id, String name, String surname, String previousIllnesses, String surgeries, String allergies, String medications) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.previousIllnesses = previousIllnesses;
        this.surgeries = surgeries;
        this.allergies = allergies;
        this.medications = medications;
        patientCount++;
        patientList.add(this); 
    }

    static {
        System.out.println("Patient class loaded. Ready to manage patients.");
    }

    
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
    public String getPatientId() {
        return String.valueOf(this.id);
    }

    @Override
    public String getPreviousIllnesses() {
        return previousIllnesses;
    }

    @Override
    public String getSurgeries() {
        return surgeries;
    }

    @Override
    public String getAllergies() {
        return allergies;
    }

    @Override
    public String getMedications() {
        return medications;
    }

    @Override
    public void setPatientId(String patientId) {
        this.id = Integer.parseInt(patientId);
    }

    @Override
    public void setPreviousIllnesses(String previousIllnesses) {
        this.previousIllnesses = previousIllnesses;
    }

    @Override
    public void setSurgeries(String surgeries) {
        this.surgeries = surgeries;
    }

    @Override
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public void setMedications(String medications) {
        this.medications = medications;
    }

    public static void displayPatientInfo() {
        System.out.println("This is a generic patient. More details can be added as needed.");
    }

    @Override
    public String toString() {
        return "Patient{id=" + id + 
               ", name='" + name + 
               "', surname='" + surname + 
               "', previousIllnesses='" + previousIllnesses + 
               "', surgeries='" + surgeries + 
               "', allergies='" + allergies + 
               "', medications='" + medications + 
               "'}";
    }




    public static void printAllPatients() {
        System.out.println("Printing all patients:");
        patientList.forEach(patient -> System.out.println(patient));
    }


    public static void findPatientByName(String name) {
        System.out.println("Searching for patient with name: " + name);
        patientList.stream()
                   .filter(patient -> patient.getName().equalsIgnoreCase(name))
                   .forEach(patient -> System.out.println("Found: " + patient));
    }


    public static void updateLastNamesToUppercase() {
        patientList.forEach(patient -> patient.setSurname(patient.getSurname().toUpperCase()));
    }


    public static void sortPatientsById() {
        patientList.stream()
                   .sorted((p1, p2) -> Integer.compare(p1.getId(), p2.getId()))
                   .forEach(patient -> System.out.println(patient));
    }


    public static void performActionOnAllPatients(Consumer<Patient> action) {
        patientList.forEach(action);
    }

}

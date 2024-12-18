package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("hiding")
public class TriageRoom<Patient> {
    private int roomNumber;
    private String roomType;
    private List<Patient> patients;
    private Map<String, Integer> equipment;
    private Patient currentPatient;
    
    //Constructor
    public TriageRoom(int roomNumber, String roomType) {
        this.roomNumber =  roomNumber;
        this.roomType = roomType;
        this.patients = new ArrayList<>();
        this.equipment = new HashMap<>();
        this.currentPatient = null;

    }

    //get - set
    public Patient getCurrentPatient(){
        return currentPatient;
    }

    public void setCurrentPatient(Patient currentPatient){
        this.currentPatient = currentPatient;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public List<Patient> gPatients(){
        return patients;
    }

    public Map<String, Integer> getEquipment(){
        return equipment;
    }

    public void addPatient(Patient patient){
        if(patients.size() < 5){
            patients.add(patient);
            System.out.println("Patient added: " + patient);
        } else {
            System.out.println("Room is full. Cannot add more patients.");
        }
    }

    public void dischargePatient(Patient patient){
        if(patients.remove(patient)){
            System.out.println("Patient discharged: " + patient);
        } else{
            System.out.println("Patient not found in te room.");
        }
    }

    public void addEquipment(String equipmentName, int quantity){
        equipment.put(equipmentName, equipment.getOrDefault(equipmentName, 0) + quantity);
        System.out.println(quantity + " " + equipmentName + "(s) added to the room.");
    }

    public int getEquipmentQuantity(String equipmentName){
        return equipment.getOrDefault(equipmentName, 0);
    }

    @Override
    public String toString() {
        return "TriageRoom{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", patients=" + patients +
                ", equipment=" + equipment +
                '}';
    }
}

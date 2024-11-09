package Classes;

public class TriageRoom {
    private int roomNumber;
    private String roomType;
    private Patient currentPatient;
    
    //Constructor
    public TriageRoom(int roomNumber, String roomType) {
        this.roomNumber =  roomNumber;
        this.roomType = roomType;
        this.currentPatient = null;

    }

    //get - set
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

    public Patient getCurrentPatient() {
        return currentPatient;
    }

    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }
}

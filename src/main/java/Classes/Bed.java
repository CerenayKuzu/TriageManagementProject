package Classes;

import Exceptions.BedUnavailableException;

public class Bed {
    private int bedNumber; //identifier number for bed
    private boolean isOccupied; //true if occupied false otherwise
    private String bedType;

    // Constructor to initialize the bed
    public Bed(int bedNumber, boolean isOccupied, String bedType) throws BedUnavailableException{
        this.bedNumber = bedNumber;
        this.isOccupied = isOccupied;
        this.bedType = bedType;
    }

    //get - set
    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean Occupied) {
        isOccupied = Occupied;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType){
        this.bedType = bedType;
    }

    //// Method to toggle the occupancy status of the bed
    public void toggleOccupiedStatus() {
        this.isOccupied = !this.isOccupied;
    }

    public void assignBed() throws BedUnavailableException {
        if(isOccupied){
            throw new BedUnavailableException("Bed " + bedNumber + " is already occupied and cannot be assigned.");
        }
        isOccupied = true;
    }

    //display bed information in a readable format
    @Override 
    public String toString() {
        return "Bed{" +
                "Bed Number=" + bedNumber +
                ", Occupied=" + (isOccupied ? "Yes" : "No") +
                ", Bed Type='" + bedType + '\'' +
                '}';
    }
}

package Classes;

import Interfaces.IEquipment;

public class Equipment implements IEquipment {
    private String equipmentName;
    private String equipmentType;
    private String modelNumber;
    private boolean isAvailable; //the equipment is available for use (true if available)

    //Constructor
    public Equipment(String equipmentName, String equipmentType, String modelNumber, boolean isAvailable) {
        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.modelNumber = modelNumber;
        this.isAvailable = isAvailable;
    }

    //get - set
    @Override
    public String getEquipmentName() {
        return equipmentName;
    }
    
    @Override
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
    
    @Override
    public String getEquipmentType() {
        return equipmentType;
    }

    @Override
    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    @Override
    public String getModelNumber() {
        return modelNumber;
    }

    @Override
    public void setModelNumber(String modelNumber){
        this.modelNumber = modelNumber;
    }

    @Override
    public boolean isAvailable(){
        return isAvailable;
    }

    //to return a string representation of the equipment
    @Override
    public String toString() {
        return "Equipment{" +
                "Equipment Name='" + equipmentName + '\'' +
                ", Equipment Type='" + equipmentType + '\'' +
                ", Model Number='" + modelNumber + '\'' +
                ", Availability=" + (isAvailable ? "Available" : "Not Available") + //display if the equipment is available or not
                '}';
    }
}

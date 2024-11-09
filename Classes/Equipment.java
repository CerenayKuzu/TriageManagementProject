package Classes;

public class Equipment {
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
    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber){
        this.modelNumber = modelNumber;
    }

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

package Interfaces;

public interface IEquipment {
    String getEquipmentName();
    void setEquipmentName(String equipmentName);

    String getEquipmentType();
    void setEquipmentType(String equipmentTyepe);

    String getModelNumber();
    void setModelNumber(String modelNumber);

    boolean isAvailable();

    String toString();
}

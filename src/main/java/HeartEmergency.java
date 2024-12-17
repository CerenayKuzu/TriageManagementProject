package Classes;

import Interfaces.IMedicalStaff;

public class HeartEmergency extends Emergency {
    private String heartCondition;
    private IMedicalStaff assignedDoctor;

    public HeartEmergency(int emergencyId, int patientId, String symptoms, String severity, String heartCondition) {
        super(emergencyId, patientId, "Heart Emergency", symptoms, severity);
        this.heartCondition = heartCondition;
    }

    public String getHeartCondition(){
        return heartCondition;
    }

    public void setHeartCondition(String heartCondition){
        this.heartCondition = heartCondition;
    }

    public void setAssignedDoctor(IMedicalStaff doctor){
        this.assignedDoctor = doctor;
    }

    public IMedicalStaff getAssignedDoctor(){
        return assignedDoctor;
    }

    @Override
    public void handleEmergency() {
        System.out.println("Handling heart emergency...");
        if(assignedDoctor != null){
            System.out.println("Doctor " + assignedDoctor.getName() + " is handling the case.");
        } else {
            System.out.println("No doctor assigned to this heart emergency.");
        }
    }
    

    @Override
    public String toString(){
        return super.toString() + ", HeartCondition='" + heartCondition + "'" + 
               (assignedDoctor != null ? ", AssignedDoctor=" + assignedDoctor.getName() : ", No Doctor Assigned");
    }
}

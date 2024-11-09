package Classes;

public class TriageLevel {
    private int patientId;
    private String color;
    
    //Constructor
    public TriageLevel(int id, String color) {
        this.patientId = id;
        this.color = color;
    }

    //get - set
    public int getPatientId(){
        return patientId;
    }

    public void setPatientId(int id){
        this.patientId = id;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;

    }

}

package Classes;

public class Insurance {
    private String insuranceNumber;
    private String insuranceType;
    private String insuranceCompany;

    //Constructor
    public Insurance(String insuranceNumber, String insuranceType, String insuranceCompany) {
        this.insuranceNumber = insuranceNumber;
        this.insuranceType = insuranceType;
        this.insuranceCompany = insuranceCompany;
    }

    //get - set
    public String getInsuranceNumber(){
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
    
    //to return a string representation of the insurance details
    @Override
    public String toString(){
        return "Insurance{" +
                "Insurance Number='" + insuranceNumber + '\'' +
                ", Insurance Type='" + insuranceType + '\'' +
                ", Insurance Company='" + insuranceCompany + '\'' +
                '}';
    }
}

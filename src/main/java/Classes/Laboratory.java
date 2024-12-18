package Classes;

public class Laboratory {
    private String name;
    private String location;
    private String[] testTypes;
    private String[] results;
    private int testCount;

    //Constructor
    public Laboratory(String name, String location, int maxTests) {
        this.name = name;
        this.location = location;
        this.testTypes = new String[maxTests];
        this.results = new String[maxTests];
        this.testCount = 0;              
    }

    //get - set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // add a test and its result to the laboratory
    public void addTest(String testType, String result) {
        if (testCount < testTypes.length) {
            testTypes[testCount] = testType; 
            results[testCount] = result; 
            testCount++;      
        } else {
            System.out.println("No more tests can be added.");
        }
    }

    //to return a detailed string representation of the laboratory
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Laboratory Name: ").append(name).append("\n")
          .append("Location: ").append(location).append("\n")
          .append("Tests and Results:\n");
        for (int i = 0; i < testCount; i++) {
            sb.append("Test: ").append(testTypes[i])
              .append(" - Result: ").append(results[i]).append("\n");
        }
        return sb.toString();
    }
}

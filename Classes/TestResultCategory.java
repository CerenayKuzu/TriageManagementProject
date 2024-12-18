package Classes;

public enum TestResultCategory {
    NORMAL("Normal", "All test parameters are within normal limits."),
    ABNORMAL("Abnormal", "Test parameters are outside normal limits."),
    CRITICAL("Critical", "Test results are critical. Immediate medical intervention required.");

    private final String category;
    private final String description;

    TestResultCategory(String category, String description) {
        this.category = category;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    // Method to get detailed information based on category
    public String getDetails() {
        return category + ": " + description;
    }

    @Override
    public String toString() {
        return category + " (" + description + ")";
    }
}

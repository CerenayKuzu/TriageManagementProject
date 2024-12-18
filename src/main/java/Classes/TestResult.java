package Classes;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TestResult {
    private String testId;
    private int patientId;
    private Date testDate;
    private String testName;
    private String testResult;
    private String remarks; // Additional remarks or comments about the test
    private List<String> supportingDocuments;
    private List<String> comments;
    private TestResultCategory category; // Test result category field

    // Constructor
    public TestResult(String testId, int patientId, Date testDate, String testName, String testResult, String remarks) {
        this.testId = testId;
        this.patientId = patientId;
        this.testDate = testDate;
        this.testName = testName;
        this.testResult = testResult;
        this.remarks = remarks;
        this.supportingDocuments = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.category = evaluateTestCategory(testResult); // Set the category based on test result
    }

    // Getters and Setters
    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
        this.category = evaluateTestCategory(testResult); // Update category based on result
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<String> getSupportingDocuments() {
        return supportingDocuments;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addSupportingDocument(String document) {
        supportingDocuments.add(document);
        System.out.println("Supporting document added: " + document);
    }

    // Remove a supporting document
    public void removeSupportingDocument(String document) {
        if (supportingDocuments.remove(document)) {
            System.out.println("Supporting document removed: " + document);
        } else {
            System.out.println("Document not found.");
        }
    }

    public void addComment(String comment) {
        comments.add(comment);
        System.out.println("Comment added: " + comment);
    }

    // Clear all comments
    public void clearComments() {
        comments.clear();
        System.out.println("All comments cleared.");
    }

    // Evaluate and return the category based on test result
    private TestResultCategory evaluateTestCategory(String result) {
        if ("Normal".equalsIgnoreCase(result)) {
            return TestResultCategory.NORMAL;
        } else if ("Abnormal".equalsIgnoreCase(result)) {
            return TestResultCategory.ABNORMAL;
        } else if ("Critical".equalsIgnoreCase(result)) {
            return TestResultCategory.CRITICAL;
        } else {
            // Default category if no match found
            return TestResultCategory.NORMAL;
        }
    }

    // Display the test result information in a readable format
    @Override
    public String toString() {
        return "TestResult{" +
                "Test ID='" + testId + '\'' +
                ", Patient ID=" + patientId +
                ", Test Date=" + testDate +
                ", Test Name='" + testName + '\'' +
                ", Test Result='" + testResult + '\'' +
                ", Remarks='" + remarks + '\'' +
                ", Supporting Documents=" + supportingDocuments +
                ", Comments=" + comments +
                ", Category=" + category.getDetails() + // Display category details
                '}';
    }
}

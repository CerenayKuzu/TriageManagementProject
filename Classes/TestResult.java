package Classes;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class TestResult {
    private String testId;
    private int patientId;
    private Date testDate;
    private String testName;
    private String testResult;
    private String remarks;
    private List<String> supportingDocuments;
    private List<String> comments;

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

    // Lambda functions (generic)
    
    // Apply a function to a list of TestResult objects
    public static void applyToTestResult(List<TestResult> testResults, Function<TestResult, String> function) {
        for (TestResult testResult : testResults) {
            System.out.println(function.apply(testResult));
        }
    }

    // Filter TestResults based on a predicate (e.g., filter by test result)
    public static void filterTestResults(List<TestResult> testResults, Predicate<TestResult> predicate) {
        for (TestResult testResult : testResults) {
            if (predicate.test(testResult)) {
                System.out.println(testResult);
            }
        }
    }

    // Print the details of each TestResult using a consumer
    public static void printTestResultDetails(List<TestResult> testResults, Consumer<TestResult> consumer) {
        for (TestResult testResult : testResults) {
            consumer.accept(testResult);
        }
    }

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
                '}';
    }

    public static void main(String[] args) {
        // Sample test results list
        List<TestResult> testResults = Arrays.asList(
                new TestResult("T123", 1, new Date(), "Blood Test", "Positive", "Patient shows high cholesterol levels"),
                new TestResult("T124", 2, new Date(), "X-Ray", "Negative", "No issues detected"),
                new TestResult("T125", 3, new Date(), "ECG", "Normal", "Heart rate is normal")
        );

        // Apply lambda function to extract test result
        applyToTestResult(testResults, testResult -> "Test " + testResult.getTestName() + " resulted in: " + testResult.getTestResult());

        // Filter TestResults with a specific test result (e.g., 'Positive')
        filterTestResults(testResults, testResult -> "Positive".equals(testResult.getTestResult()));

        // Print all TestResult details
        printTestResultDetails(testResults, testResult -> System.out.println(testResult.toString()));
    }
}

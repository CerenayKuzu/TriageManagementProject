import java.util.Scanner;
import java.util.Date;

import Classes.Bed;
import Classes.ConditionMonitor;
import Classes.Doctor;
import Classes.Emergency;
import Classes.EmergencyIntervention;
import Classes.Equipment;
import Classes.Insurance;
import Classes.Invoice;
import Classes.Laboratory;
import Classes.MedicalDoctor;
import Classes.MedicalHistory;
import Classes.MedicalNurse;
import Classes.Medication;
import Classes.Nurse;
import Classes.Patient;
import Classes.PatientRecord;
import Classes.PatientReferral;
import Classes.PatientVisit;
import Classes.TestResult;
import Classes.TransactionRecord;
import Classes.TriageLevel;
import Classes.TriageRoom;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //PATIENT
        //Patient Information Input
        System.out.print("Patient ID: ");
        int id = s.nextInt();
        s.nextLine(); // Consume newline

        System.out.print("Patient Name: ");
        String ad = s.nextLine();
        
        System.out.print("Patient Surname: ");
        String soyad = s.nextLine();

        // Creating a Patient object
        Patient p = new Patient(id, ad, soyad);

        // Displaying patient information
        System.out.println("Patient Informations Has Been Saved: " + p.getId()+ " " + p.getName()+ " "+ p.getSurname());

        //TRIAGELEVEL
        // Triage Level Handling
        System.out.print("Enter Patient ID: ");
        int patientId = s.nextInt();
        s.nextLine(); 

        System.out.print("Enter Triage Level (Color - Red, Yellow, Green): ");
        String color = s.nextLine();


        //Creating TriageLevel object
        TriageLevel triage = new TriageLevel(patientId, color);

        // Displaying the triage information
        System.out.println("\nTriage Level Record:");
        System.out.println("Patient ID: " + triage.getPatientId());
        System.out.println("Triage Color: " + triage.getColor());

        // Option to change the triage color
        System.out.print("\nWould you like to change the Triage Level color? (yes/no): ");
        String changeResponse = s.nextLine().toLowerCase();

        if (changeResponse.equals("yes")) {
            System.out.print("Enter new Triage Level Color: ");
            String newColor = s.nextLine();
            triage.setColor(newColor);

            System.out.println("\nUpdated Triage Level Record:");
            System.out.println("Patient ID: " + triage.getPatientId());
            System.out.println("Triage Color: " + triage.getColor());
        } else {
            System.out.println("\nNo changes made to the Triage Level.");
        }



        //DOCTOR
        System.out.print("Enter Doctor's Name: ");
        String doctorName = s.nextLine();

        System.out.print("Enter Doctor's Speciality: ");
        String speciality = s.nextLine();

        Doctor doctor = new Doctor(doctorName, speciality);

        System.out.println("\nDoctor Information:");
        System.out.println("Doctor's Name: " + doctor.getDoctorName());
        System.out.println("Speciality: " + doctor.getSpeciality());



        //Nurse
        System.out.print("Enter Nurse ID: ");
        int nurseId = s.nextInt();
        s.nextLine();

        System.out.print("Enter Nurse Name: ");
        String nurseName = s.nextLine();

        System.out.print("Is the Nurse on Duty (true/false)? ");
        boolean isOnDuty = s.nextBoolean();

        Nurse nurse = new Nurse(nurseId, nurseName, isOnDuty);

        System.out.println("\nNurse Information:");
        System.out.println("Nurse ID: " + nurse.getId());
        System.out.println("Nurse Name: " + nurse.getName());
        System.out.println("On Duty: " + (nurse.isOnDuty() ? "Yes" : "No"));



        //TRIAGEROOM
        //Request input for Triage Room details
        System.out.print("Enter Room Number: ");
        int roomNumber = s.nextInt();
        s.nextLine();

        System.out.print("Enter Room Type (Examination, Emergency): ");
        String roomType = s.nextLine();

        // Create a TriageRoom object using the given details
        TriageRoom triageRoom = new TriageRoom(roomNumber, roomType);

        System.out.print("Is there a current patient in the room? (yes/no): ");
        String hasPatient = s.nextLine();

        if (hasPatient.equalsIgnoreCase("yes")) { // If user indicates that there is a patient
            System.out.print("Enter Patient ID: ");
            int patientId1 = s.nextInt();
            s.nextLine();

            System.out.print("Enter Patient Name: ");
            String patientName = s.nextLine();

            System.out.print("Enter Patient Surname: ");
            String patientSurname = s.nextLine();

            // Create a new Patient object
            Patient patient = new Patient(patientId1, patientName, patientSurname);

            // Assign the patient to the current TriageRoom
            triageRoom.setCurrentPatient(patient);
        }

        System.out.println("\nTriage Room Information:");
        System.out.println("Room Number: " + triageRoom.getRoomNumber()); //display room number
        System.out.println("Room Type: " + triageRoom.getRoomType()); //display room type

        if (triageRoom.getCurrentPatient() != null) { // If there is a current patient
            Patient patient = triageRoom.getCurrentPatient();
            System.out.println("Current Patient: " + patient.getName() + " " + patient.getSurname() + " (ID: " + patient.getId() + ")");
        } else {
            // Indicate that there is no patient in the room
            System.out.println("No current patient in the room.");
        }



        //PATIENTRECORD
        // Creating and initializing PatientRecord objects with sample data

        PatientRecord record1 = new PatientRecord("John Doe", "2024-11-06", "Patient admitted with high fever.");
        PatientRecord record2 = new PatientRecord("Jane Smith", "2024-11-06", "Routine check-up completed.");

        System.out.println(record1);  // Assumes the PatientRecord class has a properly overridden toString() method
        System.out.println(record2);  // Displays the second PatientRecord details

        // Prompting user for new PatientRecord details
        System.out.print("Enter Patient ID: ");
        String patientid = s.nextLine();

        System.out.print("Enter Previous Illnesses: ");
        String previousIllnesses = s.nextLine();

        System.out.print("Enter Surgeries: ");
        String surgeries = s.nextLine();

        System.out.print("Enter Allergies: ");
        String allergies = s.nextLine();

        System.out.print("Enter Medications: ");
        String medications = s.nextLine();


        //MEDICALHISTORY
        // Creating a MedicalHistory object using previously collected data
        MedicalHistory medicalHistory = new MedicalHistory(patientid, previousIllnesses, surgeries, allergies, medications);

        System.out.println("\nSaved Medical History:");
        System.out.println(medicalHistory);

        System.out.print("Enter Medication Name: ");
        String name = s.nextLine();

        System.out.print("Enter Dosage (mg): ");
        String dosage = s.nextLine();

        System.out.print("Enter Usage Instructions: ");
        String usageInstructions = s.nextLine();

        System.out.print("Enter Medication Type (tablet, liquid): ");
        String type = s.nextLine();


        //MEDICATION

        // Creating a Medication object using collected medication data
        Medication medication = new Medication(name, dosage, usageInstructions, type);

        System.out.println("\nMedication Information:");
        System.out.println(medication);

        System.out.print("Enter Laboratory Name: ");
        String labName = s.nextLine();

        System.out.print("Enter Laboratory Location: ");
        String labLocation = s.nextLine();

        System.out.print("Enter Maximum Number of Tests: ");
        int maxTests = s.nextInt();
        s.nextLine();


        //LABORATORY
        // Creating a Laboratory object using collected data
        Laboratory laboratory = new Laboratory(labName, labLocation, maxTests);


        // Loop for entering test data up to the maximum allowed tests
        for (int i = 0; i < maxTests; i++) {
            System.out.print("Enter Test Type (Blood Test): ");
            String testType = s.nextLine();

            System.out.print("Enter Result for " + testType + ": ");
            String result = s.nextLine();


         // Adds the test and result to the Laboratory object
            laboratory.addTest(testType, result); // Assumes `addTest()` is a method defined in the `Laboratory` class to store this data
        }

        System.out.println("\nLaboratory Information:");
        System.out.println(laboratory);

        System.out.print("Enter patient's name: ");
        String patientName = s.nextLine();

        //CONDITIONMONITOR
        // Creating an instance of ConditionMonitor for a specific patient
        ConditionMonitor conditionMonitor = new ConditionMonitor(patientName);

        conditionMonitor.addConditionNote("Patient admitted with high fever.");
        conditionMonitor.addConditionNote("Temperature reduced after medication.");

        System.out.println("\nUpdating patient's condition...");
        conditionMonitor.updateCondition("Patient's condition is stable.");

        System.out.println("\nPatient's Condition Monitoring:");
        System.out.println(conditionMonitor);

        // Initializing basic invoice details
        String invoiceNumber = "INV12345";
        String customerName;
        Date invoiceDate = new Date();
        String serviceName = "Medical Consultation";
        int quantity = 1;
        double unitPrice = 150.0;

        System.out.print("Please enter customer name: ");
        customerName = s.nextLine();


        //INVOICE
        // Creating an Invoice object using the provided details
        Invoice invoice = new Invoice(invoiceNumber, customerName, invoiceDate, serviceName, quantity, unitPrice);

        System.out.println("\nInvoice Details:");
        System.out.println(invoice);

        invoice.markAsPaid(); // Calls a method to change the invoice status to "pai

        System.out.println("\nAfter Payment:");
        System.out.println(invoice);

        System.out.print("Enter Patient ID: ");
        int PatientId = s.nextInt();
        
        // Test details for the medical test being performed
        String testId = "TST12345";
        Date testDate = new Date();
        String testName = "Blood Test";
        String testResult = "Normal";
        String remarks = "No abnormalities found.";


        //TESTRESULT
        // Creating a TestResult object for the medical test
        TestResult testResultObj = new TestResult(testId, PatientId, testDate, testName, testResult, remarks);

        System.out.println(testResultObj); // Outputs all details of the TestResult


        System.out.print("Transaction ID: ");
        String transactionId = s.nextLine();

        System.out.print("Patient ID: ");
        int patientID = s.nextInt(); // Accepting the Patient ID for this transaction
        s.nextLine();

        System.out.print("Transaction Type: ");
        String transactionType = s.nextLine();

        System.out.print("Amount: ");
        double amount = s.nextDouble(); // Accepting the amount of money involved in the transaction
        s.nextLine();

        System.out.print("Date: "); //could be formatted as yyyy-mm-dd
        String date = s.nextLine();

        System.out.print("Description: ");
        String description = s.nextLine();


        //TRANSACTIONRECORD
        // Creating a TransactionRecord object with the user inputs
        TransactionRecord transaction = new TransactionRecord(transactionId, patientID, transactionType, amount, date, description);

        System.out.println("\nCreated Transaction Record:");
        System.out.println(transaction);


        System.out.print("Enter Bed Number: ");
        int bedNumber = s.nextInt();
        s.nextLine();

        System.out.print("Is the bed occupied? (true/false): ");
        boolean isOccupied = s.nextBoolean(); // Whether the bed is currently occupied or not
        s.nextLine();

        System.out.print("Enter Bed Type (Normal, Intensive Care, Emergency): ");
        String bedType = s.nextLine();


        //BED
        // Creating a Bed object with the collected data
        Bed bed = new Bed(bedNumber, isOccupied, bedType);

        System.out.println("\nCreated Bed Record:");
        System.out.println(bed);

        System.out.print("\nWould you like to change the bed's occupied status? (yes/no): ");
        String changeResponse1 = s.nextLine().toLowerCase();  //Convert the response to lowercase

        // If the response is "yes", update the status
        if (changeResponse1.equals("yes")) {
            System.out.print("Enter new occupied status (true/false): ");
            boolean newStatus = s.nextBoolean(); // Read the new status as a boolean
            bed.setOccupied(newStatus); // Update the Bed's occupied status

            System.out.println("\nUpdated Bed Record:");
            System.out.println(bed);
        } else {
            // If no change is made, display a message
            System.out.println("\nNo changes made to the bed status.");
        }


        //PATIENTVISIT
        System.out.print("Enter Patient ID: ");
        int patientId2 = s.nextInt(); // Read the Patient ID from the user as an integer
        s.nextLine();

        System.out.print("Enter Visitor Name: ");
        String visitorName = s.nextLine(); // Read the Visitor's Name as a string

        System.out.print("Enter Visit Date (2024-11-08): ");
        String visitDate = s.nextLine();

        PatientVisit visit = new PatientVisit(patientId2, visitorName, visitDate);

        System.out.println("\nPatient Visit Information:");
        System.out.println(visit);


        //INSURANCE
        System.out.print("Enter Insurance Number: ");
        String insuranceNumber = s.nextLine();

        System.out.print("Enter Insurance Type (e.g., Health, Life): ");
        String insuranceType = s.nextLine();

        System.out.print("Enter Insurance Company: ");
        String insuranceCompany = s.nextLine();

        // Create a new Insurance object using the provided data
        Insurance insurance = new Insurance(insuranceNumber, insuranceType, insuranceCompany);

        System.out.println("\nInsurance Information:");
        System.out.println(insurance);


        //EQUIPMENT
        System.out.print("Enter Equipment Name: ");
        String equipmentName = s.nextLine();

        System.out.print("Enter Equipment Type: ");
        String equipmentType = s.nextLine();

        System.out.print("Enter Model Number: ");
        String modelNumber = s.nextLine();

        System.out.print("Is the equipment available? (true/false): ");
        boolean isAvailable = s.nextBoolean(); // Read a boolean value (true/false) indicating availability

        Equipment equipment = new Equipment(equipmentName, equipmentType, modelNumber, isAvailable);

        System.out.println("\nEquipment Information:");
        System.out.println(equipment);


        //PATIENTREFERRAL
         System.out.print("Enter Patient ID: ");
        int patientId1 = s.nextInt();
        s.nextLine();

        System.out.print("Enter Patient Name: ");
        String PatientName = s.nextLine();

        System.out.print("Enter Referral Department: ");
        String referralDepartment = s.nextLine();

        System.out.print("Enter Referral Reason: ");
        String referralReason = s.nextLine();

        System.out.print("Enter Referral Date (YYYY-MM-DD): ");
        String referralDate = s.nextLine();

        System.out.print("Enter Referred By (Doctor Name): ");
        String referredBy = s.nextLine();

        PatientReferral referral = new PatientReferral(patientId1, PatientName, referralDepartment, referralReason, referralDate, referredBy);

        System.out.println("\nPatient Referral Information:");
        System.out.println(referral);



        //EMERGENCY
        System.out.print("Emergency ID: ");
        int emergencyId = s.nextInt();

        System.out.print("Patient ID: ");
        int PatientID = s.nextInt();
        s.nextLine();

        System.out.print("Emergency Type: ");
        String emergencyType = s.nextLine();

        System.out.print("Symptoms: ");
        String symptoms = s.nextLine();

        System.out.print("Severity (Low/Medium/High): ");
        String severity = s.nextLine();

        Emergency emergency = new Emergency(emergencyId, PatientID, emergencyType, symptoms, severity);

        System.out.println("\nEmergency Details:");
        System.out.println(emergency);

        emergency.treatEmergency();  // Assuming treatEmergency() performs some treatment logic
        
        System.out.println("\nAfter Treatment:");
        System.out.println(emergency);


        //EMERGENCYINTERVENTION

        System.out.println("Enter Emergency Intervention ID: ");
        int interventionId = s.nextInt();
        s.nextLine();
        
        System.out.println("Enter Emergency ID: ");
        int EmergencyId = s.nextInt();
        s.nextLine();
        
        System.out.println("Enter Intervention Type (Surgery, Medication): ");
        String interventionType = s.nextLine();
        
        System.out.println("Enter Intervention Time: ");
        String interventionTime = s.nextLine();
        
        System.out.println("Enter Staff Name: ");
        String staffName = s.nextLine();
        
        System.out.println("Enter Intervention Details: ");
        String interventionDetails = s.nextLine();

        EmergencyIntervention intervention = new EmergencyIntervention(interventionId, EmergencyId, interventionType, interventionTime, staffName, interventionDetails);


        // Mark the intervention as successful by invoking the markAsSuccessful method
        intervention.markAsSuccessful();

        System.out.println(intervention);



        //MEDICALPROFESSIONAL, MEDICALDOCTOR, MEDICALNURSE
        System.out.println("Enter Doctor's name:");
        String DoctorName = s.nextLine();
        
        System.out.println("Enter Doctor's ID:");
        int doctorId = s.nextInt();  
        s.nextLine();
        
        System.out.println("Enter Doctor's speciality:");
        String doctorSpeciality = s.nextLine();

        System.out.println("Enter Nurse's name:");
        String NurseName = s.nextLine();
        
        System.out.println("Enter Nurse's ID:");
        int nurseID = s.nextInt();
        s.nextLine();
        
        System.out.println("Enter Nurse's department:");
        String nurseDepartment = s.nextLine();

        // Create instances of MedicalDoctor and MedicalNurse classes with the collected data
        MedicalDoctor doctor1 = new MedicalDoctor(DoctorName, doctorId, doctorSpeciality);
        MedicalNurse nurse1 = new MedicalNurse(NurseName, nurseID, nurseDepartment);

        // Perform duties for both the doctor and the nurse
        doctor1.performDuty();
        nurse1.performDuty();
        
        // Output the information for the doctor and the nurse
        System.out.println(doctor1.getName() + " - " + doctor1.getSpeciality());
        System.out.println(nurse1.getName() + " - " + nurse1.getDepartment());
    
        // Close the scanner to avoid memory leaks
        s.close();

    }
}
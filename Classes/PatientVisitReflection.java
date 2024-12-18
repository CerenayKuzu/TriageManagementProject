import java.lang.reflect.*;
import java.util.List;

public class PatientVisitReflection {
    public static void main(String[] args) {
        try {

            Class<?> patientVisitClass = Class.forName("Classes.PatientVisit");


            Constructor<?> constructor = patientVisitClass.getConstructor(int.class);


            Object patientVisitObj = constructor.newInstance(123);


            Method addVisitMethod = patientVisitClass.getMethod("addVisit", String.class, String.class);


            addVisitMethod.invoke(patientVisitObj, "John Doe", "2024-12-18");


            Method removeVisitMethod = patientVisitClass.getMethod("removeVisit", String.class, String.class);


            removeVisitMethod.invoke(patientVisitObj, "John Doe", "2024-12-18");

            Method clearVisitsMethod = patientVisitClass.getMethod("clearVisits");


            clearVisitsMethod.invoke(patientVisitObj);


            Field patientIdField = patientVisitClass.getDeclaredField("patientId");
            patientIdField.setAccessible(true); 


            int patientIdValue = (int) patientIdField.get(patientVisitObj);
            System.out.println("Patient ID: " + patientIdValue);


            Field visitRecordsField = patientVisitClass.getDeclaredField("visitRecords");
            visitRecordsField.setAccessible(true);


            List<?> visitRecordsValue = (List<?>) visitRecordsField.get(patientVisitObj);
            System.out.println("Visit Records: " + visitRecordsValue);


            Method toStringMethod = patientVisitClass.getMethod("toString");
            String result = (String) toStringMethod.invoke(patientVisitObj);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

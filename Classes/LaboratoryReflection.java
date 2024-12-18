import java.lang.reflect.*;

public class LaboratoryReflection {
    public static void main(String[] args) {
        try {
            Class<?> laboratoryClass = Class.forName("Classes.Laboratory");

            Constructor<?> constructor = laboratoryClass.getConstructor(String.class, String.class, int.class);

            Object laboratoryObj = constructor.newInstance("Central Lab", "New York", 10);

            Method addTestMethod = laboratoryClass.getMethod("addTest", String.class, String.class);

            addTestMethod.invoke(laboratoryObj, "Blood Test", "Negative");
            addTestMethod.invoke(laboratoryObj, "X-ray", "Clear");

            Method toStringMethod = laboratoryClass.getMethod("toString");

            String result = (String) toStringMethod.invoke(laboratoryObj);
            System.out.println(result);

            Field nameField = laboratoryClass.getDeclaredField("name");
            nameField.setAccessible(true); 

            String nameValue = (String) nameField.get(laboratoryObj);
            System.out.println("Laboratory Name: " + nameValue);

            Field locationField = laboratoryClass.getDeclaredField("location");
            locationField.setAccessible(true);

            String locationValue = (String) locationField.get(laboratoryObj);
            System.out.println("Laboratory Location: " + locationValue);

            Field testTypesField = laboratoryClass.getDeclaredField("testTypes");
            Field resultsField = laboratoryClass.getDeclaredField("results");
            testTypesField.setAccessible(true);
            resultsField.setAccessible(true);

            String[] testTypesValue = (String[]) testTypesField.get(laboratoryObj);
            String[] resultsValue = (String[]) resultsField.get(laboratoryObj);

            System.out.println("Tests in Laboratory:");
            for (int i = 0; i < testTypesValue.length; i++) {
                if (testTypesValue[i] != null) {
                    System.out.println("Test: " + testTypesValue[i] + ", Result: " + resultsValue[i]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

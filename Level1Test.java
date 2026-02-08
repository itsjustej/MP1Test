import java.io.*;

public class Level1Test {
    public static void main(String[] args) {
        try {
            // 1. Test Constructor & Setters
            Appointment appt = new Appointment();
            appt.setPatientID(123);
            appt.setApptDate("02/27/2026");

            // 2. Test toString delimiter (*)
            String output = appt.toString();
            if (output.contains("*")) {
                System.out.println("ToString Delimiter Check: PASS");
            } else {
                throw new Exception("toString must use '*' as a separator."); [cite: 12]
            }
        } catch (Exception e) {
            System.err.println("Test Failed: " + e.getMessage());
            System.exit(1); // Exit with error for GitHub to mark as Fail
        }
    }
}
import java.util.ArrayList;

public class Level2Test {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Level 2: Patient Class Validation...");

            // 1. Create Patient using Parameterized Constructor
            // Format: firstName, lastName, patientID, gender, dob, primaryPhysician
            Patient p = new Patient("John", "Doe", 101, 'M', "01/01/1990", "House, Gregory");

            // 2. Create 2 Appointment objects (from Level 1)
            Appointment appt1 = new Appointment(101, "02/27/2026", "House, Gregory", 70.0, 180.0, 98.6, 72, 120, 80, "Checkup 1");
            Appointment appt2 = new Appointment(101, "03/15/2026", "Wilson, James", 70.0, 181.0, 99.1, 75, 122, 82, "Checkup 2");

            // 3. Test ArrayList Management Methods (Strict Naming)
            p.addAppointment(appt1);
            p.addAppointment(appt2);

            if (p.getAppointmentSize() != 2) {
                throw new Exception("getAppointmentSize() failed. Expected 2, found: " + p.getAppointmentSize());
            }

            if (p.getAppointment(0) != appt1 || p.getAppointment(1) != appt2) {
                throw new Exception("getAppointment(index) or addAppointment() failed.");
            }
            System.out.println("ArrayList Management (add/get/size): PASS");

            // 4. Test toString() Aggregation
            String lineSep = System.getProperty("line.separator");
            String output = p.toString();

            // Check if Patient info is present
            if (!output.contains("John") || !output.contains("Doe") || !output.contains("House, Gregory")) {
                throw new Exception("Patient toString() missing basic patient info.");
            }

            // Check if Appointment toStrings are embedded (look for the '*' from Level 1)
            if (!output.contains("Checkup 1") || !output.contains("Checkup 2") || !output.contains("*")) {
                throw new Exception("Patient toString() did not correctly include Appointment toString() data.");
            }

            // Check for line separators
            if (!output.contains(lineSep)) {
                throw new Exception("Patient toString() must use System.getProperty(\"line.separator\") as a delimiter.");
            }

            System.out.println("Patient toString() Aggregation: PASS");
            System.out.println("LEVEL 2 COMPLETE: 25/25 (Total 45%)");

        } catch (Exception e) {
            System.err.println("LEVEL 2 FAILED: " + e.getMessage());
            System.exit(1);
        }
    }
}
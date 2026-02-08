import java.util.ArrayList;

public class Level2Test {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Level 2: Patient Class Validation...");

            // 1. Create Patient using Parameterized Constructor
            Patient p = new Patient(101, "John", "Doe", 'M', "01/01/1990", "House, Gregory");

            // 2. Create Appointment objects
            Appointment appt1 = new Appointment(101, "02/27/2026", "House, Gregory", 70.0, 180.0, 98.6, 72, 120, 80, "Checkup 1");
            Appointment appt2 = new Appointment(101, "03/15/2026", "Wilson, James", 70.0, 181.0, 99.1, 75, 122, 82, "Checkup 2");
            Appointment apptReplacement = new Appointment(101, "04/01/2026", "Cuddy, Lisa", 70.0, 179.0, 98.4, 68, 118, 78, "Updated Appt");

            // 3. Test addAppointment and getAppointmentSize
            p.addAppointment(appt1);
            p.addAppointment(appt2);
            if (p.getAppointmentSize() != 2) {
                throw new Exception("getAppointmentSize() failed. Expected 2, found: " + p.getAppointmentSize());
            }

            // 4. Test getAppointment
            if (p.getAppointment(0) != appt1) {
                throw new Exception("getAppointment(0) failed to return the correct object.");
            }

            // 5. Test setAppointment (Method 4 of 5)
            p.setAppointment(1, apptReplacement);
            if (p.getAppointment(1) != apptReplacement) {
                throw new Exception("setAppointment() failed to update the appointment at the given index.");
            }
            System.out.println("setAppointment: PASS");

            // 6. Test removeAppointment (Method 5 of 5)
            Appointment removed = p.removeAppointment(0);
            if (removed != appt1 || p.getAppointmentSize() != 1) {
                throw new Exception("removeAppointment() failed. Either wrong object returned or size not updated.");
            }
            System.out.println("removeAppointment: PASS");

            // 7. Test toString() Aggregation (System Line Separator)
            String lineSep = System.getProperty("line.separator");
            String output = p.toString();

            if (!output.contains("John") || !output.contains("Doe")) {
                throw new Exception("Patient toString() missing basic patient info.");
            }

            // Should contain the replacement appt but not the removed one
            if (!output.contains("Updated Appt") || output.contains("Checkup 1")) {
                throw new Exception("Patient toString() logic error with ArrayList contents.");
            }

            if (!output.contains(lineSep)) {
                throw new Exception("Patient toString() must use System.getProperty(\"line.separator\").");
            }

            System.out.println("All 5 ArrayList Methods & toString: PASS");
            System.out.println("LEVEL 2 COMPLETE: 25/25");

        } catch (Exception e) {
            System.err.println("LEVEL 2 FAILED: " + e.getMessage());
            System.exit(1);
        }
    }
}

import java.io.*;
import java.util.ArrayList;

public class Level3Test {
    public static void main(String[] args) {
        String initialInput = "initial_test.txt";
        String secondOutput = "modified_output.txt";

        try {
            System.out.println("Starting Level 3: Comprehensive File I/O Round-Trip...");

            // 1. Create Initial Input File
            PrintWriter pw = new PrintWriter(new File(initialInput));
            pw.println("Aggie Medical Associates");
            pw.println("1");
            pw.println("Jones, Isaiac");
            pw.println("1");
            pw.println("3376");
            pw.println("JoAnne");
            pw.println("Fellows");
            pw.println("F");
            pw.println("02/14/2000");
            pw.println("Jones, Isaiac");
            pw.println("1");
            pw.println("3376*09/26/2024*Jones, Isaiac*65.0*143.0*97.1*75*125*70*Note1");
            pw.close();

            // 2. Populate MedicalOffice from File
            MedicalOffice office = new MedicalOffice();
            office.readMedicalOfficeData(initialInput);
            System.out.println("Initial Read: PASS");

            // 3. Add More Information (Combo of new Physician and new Patient)
            office.addPhysician("Hanson, Charles");
            
            Patient newPatient = new Patient(4330, "Leroy", "Brown", 'M', "05/19/1985", "Hanson, Charles");
            Appointment newAppt = new Appointment(4330, "11/19/2025", "Hanson, Charles", 75.0, 254.0, 96.8, 80, 140, 90, "Note2");
            newPatient.addAppointment(newAppt);
            office.addPatient(newPatient);
            
            if (office.getPhysiciansSize() != 2 || office.getPatientsSize() != 2) {
                throw new Exception("Adding new objects to MedicalOffice failed.");
            }
            System.out.println("In-Memory Modification: PASS");

            // 4. Save Modified Data and Re-Read to Check Consistency
            office.saveMedicalOfficeData(secondOutput);
            
            MedicalOffice officeCheck = new MedicalOffice();
            officeCheck.readMedicalOfficeData(secondOutput);
            
            // Compare results
            String originalString = office.toString();
            String loadedString = officeCheck.toString();

            if (!originalString.equals(loadedString)) {
                throw new Exception("Consistency Check Failed: Saved data does not match re-loaded data.");
            }
            
            // Final check for specific new data in the re-loaded object
            if (!loadedString.contains("Leroy") || !loadedString.contains("Hanson, Charles")) {
                throw new Exception("Re-loaded data missing newly added information.");
            }

            System.out.println("Round-Trip Consistency: PASS");
            System.out.println("LEVEL 3 COMPLETE: 30/30 (Total 75%)");

        } catch (Exception e) {
            System.err.println("LEVEL 3 FAILED: " + e.getMessage());
            System.exit(1);
        }
    }
}

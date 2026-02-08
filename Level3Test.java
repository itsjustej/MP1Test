import java.io.*;
import java.util.ArrayList;

public class Level3Test {
    public static void main(String[] args) {
        String testInput = "test_input.txt";
        String testOutput = "test_output.txt";

        try {
            // 1. Create a dummy input file for the student to read
            PrintWriter pw = new PrintWriter(new File(testInput));
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
            pw.println("3376*09/26/2024*Jones, Isaiac*65.0*143.0*97.1*75*125*70*Notes");
            pw.close();

            System.out.println("Starting Level 3: File I/O Validation...");

            // 2. Test reading functionality
            MedicalOffice office = new MedicalOffice();
            office.readMedicalOfficeData(testInput);

            if (!office.getPracticeName().equals("Aggie Medical Associates")) {
                throw new Exception("Practice name not read correctly.");
            }
            if (office.getPhysiciansSize() != 1 || office.getPatientsSize() != 1) {
                throw new Exception("Physician or Patient count mismatch.");
            }

            // 3. Deep check of the nested objects
            Patient p = office.getPatient(0);
            if (p.getAppointmentSize() != 1) {
                throw new Exception("Patient appointments not read correctly.");
            }
            System.out.println("File Reading and Object Mapping: PASS");

            // 4. Test saving functionality
            office.saveMedicalOfficeData(testOutput);
            File outFile = new File(testOutput);
            if (!outFile.exists()) {
                throw new Exception("saveMedicalOfficeData() did not create an output file.");
            }
            System.out.println("File Saving: PASS");

            System.out.println("LEVEL 3 COMPLETE: 30/30 (Total 75%)");

        } catch (Exception e) {
            System.err.println("LEVEL 3 FAILED: " + e.getMessage());
            System.exit(1);
        }
    }
}
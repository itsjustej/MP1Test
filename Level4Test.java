import java.io.*;

public class Level4Test {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Level 4: Explicit Sort and String Validation...");

            // 1. Setup MedicalOffice
            MedicalOffice office = new MedicalOffice("Selection Sort Clinic");

            // 2. Add Physicians in random alphabetical order
            // Testing: Alphabetical and Tie-breaker (Apple, Aaron vs Apple, Adam)
            office.addPhysician("Zebra, Zane");
            office.addPhysician("Apple, Adam");
            office.addPhysician("Apple, Aaron");

            // 3. Add Patients with shared last names
            // Testing: Primary (LastName) and Secondary (FirstName) sort
            office.addPatient(new Patient(10, "Charlie", "Brown", 'M', "01/01/1980", "Doc A"));
            office.addPatient(new Patient(5, "Alice", "Brown", 'F', "01/01/1985", "Doc B"));
            office.addPatient(new Patient(1, "Xavier", "Adams", 'M', "01/01/1990", "Doc C"));

            // 4. PERFORM THE ACTION (Separate from toString)
            // This method should call your private sortPhysicians() and sortPatients()
            office.sortData(); 
            System.out.println("Sort command executed.");

            // 5. OBSERVE THE RESULTS
            String result = office.toString();

            // Verification: Physicians (Should be Aaron -> Adam -> Zane)
            int posAaron = result.indexOf("Apple, Aaron");
            int posAdam = result.indexOf("Apple, Adam");
            int posZane = result.indexOf("Zebra, Zane");

            if (posAaron == -1 || posAdam == -1 || posZane == -1) {
                throw new Exception("Physician names missing or formatted incorrectly in toString.");
            }
            if (!(posAaron < posAdam && posAdam < posZane)) {
                throw new Exception("Physician Selection Sort failed. Order is incorrect.");
            }
            System.out.println("Physician Selection Sort: PASS");

            // Verification: Patients (Should be Adams -> Brown, Alice -> Brown, Charlie)
            int posAdams = result.indexOf("Adams");
            int posAlice = result.indexOf("Alice");
            int posCharlie = result.indexOf("Charlie");

            if (posAdams == -1 || posAlice == -1 || posCharlie == -1) {
                throw new Exception("Patient names missing or formatted incorrectly in toString.");
            }
            if (!(posAdams < posAlice && posAlice < posCharlie)) {
                throw new Exception("Patient Selection Sort failed. Expected Adams -> Brown(Alice) -> Brown(Charlie).");
            }
            System.out.println("Patient Selection Sort: PASS");

            System.out.println("LEVEL 4 COMPLETE: 25/25 (Final Level)");

        } catch (Exception e) {
            System.err.println("LEVEL 4 FAILED: " + e.getMessage());
            System.exit(1);
        }
    }
}

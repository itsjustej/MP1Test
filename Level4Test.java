import java.io.*;
import java.util.ArrayList;

public class Level4Test {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Level 4: Selection Sort Validation...");

            MedicalOffice office = new MedicalOffice("Sorting Test Clinic");

            // 1. Add Physicians in unsorted order
            office.addPhysician("Zebra, Zane");
            office.addPhysician("Apple, Adam");
            office.addPhysician("Apple, Aaron"); // Tie-breaker test

            // 2. Add Patients with last name ties
            // Requirement: Sort by lastname, then firstname
            Patient p1 = new Patient(1, "Charlie", "Brown", 'M', "DOB", "Doc");
            Patient p2 = new Patient(2, "Alice", "Brown", 'F', "DOB", "Doc"); // Should come before Charlie
            Patient p3 = new Patient(3, "Xavier", "Adams", 'M', "DOB", "Doc"); // Should come first

            office.addPatient(p1);
            office.addPatient(p2);
            office.addPatient(p3);

            // 3. Trigger Sorts 
            // Note: Since the methods are private, we assume they are called 
            // within the save or toString logic as per typical assignment flow.
            String sortedOutput = office.toString();

            // 4. Verify Physician Sort (Aaron -> Adam -> Zane)
            int indexAaron = sortedOutput.indexOf("Apple, Aaron");
            int indexAdam = sortedOutput.indexOf("Apple, Adam");
            int indexZane = sortedOutput.indexOf("Zebra, Zane");

            if (indexAaron > indexAdam || indexAdam > indexZane) {
                throw new Exception("Physician Selection Sort failed. Check tie-breaker logic.");
            }
            System.out.println("Physician Sorting: PASS");

            // 5. Verify Patient Sort (Adams, Xavier -> Brown, Alice -> Brown, Charlie)
            int indexAdamsX = sortedOutput.indexOf("Adams");
            int indexBrownA = sortedOutput.indexOf("Alice");
            int indexBrownC = sortedOutput.indexOf("Charlie");

            if (indexAdamsX > indexBrownA || indexBrownA > indexBrownC) {
                throw new Exception("Patient Selection Sort failed. Expected Adams -> Brown (Alice) -> Brown (Charlie).");
            }
            System.out.println("Patient Sorting: PASS");

            System.out.println("LEVEL 4 COMPLETE: 25/25 (Total 100%)");

        } catch (Exception e) {
            System.err.println("LEVEL 4 FAILED: " + e.getMessage());
            System.exit(1);
        }
    }
}
import java.io.*;

public class Level1Test {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Full Level 1 Property Validation...");

            // 1. Test No-arg Constructor and ALL Setters/Getters
            Appointment a = new Appointment();
            
            // Set values based on UML data types 
            a.setPatientID(999);
            a.setApptDate("12/25/2025");
            a.setPhysician("Doe, Jane");
            a.setHeight(65.0);
            a.setWeight(150.5);
            a.setTemperature(98.2);
            a.setPulse(70);
            a.setBpSystolic(115);
            a.setBpDiastolic(75);
            a.setNotes("Test Notes Content");

            // Comprehensive Verification
            if (a.getPatientID() != 999) throw new Exception("Field 'patientID' failed validation.");
            if (!a.getApptDate().equals("12/25/2025")) throw new Exception("Field 'apptDate' failed validation.");
            if (!a.getPhysician().equals("Doe, Jane")) throw new Exception("Field 'physician' failed validation.");
            if (a.getHeight() != 65.0) throw new Exception("Field 'height' failed validation.");
            if (a.getWeight() != 150.5) throw new Exception("Field 'weight' failed validation.");
            if (a.getTemperature() != 98.2) throw new Exception("Field 'temperature' failed validation.");
            if (a.getPulse() != 70) throw new Exception("Field 'pulse' failed validation.");
            if (a.getBpSystolic() != 115) throw new Exception("Field 'bpSystolic' failed validation.");
            if (a.getBpDiastolic() != 75) throw new Exception("Field 'bpDiastolic' failed validation.");
            if (!a.getNotes().equals("Test Notes Content")) throw new Exception("Field 'notes' failed validation.");

            System.out.println("All Setters and Getters: PASS");

            // 2. Test Parameterized Constructor
            // This ensures they didn't just hardcode the no-arg constructor [cite: 52]
            Appointment a2 = new Appointment(888, "01/01/2026", "Smith, John", 72.0, 190.0, 98.6, 60, 120, 80, "Initial Visit");
            if (a2.getPatientID() != 888 || !a2.getNotes().equals("Initial Visit")) {
                throw new Exception("Parameterized constructor failed to map values correctly.");
            }
            System.out.println("Parameterized Constructor: PASS");

            // 3. Test toString Delimiter (*)
            // The PDF requires properties separated by "*" 
            String ts = a.toString();
            int delimiterCount = ts.length() - ts.replace("*", "").length();
            
            // There are 10 fields, so there should be at least 9 '*' separators
            if (delimiterCount < 9) {
                throw new Exception("toString format incorrect. Expected '*' separators between fields, found: " + delimiterCount);
            }
            System.out.println("toString Format (*): PASS");

            System.out.println("LEVEL 1 COMPLETE: 20/20");

        } catch (Exception e) {
            System.err.println("LEVEL 1 FAILED: " + e.getMessage());
            System.exit(1); 
        }
    }
}

import java.io.*;

public class Level1Test {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Strict Level 1 Property and toString Validation...");

            // 1. Test No-arg Constructor and ALL Setters/Getters
            Appointment a = new Appointment();
            
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

            // Comprehensive Verification for Setters/Getters
            if (a.getPatientID() != 999) throw new Exception("Field 'patientID' failed validation.");
            if (!a.getApptDate().equals("12/25/2025")) throw new Exception("Field 'apptDate' failed validation.");
            if (!a.getPhysician().equals("Doe, Jane")) throw new Exception("Field 'physician' failed validation.");
            if (Math.abs(a.getHeight() - 65.0) > 0.001) throw new Exception("Field 'height' failed validation.");
            if (Math.abs(a.getWeight() - 150.5) > 0.001) throw new Exception("Field 'weight' failed validation.");
            if (Math.abs(a.getTemperature() - 98.2) > 0.001) throw new Exception("Field 'temperature' failed validation.");
            if (a.getPulse() != 70) throw new Exception("Field 'pulse' failed validation.");
            if (a.getBpSystolic() != 115) throw new Exception("Field 'bpSystolic' failed validation.");
            if (a.getBpDiastolic() != 75) throw new Exception("Field 'bpDiastolic' failed validation.");
            if (!a.getNotes().equals("Test Notes Content")) throw new Exception("Field 'notes' failed validation.");

            System.out.println("All Setters and Getters: PASS");

            // 2. Test Parameterized Constructor
            // Standard UML order: patientID, apptDate, physician, height, weight, temperature, pulse, bpSystolic, bpDiastolic, notes
            Appointment a2 = new Appointment(888, "01/01/2026", "Smith, John", 72.0, 190.0, 98.6, 60, 120, 80, "Initial Visit");
            
            if (a2.getPatientID() != 888 || !a2.getNotes().equals("Initial Visit")) {
                throw new Exception("Parameterized constructor failed to map values correctly.");
            }
            System.out.println("Parameterized Constructor Mapping: PASS");

            // 3. Verify toString (Strict: No spaces around *) 
            String ts = a2.toString();
            String expected = "888*01/01/2026*Smith, John*72.0*190.0*98.6*60*120*80*Initial Visit";
            
            if (!ts.equals(expected)) {
                throw new Exception("toString format incorrect.\nExpected (Strict): " + expected + "\nActual: " + ts);
            }
            
            System.out.println("toString Strict Format (*): PASS");
            System.out.println("LEVEL 1 COMPLETE: 20/20");

        } catch (Exception e) {
            System.err.println("LEVEL 1 FAILED: " + e.getMessage());
            System.exit(1); 
        }
    }
}

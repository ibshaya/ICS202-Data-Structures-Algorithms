import java.util.Arrays;
import java.util.Random;

public class Hospital {
    public static void main(String[] args) {
        // Create an array of 10 patients with random emergency levels
        Patient[] patients = new Patient[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = generateRandomName();
            int emergencyLevel = random.nextInt(5) + 1; // Random emergency level between 1 and 5
            patients[i] = new Patient(name, emergencyLevel);
        }

        // Print the original order of patients arrival
        System.out.println("The original order of patients arrival is>>");
        for (Patient patient : patients) {
            System.out.println("Patient Name>> " + patient.getName() + ", Emergency Level>> " + patient.getEmergencyLevel());
        }

        // Create a binary heap of patients
        BinaryHeap patientHeap = new BinaryHeap(patients);

        // Print the treatment order of patients after heap sort
        System.out.println("The TREATMENT order of patients is>>");
        while (!patientHeap.isEmpty()) {
            Patient treatedPatient = (Patient) patientHeap.dequeueMin();
            System.out.println("Patient Name>> " + treatedPatient.getName() + ", Emergency Level>> " + treatedPatient.getEmergencyLevel());
        }
    }

    // Method to generate random patient names
    private static String generateRandomName() {
        String[] names = {"Sun", "Ali", "Tom", "Pat", "Bert", "Rais"};
        Random random = new Random();
        return names[random.nextInt(names.length)] + "-" + random.nextInt(100);
    }
}

// Patient class extending Comparable to allow comparison based on emergency level and name
class Patient implements Comparable<Patient> {
    private String name;
    private int emergencyLevel;

    public Patient(String name, int emergencyLevel) {
        this.name = name;
        this.emergencyLevel = emergencyLevel;
    }

    public String getName() {
        return name;
    }

    public int getEmergencyLevel() {
        return emergencyLevel;
    }

    @Override
    public int compareTo(Patient other) {
        // First, compare based on emergency level
        int emergencyLevelComparison = Integer.compare(this.emergencyLevel, other.emergencyLevel);
        if (emergencyLevelComparison != 0) {
            return emergencyLevelComparison;
        }
        // If emergency levels are the same, compare based on name
        return this.name.compareTo(other.name);
    }
}


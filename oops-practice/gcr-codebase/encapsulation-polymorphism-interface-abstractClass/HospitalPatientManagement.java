import java.util.*;

abstract class Patient{
    private String patientId;
    private String name;
    private int age;

    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age, String diagnosis){
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getPatientId(){
        return patientId;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    protected void addMedicalHistory(String record) {
        medicalHistory.add(record);
    }
    protected void showMedicalHistory() {
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }

    public abstract double calculateBill();

    public void getPatientDetails(){
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
    }
}

interface MedicalRecord{
    public void addRecord(String record);
    public void viewRecords();
}

class InPatient extends Patient implements MedicalRecord{
    private int daysAdmitted;
    private static final double DAILY_CHARGE = 2000;

    public InPatient(String id, String name, int age, String diagnosis, int daysAdmitted) {
        super(id, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
    }

    public double calculateBill() {
        return daysAdmitted * DAILY_CHARGE;
    }

    @Override
    public void addRecord(String record) {
        addMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        showMedicalHistory();
    }
}

class OutPatient extends Patient implements MedicalRecord{
    private static final double CONSULTATION_FEE = 500;

    public OutPatient(String id, String name, int age, String diagnosis) {
        super(id, name, age, diagnosis);
    }

    @Override
    public double calculateBill() {
        return CONSULTATION_FEE;
    }

    @Override
    public void addRecord(String record) {
        addMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        showMedicalHistory();
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args){
        List<Patient> patients = new ArrayList<>();

        Patient p1 = new InPatient("IP101", "Ramesh", 45, "Pneumonia", 5);
        Patient p2 = new OutPatient("OP201", "Shivam", 30, "Fever");

        patients.add(p1);
        patients.add(p2);

        // Add medical records
        ((MedicalRecord) p1).addRecord("Chest X-Ray");
        ((MedicalRecord) p1).addRecord("Antibiotics prescribed");

        ((MedicalRecord) p2).addRecord("Blood test");
        ((MedicalRecord) p2).addRecord("Paracetamol advised");

        for (Patient patient : patients) {
            System.out.println("\n--- Patient Details ---");
            patient.getPatientDetails();
            System.out.println("Total Bill : " + patient.calculateBill());

            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }
        }
    }
}

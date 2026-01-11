import java.util.*;

class Patient{
    private String name;
    private int patientId;
    private int age;
    private String gender;

    public Patient(String name, int patientId, int age, String gender){
        this.name = name;
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
    }

    public int getPatientId(){
        return patientId;
    }
    public String getName(){
        return name;
    }

    public void displayInfo(){
        System.out.println("Patient Name: " + name);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Age: " + age);
        System.out.println("Patient Gender: " + gender);
    }
}
class InPatient extends Patient implements IPayable{
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(String name, int patientId, int age, String gender, int daysAdmitted, double dailyCharge){
        super(name, patientId, age, gender);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    public double calculateBill(){
        return daysAdmitted * dailyCharge;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Type: In Patient");
        System.out.println("Number Of Days Admitted: " + daysAdmitted);
        System.out.println("Total Bill: " + calculateBill());
    }
}

class OutPatient extends Patient implements IPayable{
    private double consultationCharge;

    public OutPatient(String name, int patientId, int age, String gender, double consultationCharge){
        super(name, patientId, age, gender);
        this.consultationCharge = consultationCharge;
    }

    public double calculateBill(){
        return consultationCharge;
    }

    public void displayInfo(){
        System.out.println("Type: Out Patient");
        System.out.println("Consultation Charge: " + consultationCharge);
        System.out.println("Total Bill: " + calculateBill());
    }
}

class Doctor{
    private String name;
    private String department;
    private int doctorId;

    public Doctor(String name, String department, int doctorId){
        this.name = name;
        this.department = department;
        this.doctorId = doctorId;
    }

    public void displayInfo(){
        System.out.println("Doctor Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Doctor ID: " + doctorId);
    }
}

interface IPayable{
    double calculateBill();
}

public class HospitalPatientManagementSystem {
    static List<Patient> patients = new ArrayList<>();

    public static void addPatient(Patient patient){
        patients.add(patient);
        System.out.println("Patient Added successfully");
    }
    public static void viewPatients(){
        if(patients.isEmpty()){
            System.out.println("No Patients found");
        }
        for(Patient p : patients){
            p.displayInfo();
        }
    }
    public static void updatePatientName(int id, String newName) {
        for (Patient p : patients) {
            if (p.getPatientId() == id) {
                System.out.println("Patient name updated.\n");
                return;
            }
        }
        System.out.println("Patient not found.\n");
    }
    public static void deletePatient(int id) {
        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPatientId() == id) {
                iterator.remove();
                System.out.println("Patient removed.\n");
                return;
            }
        }
        System.out.println("Patient not found.\n");
    }

     public static void main(String[] args) {

        Patient p1 = new InPatient("Arun", 101, 24, "Male", 5, 2000);
        Patient p2 = new OutPatient("Anita", 102, 35, "Female", 500);

        addPatient(p1);
        addPatient(p2);

        viewPatients();

        deletePatient(101);
        viewPatients();
    }
}

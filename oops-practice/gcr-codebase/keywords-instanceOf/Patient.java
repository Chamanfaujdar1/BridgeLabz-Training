public class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    String name;
    int age;
    String ailment;
    final String patientID;

    Patient(String patientID, String name, int age, String ailment){
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;

        totalPatients++;
    }

    public static void getTotalPatients(){
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    void displayDetails(){
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }

    public static void main(String[] args){
        Patient patient1 = new Patient("P001", "Lathika", 30, "Flu");
        Patient patient2 = new Patient("P002", "Lidiya", 45, "Fracture");

        Patient.getTotalPatients();

        if(patient1 instanceof Patient){
            patient1.displayDetails();
        }

        if(patient2 instanceof Patient){
            patient2.displayDetails();
        }
    }
}

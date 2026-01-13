package hospital_management;

public class HospitalTest {
    public static void main(String[] args) {
        Patient p1 = new InPatient(1, "Ravi", 40, 5, 2000);
        Patient p2 = new OutPatient(2, "Meena", 30, 500);

        p1.displayInfo();
        p2.displayInfo();
    }
}
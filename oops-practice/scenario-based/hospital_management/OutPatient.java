package hospital_management;

public class OutPatient extends Patient implements IPayable {
    double fee;

    public OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.fee = fee;
    }

    public double calculateBill() {
        return fee;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: OutPatient Bill: " + calculateBill());
    }
}
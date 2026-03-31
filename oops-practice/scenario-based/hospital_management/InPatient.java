package hospital_management;

public class InPatient extends Patient implements IPayable {
    int days;
    double rate;

    public InPatient(int id,String name,int age,int days,double rate){
        super(id,name,age);
        this.days=days;
        this.rate=rate;
    }

    public double calculateBill(){
        return days*rate;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Type: InPatient Bill: "+calculateBill());
    }
}
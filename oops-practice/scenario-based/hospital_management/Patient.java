package hospital_management;

public class Patient {
    protected int id;
    protected String name;
    protected int age;

    public Patient(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public void displayInfo(){
        System.out.println(id+" "+name+" "+age);
    }
}
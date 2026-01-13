public class Ride {
    User user;
    Driver driver;
    double fare;

    public Ride(User user,Driver driver,double fare){
        this.user=user;
        this.driver=driver;
        this.fare=fare;
    }

    void display(){
        System.out.println(user.name+" booked ride with "+driver.name+" Fare: "+fare);
    }
}
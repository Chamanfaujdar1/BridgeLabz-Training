public class CabBookingSystem {

    static Driver[] drivers={
        new Driver("Ravi"),
        new Driver("Amit")
    };

    static Ride[] history=new Ride[10];
    static int idx=0;

    static Driver assignDriver() throws NoDriverAvailableException{
        for(Driver d:drivers){
            if(d.available){
                d.available=false;
                return d;
            }
        }
        throw new NoDriverAvailableException("No Driver Available");
    }

    static void bookRide(User u,double km,boolean peak){
        try{
            Driver d=assignDriver();
            FareCalculator fc=peak?new PeakFare():new NormalFare();
            double fare=fc.calculateFare(km);
            Ride r=new Ride(u,d,fare);
            history[idx++]=r;
            r.display();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    static void showHistory(){
        for(int i=0;i<idx;i++)
            history[i].display();
    }

    public static void main(String[] args){
        User u1=new User("Rahul");
        bookRide(u1,10,false);
        bookRide(u1,8,true);
        showHistory();
    }
}
public class HotelBooking {
    String guestName;
    String roomType;
    int numberOfNights;

    public HotelBooking(){
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.numberOfNights = 1;
    }

    public HotelBooking(String guestName, String roomType, int numberOfNights){
        this.guestName = guestName;
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
    }

    public HotelBooking(HotelBooking booking){
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.numberOfNights = booking.numberOfNights;
    }

    public void displayBookingInfo(){
        System.out.println("Guest name: " + guestName);
        System.out.println("Room type: " + roomType);
        System.out.println("Number of nights: " + numberOfNights);
        System.out.println("--------------");
    }

    public static void main(String[] args){
        HotelBooking defaultBooking = new HotelBooking();
        System.out.println("Default Booking: ");
        defaultBooking.displayBookingInfo();

        HotelBooking person1 = new HotelBooking("Amit", "Fully Air Conditioned", 3);
        System.out.println("Person1 Booking: ");
        person1.displayBookingInfo();

        HotelBooking person2 = new HotelBooking(person1);
        person2.guestName = "Sumit";
        System.out.println("Modified the person2's guest name");
        person2.displayBookingInfo();
    }
}

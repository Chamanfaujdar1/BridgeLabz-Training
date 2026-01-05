public class Circle {
    double radius;

    Circle(){
        this(1.0);
        System.out.println("Default constructor called");
    }

    Circle(double radius){
        this.radius = radius;
        System.out.println("Parameterized constructor called");
    }

    void displayArea(){
        double area = Math.PI * radius * radius;
        System.out.println("Area of circle with radius " + radius + " is: " + area);
    }

    public static void main(String[] args){
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);

        circle1.displayArea();
        circle2.displayArea();
    }
}

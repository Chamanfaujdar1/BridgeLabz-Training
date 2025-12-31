public class Circle {
    double radius;
    double area;
    double circumference;

    Circle(double radius){
        this.radius = radius;
    }
    public void Calculate(){
        this.area = Math.PI * radius * radius;
        this.circumference = 2 * Math.PI * radius;
    }

    public void Display(){
        System.out.println("Area of Circle: " + area);
        System.out.println("Circumference of Circle: " + circumference);
    }

    public static void main(String[] args){
        Circle circle = new Circle(10);
        circle.Calculate();
        circle.Display();
    }
}

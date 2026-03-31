class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        if (cgpa >= 0.0 && cgpa <= 10.0) {
            this.cgpa = cgpa;
        } else {
            System.out.println("Invalid CGPA value!");
        }
    }
}

// Subclass to demonstrate 'protected' access
class PostgraduateStudent extends Student {
    String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double cgpa, String topic) {
        super(rollNumber, name, cgpa);
        this.researchTopic = topic;
    }

    public void displayPGDetails() {
        // 'name' is accessible here because it is protected in the parent class
        // 'cgpa' is NOT accessible here directly; we must use the public getter
        System.out.println("PG Student Name: " + name); 
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("Current CGPA: " + getCgpa());
        System.out.println("-------------------------");
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Aravind", 8.5, "Machine Learning");
        
        pg.displayPGDetails();

        // Modifying CGPA using public setter
        pg.setCgpa(9.2);
        System.out.println("After updating CGPA:");
        pg.displayPGDetails();
    }
}
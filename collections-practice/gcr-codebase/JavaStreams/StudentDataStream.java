import java.io.*;

public class StudentDataStream {

    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {

        writeStudentData();

        System.out.println("\n Reading Student Data from File:");
        System.out.println("----------");

        readStudentData();
    }

    private static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {

            dos.writeInt(3); 

            dos.writeInt(101);
            dos.writeUTF("Amit");
            dos.writeDouble(8.7);

            dos.writeInt(102);
            dos.writeUTF("Neha");
            dos.writeDouble(9.1);

            dos.writeInt(103);
            dos.writeUTF("Rahul");
            dos.writeDouble(7.9);

            System.out.println("Student data stored successfully in " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error while writing data: " + e.getMessage());
        }
    }

    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {

            int totalStudents = dis.readInt();

            for (int i = 1; i <= totalStudents; i++) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Student " + i + " -> Roll No: " + rollNo +
                        ", Name: " + name +
                        ", GPA: " + gpa);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error while reading data: " + e.getMessage());
        }
    }
}

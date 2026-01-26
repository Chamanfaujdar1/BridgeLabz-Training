import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaveUserInfoToFile {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter your Name: ");
            String name = br.readLine();

            System.out.print("Enter your Age: ");
            int age = Integer.parseInt(br.readLine());

            System.out.print("Enter your Favorite Programming Language: ");
            String language = br.readLine();

            FileWriter writer = new FileWriter("user_details.txt");
            writer.write("----- User Details -----\n");
            writer.write("Name     : " + name + "\n");
            writer.write("Age      : " + age + "\n");
            writer.write("Language : " + language + "\n");
            writer.close();

            System.out.println("\n User details saved successfully into user_details.txt");

        } catch (NumberFormatException e) {
            System.out.println("Invalid age! Please enter a numeric value.");

        } catch (IOException e) {
            System.out.println("Error while reading input or writing file: " + e.getMessage());
        }
    }
}

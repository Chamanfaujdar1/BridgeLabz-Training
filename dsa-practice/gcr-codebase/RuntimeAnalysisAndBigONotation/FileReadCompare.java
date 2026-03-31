import java.io.*;

public class FileReadCompare {

    static void readFR() throws Exception {
        FileReader fr = new FileReader("data.txt");
        while (fr.read() != -1) {
        }
        fr.close();
    }

    static void readISR() throws Exception {
        FileInputStream fis = new FileInputStream("data.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        while (isr.read() != -1) {
        }
        isr.close();
    }

    public static void main(String[] args) throws Exception {
        long s1 = System.nanoTime();
        readFR();
        long e1 = System.nanoTime();

        long s2 = System.nanoTime();
        readISR();
        long e2 = System.nanoTime();

        System.out.println("FileReader: " + (e1 - s1));
        System.out.println("InputStreamReader: " + (e2 - s2));
    }
}
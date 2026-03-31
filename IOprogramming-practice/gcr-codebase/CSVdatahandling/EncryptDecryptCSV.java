package collections_practice.gcr_codebase.csv_data_handling;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {

    private static final String SECRET_KEY = "1234567890123456"; // 16 chars = AES-128

    public static void main(String[] args) throws Exception {

        String inputCsv = "";
        String encryptedCsv = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\employees_encrypted.csv";

        writeEncryptedCSV(inputCsv, encryptedCsv);
        readAndDecryptCSV(encryptedCsv);
    }

    // ---------------- WRITE ENCRYPTED CSV ----------------
    public static void writeEncryptedCSV(String inputFile, String outputFile) throws Exception {

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw = new FileWriter(outputFile)
        ) {

            String header = br.readLine();
            fw.write(header + "\n");

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                // Encrypt sensitive fields
                String encryptedEmail = encrypt(data[2]);
                String encryptedSalary = encrypt(data[3]);

                fw.write(
                        data[0] + "," +
                        data[1] + "," +
                        encryptedEmail + "," +
                        encryptedSalary + "\n"
                );
            }

            System.out.println("✅ Encrypted CSV written successfully!");
        }
    }

    // ---------------- READ & DECRYPT CSV ----------------
    public static void readAndDecryptCSV(String filePath) throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String header = br.readLine();
            System.out.println(header);

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String decryptedEmail = decrypt(data[2]);
                String decryptedSalary = decrypt(data[3]);

                System.out.println(
                        data[0] + "," +
                        data[1] + "," +
                        decryptedEmail + "," +
                        decryptedSalary
                );
            }
        }
    }

    // ---------------- AES ENCRYPT ----------------
    private static String encrypt(String value) throws Exception {

        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(value.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);
    }

    // ---------------- AES DECRYPT ----------------
    private static String decrypt(String encrypted) throws Exception {

        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encrypted);

        return new String(cipher.doFinal(decoded));
    }
}


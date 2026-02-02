package collections_practice.gcr_codebase.csv_data_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LargeCSVChunkReader {

    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\collections_practice\\gcr_codebase\\csv_data_handling\\large_students.csv"; // 500MB+ CSV
        long totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean isHeader = true;
            List<String> chunk = new ArrayList<>(CHUNK_SIZE);

            while ((line = br.readLine()) != null) {

                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                chunk.add(line);

                // When chunk reaches 100 lines → process
                if (chunk.size() == CHUNK_SIZE) {
                    processChunk(chunk);
                    totalProcessed += chunk.size();
                    chunk.clear();

                    System.out.println("Records processed so far: " + totalProcessed);
                }
            }

            // Process remaining lines (less than 100)
            if (!chunk.isEmpty()) {
                processChunk(chunk);
                totalProcessed += chunk.size();
                System.out.println("Records processed so far: " + totalProcessed);
            }

            System.out.println("✅ Total records processed: " + totalProcessed);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Simulates processing of each chunk
    private static void processChunk(List<String> chunk) {
        for (String record : chunk) {
            // Example processing (can be validation, DB insert, etc.)
            // String[] data = record.split(",");
        }
    }
}


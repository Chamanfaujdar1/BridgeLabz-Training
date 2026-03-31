package com.example.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileProcessorTest {
	FileProcessor processor = new FileProcessor();
    String testFile = "testfile.txt";

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit";

        processor.writeToFile(testFile, content);
        String result = processor.readFromFile(testFile);

        assertEquals(content, result);
    }
    
    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(testFile, "Sample Data");

        File file = new File(testFile);
        assertTrue(file.exists());
    }

    @Test
    void testReadNonExistingFileThrowsException() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("nonexistent.txt");
        });
    }
}

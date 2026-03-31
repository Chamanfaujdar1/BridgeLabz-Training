package com.example.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {
	DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(db.isConnected());
    }
    
    @Test
    void testConnectionClosed() {
        db.disconnect();
        assertFalse(db.isConnected());
    }
}

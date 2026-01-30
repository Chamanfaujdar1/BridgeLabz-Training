package com.example.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ListManagerTest {
	ListManager manager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);

        assertTrue(list.contains(10));
        assertEquals(1, manager.getSize(list));
    }
    
    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
        manager.removeElement(list, 20);

        assertFalse(list.contains(20));
        assertEquals(2, manager.getSize(list));
    }
    
    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(4, manager.getSize(list));
    }
}

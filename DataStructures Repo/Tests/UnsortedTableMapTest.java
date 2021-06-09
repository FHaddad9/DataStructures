package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import HashMap.UnsortedTableMap;


class UnsortedTableMapTest {
	UnsortedTableMap<Integer, String> map = new UnsortedTableMap<>();
	UnsortedTableMap<String, Integer> str = new UnsortedTableMap<>();

	@Test
    void testGet() {
        for (int i = 0; i < 5; ++i) {
            str.put(Integer.toString(i), i);
        }
        
        assertEquals(4, str.get("4"));
    }

	@Test
    void testSize() {
        for (int i = 0; i < 5; ++i) {
            map.put(i, Integer.toString(i));
        }
        
        assertEquals(5, map.size());
    }

    @Test
    void testRemove() {
        for (int i = 0; i < 5; ++i) {
            str.put(Integer.toString(i), i);
        }
        
        assertEquals(0, str.remove("0"));
        assertEquals(4, str.size());
    }

    @Test
    void testPut() {
        for (int i = 0; i < 5; ++i) {
            str.put(Integer.toString(i), i);
        }
        
        assertEquals(5, str.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(str.isEmpty());
        
        for (int i = 0; i < 5; ++i) {
            str.put(Integer.toString(i), i);
        }
        
        assertFalse(str.isEmpty());
    }

    @Test
    void testKeySet() {
        ArrayList<String> al = new ArrayList<>();
        
        str.put("one", 1);
        str.put("two", 2);
        str.put("three", 3);
        
        for (String s : str.keySet()) {
        	al.add(s);
        }
        
        al.sort(String::compareTo);
        
        assertEquals("[one, three, two]", al.toString());
    }
}

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lists.CircularlyLinkedList;

class CircularlyLinkedListTest {
	CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();

	@Test
    void testSize() {
        ll.addFirst(0);
        assertEquals(1, ll.size());
    }
	
	@Test
    void testIsEmpty() {
        assertTrue(ll.isEmpty());
        ll.addFirst(0);
        assertFalse(ll.isEmpty());
    }
	
	@Test
	void testGet() {
		ll.addFirst(1);
		ll.addLast(2);
		ll.addLast(3);
		assertEquals(1, ll.get(0));
	}
	
	@Test
    void testAdd() {
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
        ll.add(3, 40);
        assertEquals("[1, 2, 3, 40, 4]", ll.toString());
    }
	
	@Test
    void testFirst() {
        ll.addFirst(1);
        assertEquals(1, ll.first());
        ll.addFirst(4);
        assertEquals(4, ll.first());
    }

    @Test
    void testLast() {
        ll.addFirst(1);
        ll.addFirst(2);
        assertEquals(1, ll.last());
        ll.addLast(3);
        assertEquals(3, ll.last());
    }
	
	@Test
	void testAddFirst() {
		ll.addFirst(1);
		assertEquals("[1]", ll.toString());
		ll.addFirst(2);
		assertEquals("[2, 1]", ll.toString());
	}
	
	@Test
	void testAddLast() {
		ll.addLast(1);
		assertEquals("[1]", ll.toString());
		ll.addLast(2);
		assertEquals("[1, 2]", ll.toString());
	}

}

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lists.DoublyLinkedList;

class LinkedDequeTest {
	DoublyLinkedList<Integer> deque = new DoublyLinkedList<>();
	DoublyLinkedList<String> str = new DoublyLinkedList<>();

	@Test
    void testAddFirst() {
        deque.addFirst(2);
        assertEquals("[2]", deque.toString());
        deque.addFirst(53);
        assertEquals("[53, 2]", deque.toString());
    }

    @Test
    void testAddLast() {
        str.addLast("A");
        assertEquals("[A]", str.toString());
        str.addLast("B");
        assertEquals("[A, B]", str.toString());
    }

    @Test
    void testFirst() {
        assertNull(deque.first());
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        assertEquals(1, deque.first());
        deque.addFirst(4);
        assertEquals(4, deque.first());
    }

    @Test
    void testLast() {
        assertNull(deque.last());
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(1, deque.last());
        deque.addLast(4);
        assertEquals(4, deque.last());
    }

    @Test
    void testRemoveFirst() {
        str.addFirst("A");
        str.addFirst("B");
        str.removeFirst();
        assertEquals("[A]", str.toString());
        deque.removeFirst();
        assertEquals("[]", deque.toString());
    }

    @Test
    void testRemoveLast() {
        str.addFirst("A");
        str.addFirst("B");
        str.addFirst("C");
        str.removeLast();
        assertEquals("[C, B]", str.toString());
        str.removeLast();
        assertEquals("[C]", str.toString());
    }
}

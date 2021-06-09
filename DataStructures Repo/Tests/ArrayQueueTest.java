package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Queues.ArrayQueue;

class ArrayQueueTest {
	ArrayQueue<Integer> s = new ArrayQueue<>();

	@Test
    void testSizeAndIsEmpty() {
        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
    }
	
	@Test
    void testFirst() {
        s.enqueue(211);
        s.enqueue(-736);
        s.enqueue(0);
        assertEquals(211, s.first());
    }
	
	@Test
    void testEnqueue() {
        s.enqueue(1);
        assertEquals("[1]", s.toString());
        s.enqueue(2);
        assertEquals("[1, 2]", s.toString());
    }
	
	@Test
    void testDequeue() {
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        s.enqueue(4);
        assertEquals("[1, 2, 3, 4]", s.toString());
        s.dequeue();
        assertEquals("[2, 3, 4]", s.toString());
        s.dequeue();
        assertEquals("[3, 4]", s.toString());
    }
}

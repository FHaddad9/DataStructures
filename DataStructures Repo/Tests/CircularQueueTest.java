package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Queues.CircularQueue;

class CircularQueueTest {
	CircularQueue<Integer> q = new CircularQueue<>();
	CircularQueue<String> ql = new CircularQueue<>();

	@Test
    void testEnqueue() {
        q.enqueue(1);
        assertEquals("[1]", q.toString());
        q.enqueue(2);
        assertEquals("[1, 2]", q.toString());
    }
	
	@Test
    void testDequeue() {
        q.enqueue(24);
        q.enqueue(53);
        q.enqueue(87);
        assertEquals("[24, 53, 87]", q.toString());
        q.dequeue();
        assertEquals("[53, 87]", q.toString());
        q.dequeue();
        assertEquals("[87]", q.toString());
    }
	
	@Test
    void testFirst() {
        ql.enqueue("C");
        ql.enqueue("A");
        ql.enqueue("T");
        assertEquals("C", ql.first());
        ql.dequeue();
        assertEquals("A", ql.first());
    }
}

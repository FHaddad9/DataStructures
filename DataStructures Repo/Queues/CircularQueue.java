package Queues;

import Interfaces.Queue;
import lists.CircularlyLinkedList;

/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 */

public class CircularQueue<E> implements Queue<E>{
	// Storage for elements of queue
    private final CircularlyLinkedList<E> queue = new CircularlyLinkedList<>();
	
    // Returns number of elements
	@Override
	public int size() {
		return queue.size();
	}

	// Checks if Queue is empty
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	// Inserts element at back of queue
	@Override
	public void enqueue(E e) {
		queue.addLast(e);
	}

	// Returns first element
	@Override
	public E first() {
		return queue.get(0);
	}

	// Removes last element
	@Override
	public E dequeue() {
		return queue.removeFirst();
	}
	
	/**
     * Gets the String representation of the Queue
     *
     * @return the Queue as a String
     */
    @Override
    public String toString() {
        return queue.toString();
    }
	
}

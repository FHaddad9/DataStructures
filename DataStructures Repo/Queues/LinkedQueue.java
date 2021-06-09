package Queues;

import Interfaces.Queue;
import lists.DoublyLinkedList;

public class LinkedQueue<E> implements Queue<E> {
	// Storage for elements of queue
	private final DoublyLinkedList<E> queue = new DoublyLinkedList<>();
	 
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

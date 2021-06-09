package Deques;

import Interfaces.Deque;
import lists.DoublyLinkedList;

public class LinkedDeque<E> implements Deque<E> {
    private final DoublyLinkedList<E> deque = new DoublyLinkedList<>();
	
    // Returns number of elements contained
	@Override
	public int size() {
		return deque.size();
	}

	// Checks if deque is empty
	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	// Returns first element
	@Override
	public E first() {
		return deque.first();
	}

	// Returns last element
	@Override
	public E last() {
		return deque.last();
	}

	// Inserts element to front
	@Override
	public void addFirst(E e) {
		deque.addFirst(e);		
	}
	
	// Inserts element to end
	@Override
	public void addLast(E e) {
		deque.addLast(e);
	}

	// Removes first element
	@Override
	public E removeFirst() {
		return deque.removeFirst();
	}

	// Removes last element
	@Override
	public E removeLast() {
		return deque.removeLast();
	}
	
	@Override
    public String toString() {
        return deque.toString();
    }	
}

package Interfaces;

public interface Queue<E> {
	
	// Returns number of elements
	int size();
	
	// Checks if Queue is empty
	boolean isEmpty();
	
	// Inserts element at back of queue
	void enqueue(E e);
	
	// Returns first element
	E first();
	
	// Removes last element
	E dequeue();
}

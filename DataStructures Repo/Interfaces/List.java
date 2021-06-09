package Interfaces;

public interface List<E> {
	// Returns number of elements in list
	int size();
	
	// Checks if list is empty
	boolean isEmpty();
	
	// Returns element with index i
	E get(int i);
	
	// Replaces element at index i with e
	void set(int i, E e);
	
	// Inserts element e at index i
	void add(int i, E e);
	
	// adds element to start of list
	void addFirst(E e);
	
	// adds element to end of list
	void addLast(E e);
	
	// Removes element at index i
	E remove(int i);
	
	// Removes first element
	E removeFirst();
	
	// Removes last element
	E removeLast();
}

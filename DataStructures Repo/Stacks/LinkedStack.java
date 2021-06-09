package Stacks;

import Interfaces.Stack;
import lists.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {
	// Storage for elements of the stack
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	// Returns elements of stack
	@Override
	public int size() {
		return list.size();
	}

	// Checks if stack contains no elements
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// Inserts element at top of stack
	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	// Returns top element of stack
	@Override
	public E top() {
		return list.first();
	}

	// Removes first element of stack
	@Override
	public E pop() {
		return list.removeFirst();
	}
	
	@Override
    public String toString() {
        return list.toString();
    }

}

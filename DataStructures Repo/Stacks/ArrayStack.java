package Stacks;

import Interfaces.Stack;

public class ArrayStack<E> implements Stack<E> {
	private final int capacity;
	private final E[] stack;
	private int top;
	
	// Constructor
    @SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
        top = -1;
        this.capacity = capacity;
    }
	
    // Capacity of 1000
	ArrayStack() {
        this(1000);
    }
	
	public static void main(String[] args) {
		Stack<Integer> stk = new ArrayStack<>();
		
		System.out.println("isEmpty()? " + stk.isEmpty());
				
		stk.push(1);
		System.out.print("\nPush ");
		System.out.println("Stack: " + stk);
		System.out.println("isEmpty()? " + stk.isEmpty());
		
		stk.push(2);
		System.out.print("\nPush ");
		System.out.println("Stack: " + stk);
		
		stk.push(3);
		System.out.print("\nPush ");
		System.out.println("Stack: " + stk);
		
		System.out.println("\nTop: " + stk.top());
		System.out.println("Size: " + stk.size());
		System.out.println("isEmpty()? " + stk.isEmpty());
		
		stk.pop();
		System.out.println("\nPop: " + stk);
		
		stk.pop();
		System.out.println("\nPop: " + stk);
		

		System.out.println("\nTop: " + stk.top());
		System.out.println("Size: " + stk.size());
		System.out.println("isEmpty()? " + stk.isEmpty());
	}
	
	// Returns size of stack
	@Override
	public int size() {
		return top + 1;
	}

	// Checks if stack is empty
	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	// Insert element to top
	@Override
	public void push(E e) throws IllegalStateException{
		if(size() == capacity) {
			throw new IllegalStateException("Stack is full");
		} else {
			stack[++top] = e;
		}
	}

	// Returns top element
	@Override
	public E top() {
		if(isEmpty()) {
			return null;
		} else {
			return stack[top];
		}
	}

	// Removes top element
	@Override
	public E pop() {
		if(isEmpty()) {
			return null;
		} else {
			return stack[top--];
		}
	}
	
	@Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(stack[i]).append(", ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }
}

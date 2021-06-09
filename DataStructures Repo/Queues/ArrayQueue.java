package Queues;

import Interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {
	// instance variables
    private final E[] queue;
    private final int capacity;
    private int front;
    private int size;
    
    // constructor
    @SuppressWarnings("unchecked")
	ArrayQueue(int capacity){
        front = size = 0;
        queue = (E[]) new Object[capacity];
        this.capacity = capacity;
    }
    
    // returns size
    @Override
    public int size() {
    	return size;
    }
    
    // capacity of 1000
    public ArrayQueue() {
    	this(1000);
    }
    
    // Returns first element of queue
    @Override
    public E first() {
    	if(isEmpty()) {
    		return null;
    	} else {
    		return queue[front];
    	}
    }

    // Checks if queue is empty
    @Override
    public boolean isEmpty() {
    	return size == 0;
    }
    
    // Removes last element of queue
    @Override
    public E dequeue() {
    	if(isEmpty()) {
    		return null;
    	}
    	
    	E delete = queue[front];
    	queue[front] = null;
    	front = (front + 1) % queue.length;
    	size--;
    	return delete;
    }

    // inserts element to rear
	@Override
	public void enqueue(E e) throws IllegalStateException{
		if(capacity == size) {
			throw new IllegalStateException("Queue is full");
		} else {
			int rear = (front + size++) % capacity;
            queue[rear] = e;
		}
	}
	
	/**
     * Gets String representation of Queue.
     *
     * @return String representation of Queue
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = front; i < front + size; i++) {
            sb.append(queue[i % capacity]).append(", ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }
}

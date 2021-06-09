package lists;

import java.util.Iterator;

import Interfaces.List;

public class CircularlyLinkedList<E> implements List<E>, Iterable<E> {
	//---------------- nested Node class ----------------
    /**
     * Singly linked node, which stores a reference to its element and
     * to the subsequent node in the list.
     */
    private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E e, Node <E> n) {
			element = e;
			next = n;
		}
		
		// Accesses element
		public E getElement() {
			return element;
		}
		
		// Accesses next node
		public Node<E> getNext(){
			return next;
		}
		
		// Mutator sets next node
		public void setNext(Node<E> n) {
			next = n;
		}
    } //----------- end of nested Node class -----------

    // instance variables of the CircularlyLinkedList
    /** The designated cursor of the list */
    private Node<E> tail = null;                  // we store tail (but not head)

    /** Number of nodes in the list */
    private int size = 0;                         // number of nodes in the list

    /** Constructs an initially empty list. */
    public CircularlyLinkedList() { }             // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() {
    	return size; 
    }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
    	return size == 0; 
    }

    /**
     * Gets element from list
     *
     * @param i the index of element to get
     */
    @Override
    public E get(int i) {
    	Iterator<E> iter = iterator();
		E element = null;
		int index = 0;
		
		if(isEmpty() || i < 0) {
			return null;
		}
		
		while (iter.hasNext()) {
			if(index == i) {
				element = iter.next();
				break;
			}
			iter.next();
			index++;
		}
		return element;
    }

    /**
     * Replaces element at specified index
     *
     * @param e the element to replace
     * @param i the index of element to replace
     */
    @Override
    public void set(int i, E e) throws IndexOutOfBoundsException {
    	if(isEmpty() || i < 0 || i >= size) {
			throw new IllegalArgumentException("Specified index is out of bounds!");
		} else {
            Node<E> temp = tail.getNext();
			for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i - 1) {
                    e = temp.getNext().getElement();
                }
            }
		}
    }

    /**
     * Adds an element to the specified index of the list
     *
     * @param e the new element to add
     * @param i the index to insert the selected element
     */
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
    	if (i < 0 || i > size) {
            throw new IllegalArgumentException("Specified index is out of bounds!");
        } else if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            Node<E> newest = new Node<>(e, null); 
            Node<E> temp = tail.getNext(); 
            for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i - 1) {
                    newest.setNext(temp.getNext());
                    temp.setNext(newest);
                    break;
                }
            }
            size++;
        }
    }

    /**
     * Removes element at specified index
     *
     * @param i the index of element to be removed
     */
    @Override
    public E remove(int i) {
    	if(isEmpty() || i < 0 || i >= size) {
			return null;
		} else if(i == 0) {
			return removeFirst();
		} else {
			E removed = null;
            Node<E> temp = tail.getNext();
            for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i - 1) {
                    removed = temp.getNext().getElement();
                    temp.setNext(temp.getNext().getNext());
                    size--;
                    break;
                }
            }
            return removed;
		}
    }
    
	private class ListIterator implements Iterator<E> {
        Node<E> temp = tail;
        int index = 0;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            E ans = temp.getNext().getElement();
            temp = temp.getNext();
            index++;
            return ans;
        }
	}
	
    
    //Check these two
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    
    

    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
		if(isEmpty()) {
			return null;
		}
		
		return tail.getNext().getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
    	if(isEmpty()) {
			return null;
		}
    	
    	Node<E> temp = tail.getNext();
    	
        while (temp != tail) {
            temp = temp.getNext();
        }
        
		return tail.getElement();
    }

    // update methods
    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
    	if(tail != null) {
			tail = tail.getNext();
		}
    }

    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
    	if(isEmpty()) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		} else {
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
    	
		size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
    	addFirst(e);
		rotate();
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
    	if(isEmpty()) {
			return null;
		}
    	
		Node<E> head = tail.getNext();
		
		if(head == tail) {
			tail = null;
		} else {
			tail.setNext(head.getNext());
		}
		
		size--;
		
		return head.getElement();
    }
    
    /**
     * Remove the last element from the list.
     *
     * @return the removed last element
     */
    @Override
	public E removeLast() {
    	if (isEmpty()) {
			return null;
	    } else if (size == 1) {
	        return removeFirst();
	    } else {
        E removed = null;
        Node<E> temp = tail.getNext();
        while (temp != null) {
            if (temp.getNext().getNext() == tail) {
                removed = tail.getNext().getElement(); 
                temp.setNext(tail.getNext()); 
                size--;
                break;
		        }
		        temp = temp.getNext();
        	}
        	return removed;
	    }
	}
    
    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    // This is not mine
    public String toString() {
    	if(isEmpty()) {
        	return "";
        }
        
        StringBuilder sb = new StringBuilder("[");
        
        for (E e : this) {
            sb.append(e.toString()).append(", ");
        }
        
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        
        return sb.toString();
    }


    public static void main(String [] args) {
        //ArrayList<String> all;
        //LinkedList<String> ll;
        CircularlyLinkedList<String> ll = new CircularlyLinkedList<>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            ll.addFirst(s);
            ll.addLast(s);
        }
        System.out.println(ll.toString());

        ll.rotate();
        ll.rotate();

        for (String s : ll ) {
            System.out.print(s + ", ");
        }

    }
}
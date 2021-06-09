package lists;

import java.util.Iterator;

import Interfaces.List;

/**
 * A basic singly linked list implementation.
 */
public class SinglyLinkedList<E> implements List<E>, Iterable<E>{
	private Node<E> head = null;
	private int size = 0;
    
    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	public SinglyLinkedList() {
    }              // constructs an initially empty list
    // access methods
    
    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
	@Override
	public int size() {
		return size;
	}
	
	/**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
	@Override
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
     * Adds an element to the specified index of the list
     *
     * @param e the new element to add
     * @param i the index to insert the selected element
     */
	@Override
	public void add(int i, E e) throws IllegalArgumentException {
		if (i < 0 || i > size) {
            throw new IllegalArgumentException("Index is out of bounds!");
        } else if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            Node<E> newest = new Node<>(e, null); 
            Node<E> temp = head; 
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
     * Replaces element at specified index
     *
     * @param e the element to replace
     * @param i the index of element to replace
     */
	@Override
	public void set(int i, E e) throws IllegalArgumentException{
		if(isEmpty() || i < 0 || i >= size) {
			throw new IllegalArgumentException("Specified index is out of bounds!");
		} else {
            Node<E> temp = head;
			for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i - 1) {
                    e = temp.getNext().getElement();
                }
            }
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
            Node<E> temp = head;
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
		
    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if(isEmpty()) {
        	return null;
        } else {
        	return head.getElement();
        }
    }

	/**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
    	if (isEmpty()) {
            return null;
        } else {
            Node<E> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            return temp.getElement();
        }
    }
	
	/**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
	@Override
	public void addFirst(E e) {
		head = new Node<E>(e, head);
		size++;	
	}

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
	@Override
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null);
		Node<E> last = head;
		
		if(last == null) {
			head = newest;
		} else {
			while(last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(newest);
		}
		size++;
	}

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
	@Override
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		} else {
			E remove = head.getElement();
			head = head.getNext();
			size--;
			return remove;
		}
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
        Node<E> temp = head;
        while (temp != null) {
            if (temp.getNext().getNext() == null) {
                removed = temp.getNext().getElement(); 
                temp.setNext(null); 
                size--;
                break;
		        }
		        temp = temp.getNext();
        	}
        	return removed;
	    }
	}
	
	private class SinglyLinkedListIterator implements Iterator<E> {
		Node<E> curr = head;

		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public E next() {
			E res = (E) curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}
	
	public Iterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }
	
	/**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
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
	
	public static void main(String[] args) {
        //ArrayList<String> all;
        //LinkedList<String> ll;
        
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        System.out.println(sll.toString());

        for (String s : sll) {
            System.out.print(s + ", ");
        }
    }
}

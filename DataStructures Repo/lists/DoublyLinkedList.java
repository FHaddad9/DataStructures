package lists;

import Interfaces.List;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E>, Iterable<E> {

    //---------------- nested Node class ----------------
    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    private static class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> previous;
		
		public Node(E e, Node <E> n, Node <E> p) {
			element = e;
			next = n;
			previous = p;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public Node<E> getPrevious(){
			return previous;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
		
		public void setPrevious(Node<E> p) {
			previous = p;
		}
    } //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    private Node<E> header;                    // header sentinel

    /** Sentinel node at the end of the list */
    private Node<E> trailer;                   // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
    	header = new Node<>(null, null, null);
		trailer = new Node<>(null, null, header);
		header.setNext(trailer);
    }

    // public accessor methods
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
    public E get(int i) throws IndexOutOfBoundsException {
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
            Node<E> temp = header;
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
    public void add(int i, E e) throws RuntimeException {
    	if (i < 0 || i > size) {
            throw new RuntimeException("Specified index is out of bounds!");
        } else if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            Node<E> temp = header.getNext();
            for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i) {
                    addBetween(e, temp.getPrevious(), temp);
                    break;
                }
            }
        }
    }

    /**
     * Removes the given node from the list and returns its element.
     * @param node    the node to be removed (must not be a sentinel)
     */
    @Override
    public E remove(int i){
    	if(isEmpty() || i < 0 || i >= size) {
			return null;
		} else if(i == 0) {
			return removeFirst();
		} else {
			E removed = null;
            Node<E> temp = header.getNext();
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
        Node<E> node = header.getNext();
        int i = 0;

        @Override
        public boolean hasNext() {
            return node != trailer;
        }

        @Override
        public E next() {
            E answer = node.getElement();
            node = node.getNext();
            i++;
            return answer;
        }
    }
    
    @Override
	public Iterator<E> iterator() {
        return new ListIterator();
    }

    /**
     * Returns (but does not remove) the first element of the list.
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
    	if(isEmpty()) {
			return null;
		}
    	
		return header.getNext().getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
    	if(isEmpty()) {
			return null;
		}
    	
		return trailer.getPrevious().getElement();
    }

    // public update methods
    /**
     * Adds an element to the front of the list.
     * @param e   the new element to add
     */
    @Override
    public void addFirst(E e) {
    	addBetween(e, header, header.getNext());
    }

    /**
     * Adds an element to the end of the list.
     * @param e   the new element to add
     */
    @Override
    public void addLast(E e) {
    	addBetween(e, trailer.getPrevious(), trailer);
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    @Override
    public E removeFirst() {
    	if(isEmpty()) {
			return null;
		}
    	
		return remove(header.getNext());
    }

    /**
     * Removes and returns the last element of the list.
     * @return the removed element (or null if empty)
     */
    @Override
    public E removeLast() {
    	if(isEmpty()) {
			return null;
		}
    	
		return remove(trailer.getPrevious());
    }

    // private update methods
    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor   node just before the location where the new element is inserted
     * @param successor     node just after the location where the new element is inserted
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
    	Node<E> newest = new Node<>(e, successor, predecessor);
    	
		predecessor.setNext(newest);
		successor.setPrevious(newest);
		
		size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     * @param node    the node to be removed (must not be a sentinel)
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrevious();
        Node<E> successor = node.getNext();
        
        predecessor.setNext(successor);
        successor.setPrevious(predecessor);
        
        size--;
        return node.getElement();
    }


    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
    	if(isEmpty()) {
        	return "[]";
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
        DoublyLinkedList<String> ll = new DoublyLinkedList<String>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            ll.addFirst(s);
            ll.addLast(s);
        }
        System.out.println(ll.toString());

        for (String s : ll) {
            System.out.print(s + ", ");
        }
    }
}

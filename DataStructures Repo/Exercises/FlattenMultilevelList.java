package assignment1;

public class FlattenMultilevelList<E> extends MultiLevelList<E>{
	// Pseudo-Code for flattening multilevel list
	public void flatten(Node<E> head) {
		Node<E> temp = null;
        Node<E> tail = head;
        Node<E> index = head;
		
		// Base case
        if (head == null) {
            return;
        }
        
        // Finding the tail of the list
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        
        // Flattening process
        while (index != tail) {
            // If node has child, it's flattened
            if (index.getChild() != null) {
                tail.setNext(index.getChild());
                
                // Put tail to the new last node
                temp = index.getChild();
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                tail = temp;
            }
            index = index.getNext();
        }
    }
}

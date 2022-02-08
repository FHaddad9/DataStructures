package assignment2;

public class RecursiveMirror<E> extends LinkedBinaryTree<E> {
	// Recursive function to mirror tree
	public Node<E> mirror(Node<E> node){
		// Base case
		if(node == null) {
			return null;
		} else {
			// Setting up the right and left nodes, and also a temporary node
			Node<E> left = mirror(node.left());
			Node<E> right = mirror(node.right());
			Node<E> temp = node.getLeft();
			
			// Swapping the nodes
			node.left = node.right;
			node.right = temp;
			
			return node;
		}
	}
}

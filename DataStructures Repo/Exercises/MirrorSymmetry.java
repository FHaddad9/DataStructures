package assignment2;

public class MirrorSymmetry<E> extends LinkedBinaryTree<E> {
	// Recursive function to check if tree is a mirror
	private boolean checkMirror(Node<E> node1, Node<E> node2) {
		// If both nodes are empty return true
		if(node1 == null && node2 == null) {
			return true;
			
			// If one node is empty and the other isn't, return false
		} else if(node1 == null || node2 == null) {
			return false;
			
			// Recursion to check other nodes
		} else {
			return checkMirror(node1.left, node2.right)
					&& checkMirror(node1.right, node2.left);
		}
	}
	
	public boolean isMirror(Node<E> node) {
		return checkMirror(node, node);
	}
}

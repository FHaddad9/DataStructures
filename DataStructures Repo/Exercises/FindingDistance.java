package assignment2;

public class FindingDistance<E> extends LinkedBinaryTree<E> {
	// Finds lowest common ancestor
	private Node<E> lca(Node<E> curr, int node1, int node2){
		// Returns node if equal to null, node1 or node2
		if(curr == null || curr == node1 || curr == node2) {
			return curr;
		}
		
		// Goes through left and right subtrees
		Node<E> left = lca(curr.left, node1, node2);
		Node<E> right = lca(curr.right, node1, node2);
		
		// Return curr if nodes have only one node as left or right child
		if(left != null && right != null) {
			return curr;
		} 
		
		// Returns left if both nodes are in left subtree
		if(left != null) {
			return left;
		} 
		
		// Returns right if both nodes are in right subtree
		if(right != null){
			return right;
		}
		
		return null;
	}
	
	// Finds distance between node and lowest common ancestor
	private int getDistance(Node<E> curr, int node) {
		int result = 0;
		
		// Result increments after each number of nodes between them
		if(curr != null) {
			if(curr.getElement() == node || result = getDistance(curr.right, node)) > 0
				|| result = getDistance(curr.left, node)) > 0){
					return result++;
				}
			
			return 0;
		}
		
		return 0;
	}
	
	// Finds the distance between two given nodes
	public int findDistance(int node1, int node2) {
		// Gets lowest common ancestor
		Node<E> ancestor = lca(root(), node1, node2);
		
		// Calculates distance of both nodes from its root
		int dist1 = getDistance(ancestor, node1);
		int dist2 = getDistance(ancestor, node2);
		int finalDistance = dist1 + dist2;
		
		return finalDistance;
	}
}

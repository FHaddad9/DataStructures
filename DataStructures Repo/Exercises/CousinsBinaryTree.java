package assignment1;

import Trees.LinkedBinaryTree;

public class CousinsBinaryTree<E> extends LinkedBinaryTree<E> {
	// Checks if nodes are siblings
	public boolean isSibling(Node<E> node, Node<E> a, Node<E> b) {
		if(node == null) {
			return false;
		}		
		
		return ((node.getLeft() == a && node.getRight() == b) ||
				(node.getLeft() == b && node.getRight() == a) ||
				isSibling(node.getLeft(), a, b) ||
				isSibling(node.getRight(), a, b));
	}
	
	// Checks if nodes are at the same level
	public int getLevel(Node<E> node, Node<E> num, int level) {		
		if(node == null) {
			return 0;
		}
		
		if(node == num) {
			return level;
		}
		
		int retLevel = getLevel(node.getLeft(), num, level + 1);
		if(retLevel != 0) {
			return retLevel;
		}
		
		return getLevel(node.getRight(), num, level + 1);
	}

	// Finally checks if two nodes are cousins
	public boolean checkCousins(Node<E> node, Node<E> a, Node<E> b) {
		return (getLevel(node, a, 1) == getLevel(node, b, 1)) && !isSibling(node, a, b);
	}
}

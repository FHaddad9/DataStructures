package assignment1;

import Trees.LinkedBinaryTree;

public class FlattenBinaryTree<E> extends LinkedBinaryTree<E> {
	// Flatten binary tree to linked list pseudo-code
	public void flatten(Node<E> root) {
		// Base case
		if(root == null) {
			return;
		} 
		
		// Checks if left node exists recursively
		if(root.getLeft() != null) {
			flatten(root.getleft());
			
			// Stores in temp
			Node<E> temp = root.getLeft();
			
			// Get the right element
            while (temp.getRight() != null) {
                temp = temp.getRight();
            }
            
            // Store into linked list
            temp.setRight(root.getRight());
            root.setRight(root.getLeft());
            root.setLeft(null);			
		}
	}
}

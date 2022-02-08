package assignment1;

import lists.DoublyLinkedList;

public class NumberListAddition extends DoublyLinkedList<Integer>{
	// Pseudo-code for performing addition on 2 numbers using linked lists
	public Node addList(Node<E> num1, Node<E> num2){
		Node<E> result;
		int carry=0;
		
		while(!num1.isEmpty() || !num2.isEmpty()) {
			int sum = 0;
			int dig1 = 0;
			int dig2 = 0;
			
			// Get the last digits
			if (!num1.isEmpty()) {
				dig1 = num1.removeLast();
            }
			
			if (!num2.isEmpty()) {
				dig2 = num2.removeLast();
            }
			
			// Calculate sum and carry
			sum = carry + dig1 + dig2;
			carry = sum / 10;
			result.addFirst(sum % 10);
		}
		
		if(carry != 0) {
			result.addFirst(carry);
		}
		
		return result;
	}
}

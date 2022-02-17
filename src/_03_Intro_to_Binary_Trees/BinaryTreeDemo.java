package _03_Intro_to_Binary_Trees;

import java.util.Stack;

public class BinaryTreeDemo {

    /*
     * A Binary Tree is a data structure that makes use of nodes and references
     * like a LinkedList, but instead of the nodes pointing to a previous node
     * or next node in an unorderd list they each points to two child nodes that
     * are below them in the hierarchy.
     * 
     * Some important properties of BinaryTree are:
     * 
     * -The left node is always a smaller value than its parent and the right
     * node is always a larger value. This is a property you have seen in some
     * form already via Binary Search.
     * 
     * -Empty nodes are null references.
     * 
     * -The parent node at the very top of the tree is called the root.
     * 
     * 1. Read through the BinaryTree and Node classes.
     * 
     * 2. Create a BinaryTree of any type you like.
     * 
     * 3. Try using some BinaryTree methods to insert, search for, delete and
     * print elements.
     * 
     * 4. Save the root into a Node Object and use references to traverse
     * through the BinaryTree and perform an operation on every element(You may
     * choose to do this recursively or iteratively). Then print it out to see
     * if it worked.
     * 
     */

    public static void main(String[] args) {
    	BinaryTree <Integer >tree = new BinaryTree <Integer> ();
    	Stack <Node <Integer>> stack = new Stack <Node <Integer>> ();
    	tree.insert(20);
    	tree.insert(12);
    	tree.insert (20000);
    	tree.insert(2);
    	tree.insert(9765654);
    	tree.insert(38383);
    	tree.insert(22);
    	System.out.println(tree.search(12));
    	System.out.println();
    	tree.printVertical();
    	tree.delete(20);
    	tree.printVertical();
    	Node <Integer> node = tree.getRoot();
    	stack.push(node);
    	while (stack.size() > 0) {
    		node = stack.pop();
    		System.out.print(node.getValue() + ", ");
    		node.setValue(node.getValue()/57);
    		if (node.getLeft() != null) {
    			stack.push(node.getLeft());
    		}
    		if (node.getRight() != null) {
    			stack.push(node.getRight());
    		}
    	}
    	System.out.println();
    	tree.printVertical();
    }

}

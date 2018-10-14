/*package trees;

import java.util.Stack;

public class BST {

	public Node addNode(int data, Node head) {
		Node tempHead = head;
		Node n = Node.newNode(data);
		if (head == null) {
			head = n;
			return head;
		}
		Node prev = null;
		while (head != null) {
			prev = head;
			if (head.data < data) {
				head = head.right;
			} else {
				head = head.left;
			}
		}
		if (prev.data < data) {
			prev.right = n;
		} else {
			prev.left = n;
		}
		return tempHead;
	}

	public static void main(String[] args) {

		BST bst = new BST();
		Node root = null;
		root = bst.addNode(10, root);
		root = bst.addNode(15, root);
		root = bst.addNode(5, root);
		root = bst.addNode(7, root);
		root = bst.addNode(19, root);
		root = bst.addNode(20, root);
		root = bst.addNode(-1, root);
		root = bst.addNode(21, root);
		
		System.out.println("\n Inorder Iterative : ");
		bst.inOrderTraverse(root);
		
		System.out.println("\n Inorder Recursive : ");
		bst.inOrderIterative(root);
		//System.out.println(bst.height(head));

	}

	private void inOrderIterative(Node root) {
		
		Stack<Node> stack=new Stack<>();
		Node temp=root;
		while(!stack.isEmpty()||temp!=null)
		{
			
			if(temp!=null)
			{
				stack.push(temp);
				temp=temp.left;
			}
			else
			{
				temp=stack.pop();
				System.out.print(" "+temp.data);
				temp=temp.right;
			}
		}
		
	}

	private void inOrderTraverse(Node root) {
		if(root==null)
			return;	
		inOrderTraverse(root.left);
		System.out.print(" "+root.data);
		inOrderTraverse(root.right);
	}

}
*/
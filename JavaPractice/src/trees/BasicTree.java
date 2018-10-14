package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BasicTree {

	public static TreeNode root;
	public static int size = 0;
	public static int height = 0;

	static LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			data = x;
		}
	}

	private static TreeNode createTree() {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);

		return root;
	}

	private static boolean insertionBT(int item) {

		Queue<TreeNode> queue = new LinkedList<>();

		if (root == null) {
			root = new TreeNode(item);
			return true;
		}
		TreeNode tempRoot = root;

		queue.add(tempRoot);

		while (!queue.isEmpty()) {
			tempRoot = queue.peek();
			queue.remove();

			if (tempRoot.left == null) {
				tempRoot.left = new TreeNode(item);
				return true;
			} else
				queue.add(tempRoot.left);

			if (tempRoot.right == null) {
				tempRoot.right = new TreeNode(item);
				return true;
			} else
				queue.add(tempRoot.right);
		}
		return true;

	}

	public static void preTraversal() {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			System.out.println("Tree is empty ");
			return;
		}
		TreeNode tempRoot = root;

		stack.push(tempRoot);

		while (!stack.isEmpty()) {

			tempRoot = stack.pop();
			System.out.print(" " + tempRoot.data);

			if (tempRoot.right != null)
				stack.push(tempRoot.right);

			if (tempRoot.left != null)
				stack.push(tempRoot.left);

		}

	}

	public static void inOrderTraversal() {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			System.out.println("Tree is empty ");
			return;
		}
		TreeNode tempRoot = root;

		while (true) {
			if (tempRoot != null) {
				stack.push(tempRoot);
				tempRoot = tempRoot.left;
			} else if (tempRoot == null && !stack.isEmpty()) {
				tempRoot = stack.pop();
				System.out.print(" " + tempRoot.data);
				tempRoot = tempRoot.right;
			} else
				return;

		}

	}

	public static void postOrderTraversal() {
		Stack<TreeNode> S = new Stack<TreeNode>();

		// Check for empty tree
		if (root == null)
			return;
		S.push(root);
		TreeNode prev = null;
		while (!S.isEmpty()) {
			TreeNode current = S.peek();

			/*
			 * go down the tree in search of a leaf an if so process it and pop
			 * stack otherwise move down
			 */
			if (prev == null || prev.left == current || prev.right == current) {
				if (current.left != null)
					S.push(current.left);
				else if (current.right != null)
					S.push(current.right);
				else {
					S.pop();
					System.out.print(" " + current.data);
				}

				/*
				 * go up the tree from left node, if the child is right push it
				 * onto stack otherwise process parent and pop stack
				 */
			} else if (current.left == prev) {
				if (current.right != null)
					S.push(current.right);
				else {
					S.pop();
					System.out.print(" " + current.data);
				}

				/*
				 * go up the tree from right node and after coming back from
				 * right node process parent and pop stack
				 */
			} else if (current.right == prev) {
				S.pop();
				System.out.print(" " + current.data);
			}

			prev = current;
		}

	}

	private static void levelOrderTraversal() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			System.out.println("Tree is empty ");
			return;
		}
		TreeNode tempRoot = root;
		queue.add(tempRoot);
		while (!queue.isEmpty()) {

			tempRoot = queue.peek();
			queue.remove();
			System.out.print(" " + tempRoot.data);
			if (tempRoot.left != null)
				queue.add(tempRoot.left);
			if (tempRoot.right != null)
				queue.add(tempRoot.right);

		}

	}

	public static void main(String[] args) {

		String s = "";

		BasicTree.root = BasicTree.createTree();

		System.out.print("Preorder : ");
		preTraversal();
		System.out.print("\nPreorder  Recursive : ");
		preOrderRecursive(BasicTree.root);
		System.out.print("\nInorder : ");
		inOrderTraversal();
		System.out.print("\nPostOrder : ");
		postOrderTraversal();
		System.out.print("\nLevelOrder : ");
		levelOrderTraversal();
		System.out.println("\nSize of BT :" + size);
		System.out.println("\nHeight of BT :" + height());

		System.out.println("\n Vertical Sum");
		verticalSum(BasicTree.root, 0);
		Set<Integer> keys = result.keySet();
		for (Integer k : keys)
			System.out.println(k + " -- " + result.get(k));

		int arr[] = new int[10];
		int pathLength = 0;
		System.out.println("\n Print all  path");
		printAllRootLeafPath(BasicTree.root, arr, pathLength);

		System.out.println("\n Print Sum Path");
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println(printPathWithSum(BasicTree.root, 7, list));

		for (int i : list)
			System.out.print("->" + i);

		System.out.println("\n Print Ancesestor");
		printAncestors(root, 7);

		System.out.println("\n LCA");
		System.out.println(printLCA(root, new TreeNode(7), new TreeNode(8)).data);

		System.out.println("\n Linked List");
		TreeNode head = BTtoDLL(BasicTree.root);

		while (head != null) {
			System.out.println(" " + head.data);
			head = head.left;
		}

	}

	private static TreeNode BTtoDLL(TreeNode root2) {
		return root2;

	}

	private static TreeNode concatenate(TreeNode n1, TreeNode n2) {

		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;
		n1.right = n2;
		n2.left = n1;
		return n1;

	}

	private static TreeNode printLCA(TreeNode root2, TreeNode node1, TreeNode node2) {
		TreeNode left = null, right = null;
		if (root2 == null)
			return null;

		if ((root2.data == node1.data) || (root2.data == node2.data)) {
			return root2;
		}

		left = printLCA(root2.left, node1, node2);
		right = printLCA(root2.right, node1, node2);
		if (left != null && right != null)
			return root2;
		else
			return left != null ? left : right;

	}

	private static boolean printAncestors(TreeNode root2, int i) {
		if (root2 == null)
			return false;
		if (root2.data == i) {
			System.out.println(" " + root2.data);
			return true;
		}
		if (printAncestors(root2.left, i) || printAncestors(root2.right, i)) {
			System.out.println(" " + root2.data);
			return true;
		}

		return false;

	}

	private static boolean printPathWithSum(TreeNode root2, int sum, LinkedList<Integer> list) {

		if (root2 == null)
			return false;

		if (root2.left == null && root2.right == null) {
			if (sum == root2.data) {
				System.out.println("Path is there");
				list.add(root2.data);

				return true;
			} else
				return false;

		}

		if (printPathWithSum(root2.left, sum - root2.data, list)
				|| printPathWithSum(root2.right, sum - root2.data, list)) {
			list.add(root2.data);
			return true;
		}

		return false;

	}

	private static void printAllRootLeafPath(TreeNode root2, int arr[], int pathLength) {

		if (root2 == null)
			return;
		arr[pathLength] = root2.data;
		pathLength++;
		if (root2.left == null && root2.right == null)
			printArray(arr, pathLength);

		printAllRootLeafPath(root2.left, arr, pathLength);
		printAllRootLeafPath(root2.right, arr, pathLength);

	}

	private static void printArray(int[] arr, int pathLength2) {

		System.out.println("\n");
		for (int i = 0; i < pathLength2; i++)
			System.out.print("->" + arr[i]);
	}

	private static void verticalSum(TreeNode root2, int column) {
		if (root2 == null)
			return;

		if (result.containsKey(column))
			result.put(column, result.get(column) + root2.data);
		else
			result.put(column, root2.data);

		verticalSum(root2.left, column - 1);
		verticalSum(root2.right, column + 1);
	}

	static HashMap<Integer, LinkedList<Integer>> verticalMap = new HashMap<>();

	private static void verticalMap(TreeNode root2, int column) {
		if (root2 == null)
			return;

		if (verticalMap.containsKey(column))
			verticalMap.get(column).add(root.data);
		else {
			LinkedList<Integer> list = new LinkedList<>();
			list.add(root.data);
			verticalMap.put(column, list);
		}

		verticalSum(root2.left, column - 1);
		verticalSum(root2.right, column + 1);
	}

	private static int height() {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			System.out.println("Tree is empty ");
			return -1;
		}
		height = 0;
		TreeNode tempRoot = root;
		queue.add(tempRoot);
		queue.add(null);
		while (!queue.isEmpty()) {

			tempRoot = queue.peek();
			queue.remove();
			if (tempRoot == null) {
				if (!queue.isEmpty()) {
					queue.add(null);
					height++;

				}

			}

			else {
				if (tempRoot.left != null)
					queue.add(tempRoot.left);
				if (tempRoot.right != null)
					queue.add(tempRoot.right);

			}
		}
		return height;

	}

	private static void preOrderRecursive(TreeNode root2) {

		if (root2 == null)
			return;
		size++;
		System.out.print(" " + root2.data);
		preOrderRecursive(root2.left);
		preOrderRecursive(root2.right);

	}

}

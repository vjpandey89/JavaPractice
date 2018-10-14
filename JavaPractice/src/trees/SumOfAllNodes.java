package trees;



public class SumOfAllNodes {

	TreeNode root;

	private int printSumOfAllNodes(TreeNode root) {
		if (root == null)
			return 0;
		return printSumOfAllNodes(root.left) + printSumOfAllNodes(root.right) + root.data;

	}

	static class Result {
		TreeNode node;
		int vaue = Integer.MIN_VALUE;
	}

	private int printMaxSubtree(TreeNode root, Result max) {
		if (root == null)
			return 0;
		int sum = printMaxSubtree(root.left,max) + printMaxSubtree(root.right,max) + root.data;
		if (sum > max.vaue) {
			max.vaue = sum;
			max.node = root;
		}

		return sum;
	}

	public static void main(String[] args) {
		SumOfAllNodes tree = new SumOfAllNodes();
		tree.root = new TreeNode(-1);
		tree.root.left = new TreeNode(-2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(-6);
		tree.root.right.right = new TreeNode(2);

		System.out.println(tree.printSumOfAllNodes(tree.root));

		Result max = new Result();
		tree.printMaxSubtree(tree.root, max);

		System.out.println("Max Subtree sum " + max.vaue + " on node " + max.node.data);

	}
}

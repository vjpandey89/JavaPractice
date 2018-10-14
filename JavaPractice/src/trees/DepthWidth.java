package trees;

public class DepthWidth {

	TreeNode root;

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		int depth = Math.max(depth(root.left), depth(root.right)) + 1;

		return depth;
	}

	public static void main(String[] args) {
		DepthWidth tree = new DepthWidth();
		tree.root = new TreeNode(-1);
		tree.root.left = new TreeNode(-2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(-6);
		tree.root.right.right = new TreeNode(2);

		System.out.println(tree.depth(tree.root));
	}

}

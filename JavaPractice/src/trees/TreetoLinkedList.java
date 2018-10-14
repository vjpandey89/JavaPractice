package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreetoLinkedList {

	TreeNode root;

	public static void main(String[] args) {
		TreetoLinkedList tree = new TreetoLinkedList();
		tree.root = new TreeNode(-1);
		tree.root.left = new TreeNode(-2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(-6);
		tree.root.right.right = new TreeNode(2);

		List<LinkedList<TreeNode>> lists = new ArrayList<>();

		tree.createLinkedListForeachLevel(tree.root, lists);
		for (LinkedList<TreeNode> list : lists) {
			System.out.println("\t");
			for (TreeNode node : list)
				System.out.print(" " + node.data);
		}
		
		lists = tree.createLinkedListForeachLevelBFS(tree.root);
		for (LinkedList<TreeNode> list : lists) {
			System.out.println("\t");
			for (TreeNode node : list)
				System.out.print(" " + node.data);
		}

	}

	private List<LinkedList<TreeNode>> createLinkedListForeachLevelBFS(TreeNode root) {
		if(root==null)
			return null;
		List<LinkedList<TreeNode>> lists = new ArrayList<>();
		LinkedList<TreeNode> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			lists.add(q);
			LinkedList<TreeNode> parent=q;
			q=new LinkedList<TreeNode>();
			for(TreeNode node:parent)
			{
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
				
			}
			
		}
		return lists;
		
	}

	private void createLinkedListForeachLevel(TreeNode root, List<LinkedList<TreeNode>> lists) {
		createLinkedListForeachLevelUtil(root, lists, 0);
	}

	private void createLinkedListForeachLevelUtil(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
		if (root == null)
			return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);

		createLinkedListForeachLevelUtil(root.left, lists, level + 1);
		createLinkedListForeachLevelUtil(root.right, lists, level + 1);

	}

}

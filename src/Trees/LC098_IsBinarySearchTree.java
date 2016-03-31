package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC098_IsBinarySearchTree {

	public static void main(String[] args) {

		LC098_IsBinarySearchTree tree = new LC098_IsBinarySearchTree();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		boolean bst = tree.IsBST(tree.root);
		System.out.println("Is BST : " + bst);
		
	}

	private boolean IsBST(TreeNode rootNode) {		
		
		return IsBSTUtil(rootNode , Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean IsBSTUtil(TreeNode rootNode, int minValue, int maxValue) {

		if(rootNode == null)
		{
			return true;
		}
		
		if(rootNode.data < minValue || rootNode.data > maxValue)
		{
			return false;
		}
		
		return (IsBSTUtil(rootNode.left , minValue, rootNode.data) && IsBSTUtil(rootNode.right , rootNode.data, maxValue));
	}

	TreeNode root;
	
	class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val)
		{
			data = val;
			left = null;
			right = null;			
		}
		
	}
	
	public void constructTree()
	{
		root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(8);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(26);
		root.right.right.left = new TreeNode(23);
	}
	
	private List<List<Integer>> levelOrderTraversal(TreeNode rootNode) {

		List<List<Integer>> levels = new ArrayList<List<Integer>>();
		
		if(rootNode == null)
		{
			return levels;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode);

		
		while(!queue.isEmpty())
		{
			List<Integer> currLevel = new ArrayList<Integer>();			
			int size = queue.size();
			for(int i = 0 ; i < size ; i++)
			{
				TreeNode temp = queue.poll();
				currLevel.add(temp.data);
				
				if(temp.left != null)
				{
					queue.add(temp.left);
				}
				
				if(temp.right != null)
				{
					queue.add(temp.right);
				}
				
			}
			
			levels.add(currLevel);				
		}
		
		return levels;
		
	}	

	
}

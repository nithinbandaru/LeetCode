package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC333_LargestBSTSubTree {

	public static void main(String[] args) {

		LC333_LargestBSTSubTree tree = new LC333_LargestBSTSubTree();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		int size = largestBSTSubTree(tree.root);
		
		System.out.println("Largest BST sub tree : " + size);
		
	}

	private static int largestBSTSubTree(TreeNode rootNode) {

		if(rootNode == null)
		{
			return 0;
		}
		
		if(IsValidBST(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE))
		{
			return count(rootNode);
		}
		
		int leftCount = largestBSTSubTree(rootNode.left);
		int rightCount = largestBSTSubTree(rootNode.right);
		
		return Math.max(leftCount, rightCount);
	}

	private static boolean IsValidBST(TreeNode rootNode, int minValue, int maxValue) {

		if(rootNode == null)
		{
			return true;
		}
		
		if(rootNode.data < minValue || rootNode.data > maxValue)
		{
			return false;
		}
		
		return IsValidBST(rootNode.left, minValue, rootNode.data) && IsValidBST(rootNode.right, rootNode.data, maxValue);
	}

	private static int count(TreeNode rootNode) {

		if(rootNode == null)
		{
			return 0;
		}
		
		return 1 + count(rootNode.left) + count(rootNode.right);
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
		root.right = new TreeNode(15);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);		
		root.right.right = new TreeNode(7);
		
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

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC250_CountUnivalueSubtrees {

	public static void main(String[] args) {

		LC250_CountUnivalueSubtrees tree = new LC250_CountUnivalueSubtrees();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		int count = countUnivalueSubtrees(tree.root);
		System.out.println("Univalue sub trees count : " + count);
	}

	private static int countUnivalueSubtrees(TreeNode rootNode) {

		int[] count = new int[1];
		
		countUtil(rootNode, count);
		
		return count[0];
	}

	private static boolean countUtil(TreeNode rootNode, int[] count) {

		if(rootNode == null)
		{
			return true;
		}
		
		boolean left = countUtil(rootNode.left , count);
		boolean right = countUtil(rootNode.left , count);
		
		if(left && right)
		{
			if(rootNode.left != null && rootNode.data != rootNode.left.data)
			{
				return false;
			}
			
			if(rootNode.right != null && rootNode.data != rootNode.right.data)
			{
				return false;
			}
			
			count[0]++;
			return true;
		}
		
		return false;
		
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
		root = new TreeNode(5);
		
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);		
		root.right.right = new TreeNode(5);
		
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

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC111_MinimumDepthOfTree {

	public static void main(String[] args) {

		LC111_MinimumDepthOfTree tree = new LC111_MinimumDepthOfTree();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
	
		int minDepth = getMinimumDepth(tree.root);
		
		System.out.println(minDepth);
		
	}

	private static int getMinimumDepth(TreeNode rootNode) {

		if(rootNode == null)
		{
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode);
		int depth = 1;
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			
			for(int i = 0 ; i < size ; i++)
			{
				TreeNode temp = queue.poll();
				
				if(temp.left == null && temp.right == null)
				{
					return depth;
				}
				
				if(temp.left != null)
				{
					queue.add(temp.left);
				}
				
				if(temp.right != null)
				{
					queue.add(temp.right);
				}
				
			}
			
			depth++;
		}
		
		return depth;

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
		root = new TreeNode(0);
		
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(9);
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

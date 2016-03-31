package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC236_LCAOfBinaryTrees {

	public static void main(String[] args) {

		LC236_LCAOfBinaryTrees tree = new LC236_LCAOfBinaryTrees();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		TreeNode lca = tree.LCA(tree.root, tree.root.left.left, tree.root.left.right.right);
		System.out.println("LCA : " + lca.data);
		
	}

	private TreeNode LCA(TreeNode rootNode, TreeNode p, TreeNode q) {

		if(rootNode == null)
		{
			return null ;
		}
		
		if(rootNode == p || rootNode == q)
		{
			return rootNode;
		}
		
		TreeNode searchLeft = LCA(rootNode.left , p , q);
		TreeNode searchRight = LCA(rootNode.right, p, q);
		
		if(searchLeft != null && searchRight != null)
		{
			return rootNode;
		}
		
		if(searchLeft == null)
		{
			return searchRight;
		}
		
		return searchLeft;
		
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
		root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);	
		
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);		
		
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

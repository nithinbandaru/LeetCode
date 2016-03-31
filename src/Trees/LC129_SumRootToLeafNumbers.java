package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC129_SumRootToLeafNumbers {

	public static void main(String[] args) {

		LC129_SumRootToLeafNumbers tree = new LC129_SumRootToLeafNumbers();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		int sum = tree.sumRootToLeaf(tree.root);
		System.out.println(sum);
		
	}

	private int sumRootToLeaf(TreeNode rootNode) {

		return sumRootToLeafUtil(rootNode, 0);
	}

	private int sumRootToLeafUtil(TreeNode rootNode, int val) {

		if(rootNode == null)
		{
			return 0;
		}
		
		val = 10 * val + rootNode.data;
		
		if(rootNode.left == null && rootNode.right == null)
		{
			return val;
		}
		
		return sumRootToLeafUtil(rootNode.left, val) + sumRootToLeafUtil(rootNode.right, val);
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
		root = new TreeNode(6);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(5);		
		root.right.right = new TreeNode(4);
		
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
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

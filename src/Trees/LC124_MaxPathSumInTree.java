package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC124_MaxPathSumInTree {

	public static void main(String[] args) {

		LC124_MaxPathSumInTree tree = new LC124_MaxPathSumInTree();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		int maxSum = maxPathSum(tree.root);
		System.out.println(maxSum);
		
	}

	
	private static int maxPathSum(TreeNode rootNode) {

		int[] maxSum = new int[1];
		maxSum[0] = Integer.MIN_VALUE;
		
		calculateSum(rootNode , maxSum);
		
		return maxSum[0];
	}


	/*
	 * For each node there can be four ways that the max path goes through the node:
	 * 1. Node only
	 * 2. Max path through Left Child + Node
	 * 3. Max path through Right Child + Node
	 * 4. Max path through Left Child + Node + Max path through Right Child
	 */
	
	private static int calculateSum(TreeNode rootNode, int[] maxSum) {

		if(rootNode == null)
		{
			return 0;
		}
		
		int leftSum = calculateSum(rootNode.left, maxSum);
		int rightSum = calculateSum(rootNode.right, maxSum);
		
		int currentSum = Math.max(rootNode.data, Math.max(rootNode.data + leftSum, rootNode.data + rightSum)); 
		maxSum[0] = Math.max(maxSum[0], Math.max(currentSum, leftSum + rootNode.data + rightSum));
		
		return currentSum;
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
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(1);	
		
		root.right.right = new TreeNode(-25);
		
		root.right.right.left = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
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

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC298_LongestConsecutiveSequence {

	public static void main(String[] args) {

		LC298_LongestConsecutiveSequence tree = new LC298_LongestConsecutiveSequence();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		int longPath = tree.longestConsecutiveSequence(tree.root);
		System.out.println(longPath);
		
	}

	private int longestConsecutiveSequence(TreeNode rootNode) {

		return (rootNode == null ? 0 : Math.max(lcsUtil(rootNode.left, 1, rootNode.data), lcsUtil(rootNode.right, 1, rootNode.data)));
		
	}

	private int lcsUtil(TreeNode currRoot, int count, int rootValue) {

		if(currRoot == null)
		{
			return count;
		}
		
		count = (currRoot.data - rootValue == 1) ? count + 1 : 1;
		
		int leftCount = lcsUtil(currRoot.left, count, currRoot.data);
		int rightCount = lcsUtil(currRoot.right, count, currRoot.data);
		
		return Math.max(Math.max(leftCount, rightCount), count);
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
		
		root.right = new TreeNode(3);
		
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
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

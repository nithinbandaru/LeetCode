package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC106_BuildTreeFromInOrderPostOrder {

	public static void main(String[] args) {

		LC106_BuildTreeFromInOrderPostOrder tree = new LC106_BuildTreeFromInOrderPostOrder();
		tree.constructTree();
		
		int[] inOrder = { 10 , 30 ,40 ,50 ,60 ,70 ,90};
		int[] postOrder = {10 , 40 , 30, 60, 90, 70, 50};
		
		TreeNode rootNode = tree.buildTree(postOrder , inOrder);
		
		
		List<List<Integer>>levels = tree.levelOrderTraversal(rootNode);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
	}

	private TreeNode buildTree(int[] postOrder, int[] inOrder) {
		
		if(postOrder.length != inOrder.length)
		{
			return null;
		}
		
		return buildUtil(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1);	
		
	}

	private TreeNode buildUtil(int[] postOrder, int postLow, int postHigh,
			int[] inOrder, int inLow, int inHigh) {

		if(postLow > postHigh || inLow > inHigh)
		{
			return null;
		}
		
		TreeNode rootNode = new TreeNode(postOrder[postHigh]);
		
		int inOrderRootIndex = inLow;
		
		for(int i = inLow ; i <= inHigh ; i++)
		{
			if(inOrder[i] == rootNode.data)
			{
				inOrderRootIndex = i;
				break;
			}
		}
		
		
		int leftSubTreeLen = inOrderRootIndex - inLow;
		
		rootNode.left = buildUtil(postOrder, postLow, postLow + leftSubTreeLen - 1, inOrder, inLow, inOrderRootIndex - 1);
		rootNode.right = buildUtil(postOrder, postLow + leftSubTreeLen , postHigh-1, inOrder, inOrderRootIndex + 1, inHigh);
		
		return rootNode;
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
		
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
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

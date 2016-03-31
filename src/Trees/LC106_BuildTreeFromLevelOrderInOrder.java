package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC106_BuildTreeFromLevelOrderInOrder {

	public static void main(String[] args) {

		LC106_BuildTreeFromLevelOrderInOrder tree = new LC106_BuildTreeFromLevelOrderInOrder();
		
		int[] inOrder = {4, 8, 10, 12, 14, 20, 22};

		int[] levelOrder = {20, 8, 22, 4, 12, 10, 14};

		TreeNode rootNode = buildTree(inOrder, levelOrder);
		
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(rootNode);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
	}

	private static TreeNode buildTree(int[] inOrder, int[] levelOrder) {
		
		return buildTreeUtil(inOrder, levelOrder, 0, inOrder.length-1);
	}

	private static TreeNode buildTreeUtil(int[] inOrder, int[] levelOrder, int inStart, int inEnd) {

		if(inStart > inEnd)
		{
			return null;
		}
		
		int rootVal = levelOrder[0];
		TreeNode root = new TreeNode(rootVal);
		
		if(inStart == inEnd)
		{
			return root;
		}
		
		int rootIndex = findIndex(inOrder, rootVal, inStart, inEnd);
		
		int[] leftSubTreeArray = newSubArray(inOrder, levelOrder, inStart, rootIndex - 1);
		int[] rightSubTreeArray = newSubArray(inOrder, levelOrder, rootIndex + 1, inEnd);
		
		root.left = buildTreeUtil(inOrder, leftSubTreeArray, inStart, rootIndex - 1);
		root.right = buildTreeUtil(inOrder, rightSubTreeArray, rootIndex + 1, inEnd);
		
		return root;
	}

	private static int[] newSubArray(int[] inOrder, int[] levelOrder, int inStart, int inEnd) {

		int[] subArray = new int[inEnd - inStart + 1];
		
		int x = 0;
		
		for(int i = 0; i < levelOrder.length; i++)
		{
			if(findIndex(inOrder, levelOrder[i], inStart, inEnd) != -1)
			{
				subArray[x] = levelOrder[i];
				x++;
			}
		}
		
		return subArray;
	}

	private static int findIndex(int[] inOrder, int rootVal, int inStart, int inEnd) {

		for(int i = inStart; i <= inEnd; i++)
		{
			if(rootVal == inOrder[i])
			{
				return i;
			}
		}
		
		return -1;
	}

	TreeNode root;
	
	static class TreeNode
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
		root.left.right = new TreeNode(17);		
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

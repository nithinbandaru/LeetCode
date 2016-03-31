package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC108_ConvertSortedArrayToBST {

	public static void main(String[] args) {

		LC108_ConvertSortedArrayToBST tree = new LC108_ConvertSortedArrayToBST();
		//tree.constructTree();
		
		int[] A = { 1, 2, 3, 4, 5, 6, 7};
		
		TreeNode rootNode = tree.convertToBST(A, 0, A.length-1);		
		
		List<List<Integer>>levels = tree.levelOrderTraversal(rootNode);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
	}

	private TreeNode convertToBST(int[] A, int start, int end) {

		if(start > end)
		{
			return null;
		}
		
		int mid = start + (end - start)/2;
		
		TreeNode rootNode = new TreeNode(A[mid]);
		
		rootNode.left = convertToBST(A, start, mid - 1);
		
		rootNode.right = convertToBST(A, mid + 1, end);
		
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

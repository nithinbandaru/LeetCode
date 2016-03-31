package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class LC144_Traversal_PreOrder {

	public static void main(String[] args) {

		LC144_Traversal_PreOrder tree = new LC144_Traversal_PreOrder();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
	
		List<Integer> preOrder = preOrderTraversal(tree.root);
	
		System.out.println(preOrder);
	}
	
	

	private static List<Integer> preOrderTraversal(TreeNode rootNode) {

		List<Integer> preOrder = new ArrayList<Integer>();
		
		if(rootNode == null)
		{
			return preOrder;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(rootNode);
		
		while(!stack.isEmpty())
		{
			TreeNode curr = stack.pop();
			preOrder.add(curr.data);
			
			if(curr.right != null)
			{
				stack.push(curr.right);
			}
			
			if(curr.left != null)
			{
				stack.push(curr.left);
			}
		}
		
		return preOrder;
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
		root = new TreeNode(4);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);		
		root.right.left = new TreeNode(5);
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

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class LC094_Traversal_InOrder {

	public static void main(String[] args) {

		LC094_Traversal_InOrder tree = new LC094_Traversal_InOrder();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		List<Integer> inOrder = tree.inOrderTraversal(tree.root);
	
		System.out.println("InOrder Traversal : " + inOrder);
	}

	private List<Integer> inOrderTraversal(TreeNode rootNode) {

		List<Integer> inOrder = new ArrayList<Integer>();
		
		if(rootNode == null){
			
			return inOrder;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = rootNode;
		
		while(curr != null || !stack.isEmpty())
		{
			while(curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			inOrder.add(curr.data);
			curr = curr.right;		
			
		}
		
		return inOrder;
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

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class LC145_Traversal_PostOrder {

	public static void main(String[] args) {

		LC145_Traversal_PostOrder tree = new LC145_Traversal_PostOrder();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
	
		List<Integer> postOrder = postOrderTraversal(tree.root);
	
		System.out.println(postOrder);
	}
	
	

	private static List<Integer> postOrderTraversal(TreeNode rootNode) {

		List<Integer> postOrder = new ArrayList<Integer>();
		
		if(rootNode == null)
		{
			return postOrder;
		}
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		stack1.push(rootNode);
		
		while(!stack1.isEmpty())
		{
			TreeNode curr = stack1.pop();
			stack2.push(curr);
			
			if(curr.left != null)
			{
				stack1.push(curr.left);
			}
			
			if(curr.right != null)
			{
				stack1.push(curr.right);
			}			
		}
		
		while(!stack2.isEmpty())
		{
			postOrder.add(stack2.pop().data);
		}
		
		return postOrder;
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

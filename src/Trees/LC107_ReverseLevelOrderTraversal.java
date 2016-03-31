package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class LC107_ReverseLevelOrderTraversal {

	public static void main(String[] args) {

		LC107_ReverseLevelOrderTraversal tree = new LC107_ReverseLevelOrderTraversal();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		ReverseLevelOrderTraversal(tree.root);
		
	}

	private static void ReverseLevelOrderTraversal(TreeNode rootNode) {

		if(rootNode == null)
		{
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		queue.add(rootNode);
		
		while(!queue.isEmpty())
		{
			TreeNode temp = queue.poll();
			
			stack.push(temp);
			
			if(temp.right != null)
			{
				queue.add(temp.right);
			}
			
			if(temp.left != null)
			{
				queue.add(temp.left);
			}
		}
		
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop().data + " ");
		}
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
			
			levels.add(0,currLevel);				
		}
		
		return levels;
		
	}	
}

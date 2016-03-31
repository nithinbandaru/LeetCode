package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class LC114_FlattenABinaryTree {

	public static void main(String[] args) {

		LC114_FlattenABinaryTree tree = new LC114_FlattenABinaryTree();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		TreeNode rootNode = tree.flattenBinaryTree(tree.root);
		
		while(rootNode != null)
		{
			System.out.print(rootNode.data + "->");
			rootNode = rootNode.right;
		}
		
	}

	private TreeNode flattenBinaryTree(TreeNode rootNode) {

		if(rootNode == null)
		{
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(rootNode);
		
		while(!stack.isEmpty())
		{
			TreeNode curr = stack.pop();
			if(curr.right != null)
			{
				stack.push(curr.right);
			}
			
			if(curr.left != null)
			{
				stack.push(curr.left);
			}
			
			if(!stack.isEmpty())
			{
				curr.right = stack.peek();
			}
			
			curr.left = null;
		}		
		
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
		root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);		
		root.right.right = new TreeNode(6);		
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

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC226_MirrorBinaryTree {

	public static void main(String[] args) {

		LC226_MirrorBinaryTree tree = new LC226_MirrorBinaryTree();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		tree.mirrorTree(tree.root);
		
		List<List<Integer>>levelsMirror = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levelsMirror)
		{
			System.out.println(level);
		}
		
		
	}

	private void mirrorTree(TreeNode rootNode) {

		if(rootNode == null)
		{
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode);
		
		while(!queue.isEmpty())
		{
			TreeNode currNode = queue.poll();
			TreeNode temp = currNode.left;
			currNode.left = currNode.right;
			currNode.right = temp;
			
			if(currNode.left != null)
			{
				queue.add(currNode.left);
			}
			
			if(currNode.right != null)
			{
				queue.add(currNode.right);
			}
			
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
		root = new TreeNode(4);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
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

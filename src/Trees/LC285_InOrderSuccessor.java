package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC285_InOrderSuccessor {

	public static void main(String[] args) {

		LC285_InOrderSuccessor tree = new LC285_InOrderSuccessor();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		TreeNode successor = inOrderSuccessor(tree.root, tree.root.right.right);
		System.out.println(successor == null ? null :successor.data);
		
	}

	private static TreeNode inOrderSuccessor(TreeNode rootNode, TreeNode p) {

		TreeNode successor = null;
		
		while(rootNode != null)
		{
			if(rootNode.data > p.data)
			{
				successor = rootNode;
				rootNode = rootNode.left;
			}
			else
			{
				rootNode = rootNode.right;
			}
			
		}
		
		return successor;
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

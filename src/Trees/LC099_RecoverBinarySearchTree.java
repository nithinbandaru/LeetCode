package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC099_RecoverBinarySearchTree {

	TreeNode firstNodeToSwap ;	
	TreeNode lastNodeToSwap;
	TreeNode prevNode;
	
	public static void main(String[] args) {

		LC099_RecoverBinarySearchTree tree = new LC099_RecoverBinarySearchTree();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		tree.RecoverBST(tree.root);
		// After Recovery
		
		List<List<Integer>>levels2 = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels2)
		{
			System.out.println(level);
		}
		
		
	}

	private void RecoverBST(TreeNode rootNode) {

		findSegments(rootNode);		
		
		int temp = firstNodeToSwap.data;		
		firstNodeToSwap.data = lastNodeToSwap.data;		
		lastNodeToSwap.data = temp;		
	}

	// Do Inorder Traversal to find these nodes
	
	private void findSegments(TreeNode rootNode) {

		if(rootNode == null)
		{
			return;
		}
		
		findSegments(rootNode.left);
		
		if(prevNode != null)
		{
			 if(prevNode.data > rootNode.data)
			 {
				 if(firstNodeToSwap == null)
				 {
					 firstNodeToSwap = prevNode;
				 }
				 
				 lastNodeToSwap = rootNode;
			 }
		}
		
		prevNode = rootNode;
		
		findSegments(rootNode.right);
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
		root = new TreeNode(10);
		
		root.left = new TreeNode(15);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);		
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(17);
		
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

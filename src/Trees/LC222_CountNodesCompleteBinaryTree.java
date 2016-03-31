package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC222_CountNodesCompleteBinaryTree {

	public static void main(String[] args) {

		LC222_CountNodesCompleteBinaryTree tree = new LC222_CountNodesCompleteBinaryTree();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		int numOfNodes = countNodes(tree.root);
		System.out.println(numOfNodes);
	}

	private static int countNodes(TreeNode rootNode) {

		int leftDepth = getLeftDepth(rootNode);
		int rightDepth = getRightDepth(rootNode);
		
		if(leftDepth == rightDepth)
		{
			int count = (1 << leftDepth);
			return count - 1;
		}
				
		return 1 + countNodes(rootNode.left) + countNodes(rootNode.right);
	}

	private static int getRightDepth(TreeNode rootNode) {

		int depth = 0;
		
		while(rootNode != null)
		{
			rootNode = rootNode.right;
			depth++;
		}
		
		return depth;
	}
	
	private static int getLeftDepth(TreeNode rootNode) {

		int depth = 0;
		
		while(rootNode != null)
		{
			rootNode = rootNode.left;
			depth++;
		}
		
		return depth;
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
		root.left.right = new TreeNode(21);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		
		root.left.left.left = new TreeNode(7);
		///root.left.left.right = new TreeNode(2);
		//root.right.right.right = new TreeNode(1);
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

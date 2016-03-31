package Trees;

import java.util.LinkedList;
import java.util.Queue;


public class LC100_IdenticalTrees {

	public static void main(String[] args) {

		LC100_IdenticalTrees tree1 = new LC100_IdenticalTrees();
		tree1.constructTree1(tree1.root);
		tree1.levelOrderTraversal(tree1.root);
		
		LC100_IdenticalTrees tree2 = new LC100_IdenticalTrees();
		tree2.constructTree2(tree2.root);
		tree2.levelOrderTraversal(tree2.root);
		
		boolean identical = IsIdentical(tree1.root , tree2.root);
		System.out.println("Are Identical : " + identical);
		
		
	}

	private static boolean IsIdentical(TreeNode root1, TreeNode root2) {

		if(root1 == null && root2 == null)
		{
			return true;
		}
		
		if(root1 == null || root2 == null)
		{
			return false;
		}
		
		if(root1.data == root2.data)
		{
			return ( IsIdentical(root1.left, root2.left) && IsIdentical(root1.right, root2.right));
		}
		
		return false;
		
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
	
	public void constructTree1(TreeNode rootNode)
	{
		rootNode = new TreeNode(0);
		rootNode.left = new TreeNode(1);
		rootNode.right = new TreeNode(2);
		rootNode.left.left = new TreeNode(3);
		rootNode.left.right = new TreeNode(4);
		rootNode.left.right.left = new TreeNode(7);
		rootNode.left.right.right = new TreeNode(8);
		rootNode.right.left = new TreeNode(5);
		rootNode.right.right = new TreeNode(6);
		rootNode.right.right.left = new TreeNode(9);
	}
	
	public void constructTree2(TreeNode rootNode)
	{
		rootNode = new TreeNode(10);
		rootNode.left = new TreeNode(1);
		rootNode.right = new TreeNode(2);
		rootNode.left.left = new TreeNode(3);
		rootNode.left.right = new TreeNode(4);
		rootNode.left.right.left = new TreeNode(7);
		rootNode.left.right.right = new TreeNode(8);
		rootNode.right.left = new TreeNode(5);
		rootNode.right.right = new TreeNode(6);
		rootNode.right.right.left = new TreeNode(29);
	}
	
	public void levelOrderTraversal(TreeNode rootNode)
	{
		if(rootNode == null)
		{
			return;
		}
		else
		{
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(rootNode);
			TreeNode temp;
			while(!queue.isEmpty())
			{
				temp = queue.remove();
				System.out.print(temp.data+" ");
				if(temp.left != null)
				{
					queue.add(temp.left);
				}
				if (temp.right !=null)					
				{
					queue.add(temp.right);
				}
			}	
		}
		System.out.println();
	}


	
}

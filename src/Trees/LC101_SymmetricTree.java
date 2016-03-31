package Trees;

import java.util.LinkedList;
import java.util.Queue;


public class LC101_SymmetricTree {

	public static void main(String[] args) {

		LC101_SymmetricTree tree = new LC101_SymmetricTree();
		tree.constructTree();
		tree.levelOrderTraversal(tree.root);
		
		boolean symmeteric = IsSymmetricRecursive(tree.root);
		
		System.out.println("Symmetric : " + symmeteric);
	}

	private static boolean IsSymmetricRecursive(TreeNode rootNode) {

		if(rootNode == null)
		{
			return true;
		}
		
		return IsMirror(rootNode.left, rootNode.right);
	}

	private static boolean IsMirror(TreeNode root1, TreeNode root2) {

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
			return ( IsMirror(root1.left, root2.right) && IsMirror(root1.right, root2.left) );			
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
	
	public void constructTree()
	{
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
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

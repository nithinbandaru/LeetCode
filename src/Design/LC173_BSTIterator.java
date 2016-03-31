package Design;

import java.util.Stack;


public class LC173_BSTIterator {

	private Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public LC173_BSTIterator()
	{
		
	}
	
	public boolean hasNext()
	{
		return !stack.isEmpty();
	}
	
	public int next()
	{
		TreeNode temp = stack.pop();
		pushAll(temp.right);
		return temp.data;
	}
	
	
	public LC173_BSTIterator(TreeNode rootNode)
	{
		pushAll(rootNode);
	}
	
	
	
	private void pushAll(TreeNode rootNode) {

		while(rootNode != null)
		{
			stack.push(rootNode);
			rootNode = rootNode.left;
		}
	}



	public static void main(String[] args) {

		LC173_BSTIterator tree = new LC173_BSTIterator();
		tree.constructTree();
		
		LC173_BSTIterator itr = new LC173_BSTIterator(tree.root);
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
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
		root = new TreeNode(40);
		
		root.left = new TreeNode(20);
		root.right = new TreeNode(60);
		
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(30);		
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(70);
		
	}
	
}

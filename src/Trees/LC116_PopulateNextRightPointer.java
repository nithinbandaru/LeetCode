package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC116_PopulateNextRightPointer {

	public static void main(String[] args) {

		LC116_PopulateNextRightPointer tree = new LC116_PopulateNextRightPointer();
		tree.constructTree();
		
		boolean printNextpointer = false;
		
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root, printNextpointer );
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		TreeNode rootNode = tree.populateRightPointer(tree.root);
		
		List<List<Integer>>levels2 = tree.levelOrderTraversal(tree.root, !printNextpointer );
		
		for(List<Integer> level : levels2)
		{
			System.out.println(level);
		}
		
		
	}

	private TreeNode populateRightPointer(TreeNode rootNode) {

		if(rootNode == null)
		{
			return null;
		}
		
		while(rootNode.left != null)
		{
			
			TreeNode curr = rootNode;
			
			while(curr != null)
			{
				curr.left.next = curr.right;
				
				if(curr.next != null)
				{
					curr.right.next = curr.next.left;
				}
				
				curr = curr.next;
			}
			
			rootNode = rootNode.left;
		}
				
		
		return rootNode;
	}

	TreeNode root;
	
	class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		
		public TreeNode(int val)
		{
			data = val;
			left = null;
			right = null;
			next = null;
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
		
		//root.left.left.left = new TreeNode(7);
		//root.left.left.right = new TreeNode(2);
		//root.right.right.right = new TreeNode(1);
	}
	
	private List<List<Integer>> levelOrderTraversal(TreeNode rootNode, boolean printNextpointer) {

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
				if(printNextpointer)
				{
					
					currLevel.add(temp.next == null ? -1 : temp.next.data);
				}
				else
				{
					currLevel.add(temp.data);
				}				
				
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

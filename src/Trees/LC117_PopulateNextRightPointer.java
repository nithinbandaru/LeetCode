package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC117_PopulateNextRightPointer {

	public static void main(String[] args) {

		LC117_PopulateNextRightPointer tree = new LC117_PopulateNextRightPointer();
		tree.constructTree();
		
		boolean printNextpointer = false;
		
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root, printNextpointer );
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		tree.populateRightPointer(tree.root);
		
		List<List<Integer>>levels2 = tree.levelOrderTraversal(tree.root, !printNextpointer );
		
		for(List<Integer> level : levels2)
		{
			System.out.println(level);
		}
		
		
	}

	private void populateRightPointer(TreeNode rootNode) {

		if(rootNode == null)
		{
			return ;
		}
		
		TreeNode fakeHead = new TreeNode(0);
		TreeNode dummy = fakeHead;
		
		while(rootNode != null)
		{
			if(rootNode.left != null)
			{
				dummy.next = rootNode.left;
				dummy = dummy.next;
			}
			
			if(rootNode.right != null)
			{
				dummy.next = rootNode.right;
				dummy = dummy.next;
			}
			
			rootNode = rootNode.next;
			
			if(rootNode == null)
			{
				dummy = fakeHead;
				rootNode = dummy.next;
				fakeHead.next = null;
			}			
		}		
		
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
		root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);		
		root.right.left = new TreeNode(6);		
		root.right.right = new TreeNode(7);
		
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

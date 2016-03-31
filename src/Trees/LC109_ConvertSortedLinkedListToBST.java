package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC109_ConvertSortedLinkedListToBST {

	public static void main(String[] args) {

		LC109_ConvertSortedLinkedListToBST list = new LC109_ConvertSortedLinkedListToBST();
		
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		TreeNode rootNode = list.sortedListToBST(list.head);
		
		List<List<Integer>>levels = list.levelOrderTraversal(rootNode);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
	}
	
	private TreeNode sortedListToBST(LinkNode headNode) {
		
		int n = getNodeCount(headNode);
		System.out.println(n);
		head = headNode;
		return buildBSTUtil(0 , n-1);

	}

	
	private TreeNode buildBSTUtil(int start, int end) {

		if(start > end)
		{
			return null;
		}
		
		int mid = start + (end - start)/2;
		
		// Recursively construct left sub tree
		TreeNode leftSubTree = buildBSTUtil(start , mid-1);
		
		// Construct root
		
		TreeNode root  = new TreeNode(head.data);
		
		head = head.next;
		
		// Recursively construct right sub tree
		
		TreeNode rightSubTree = buildBSTUtil(mid + 1, end);
		
		// link left & right subtrees to root
		
		root.left = leftSubTree;
		root.right = rightSubTree;
				
		return root;
	}

	private int getNodeCount(LinkNode headNode) {

		int count = 0;
		if(headNode == null)
		{
			return count;
		}
		
		while(headNode != null)
		{
			headNode = headNode.next;
			count++;
		}
		
		return count;
	}

	LinkNode head;
	
	public void addAtBeginnning(int data)
	{
		LinkNode newNode = new LinkNode(data);
		newNode.next = head;
		head = newNode;
	}
	
	
	
	public void printLinkedList(LinkNode headNode)
	{
		LinkNode temp = headNode;
		
		if(temp == null)
		{
			System.out.println("List is empty");
			return;
		}
		
		while(temp != null)
		{
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	public class LinkNode
	{
		int data;
		LinkNode next;
		
		public LinkNode(int data)
		{
			this.data = data;
			next = null;
		}
		
	}


	

	TreeNode root;
	
	public class TreeNode
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
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
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

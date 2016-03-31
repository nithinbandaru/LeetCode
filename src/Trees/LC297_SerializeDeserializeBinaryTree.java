package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC297_SerializeDeserializeBinaryTree {

	public static void main(String[] args) {

		LC297_SerializeDeserializeBinaryTree tree = new LC297_SerializeDeserializeBinaryTree();
		tree.constructTree();
		
		String ser = SerializeTree(tree.root);
		System.out.println("Serialised Tree: " + ser);
		
		TreeNode rootNode = tree.DeserializeTree(ser);
		
		List<List<Integer>>levels = tree.levelOrderTraversal(rootNode);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}

	}

	private TreeNode DeserializeTree(String ser) {

		if(ser == "")
		{
			return  null;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		String[] values = ser.split(",");
		
		TreeNode rootNode = new TreeNode(Integer.parseInt(values[0]));
		queue.add(rootNode);		
		
		for(int i = 1; i < values.length; i++)
		{
			TreeNode currNode = queue.poll();
			
			if(!values[i].equals("n"))
			{
				TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
				currNode.left = leftChild;
				queue.add(leftChild);
			}
			
			if(!values[++i].equals("n"))
			{
				TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
				currNode.right = rightChild;
				queue.add(rightChild);
			}
		}
		
		return rootNode;
	}

	private static String SerializeTree(TreeNode rootNode) {

		if(rootNode == null)
		{
			return "";
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode);
		
		StringBuilder ser = new StringBuilder();
		
		while(!queue.isEmpty())
		{
			TreeNode curr = queue.poll();
			
			if(curr == null)
			{
				ser.append("n,");
				continue;
			}
			
			ser.append(curr.data+",");
			queue.add(curr.left);
			queue.add(curr.right);
			
		}		
		
		return ser.toString();
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
		
		//root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);		
		root.right.left = new TreeNode(5);
		//root.right.right = new TreeNode(7);
		
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

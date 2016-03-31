package Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class LC314_Traversal_TopView {

	public static void main(String[] args) {

		LC314_Traversal_TopView tree = new LC314_Traversal_TopView();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		List<Integer> topView = topViewTree(tree.root);
		System.out.println(topView);
		
	}

	private static List<Integer> topViewTree(TreeNode rootNode) {

		List<Integer> topView = new ArrayList<Integer>();
		if(rootNode == null)
		{
			return topView;
		}
		
		Set<Integer> horDistSet = new HashSet<Integer>();
		
		Queue<TreeNodeHD> queue = new LinkedList<TreeNodeHD>();
		queue.add(new TreeNodeHD(rootNode, 0));
		
		while(!queue.isEmpty())
		{
			TreeNodeHD curr = queue.poll();
			
			int dist = curr.horDist;
			TreeNode node = curr.node;
			
			if(!horDistSet.contains(dist))
			{
				horDistSet.add(dist);
				topView.add(node.data);
			}
			
			if(node.left != null)
			{
				queue.add(new TreeNodeHD(node.left , dist - 1));
			}
			
			if(node.right != null)
			{
				queue.add(new TreeNodeHD(node.right , dist + 1));
			}
		}
		
		return topView;
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
	
	static class TreeNodeHD
	{
		int horDist;
		TreeNode node;
		
		public TreeNodeHD(TreeNode n, int dist)
		{
			node = n;
			horDist = dist;			
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

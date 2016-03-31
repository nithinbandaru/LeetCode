package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;


public class LC314_Traversal_BottomView {

	public static void main(String[] args) {

		LC314_Traversal_BottomView tree = new LC314_Traversal_BottomView();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		bottomViewOfTree(tree.root);
		
	}

	private static void bottomViewOfTree(TreeNode rootNode) {

		if(rootNode == null)
		{
			return;
		}
		
		int hd = 0;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		rootNode.horDist = hd;
		queue.add(rootNode);
		
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		while(!queue.isEmpty())
		{
			TreeNode curr = queue.poll();
			
			hd = curr.horDist;
			
			map.put(hd, curr.data);
			
			if(curr.left != null)
			{
				curr.left.horDist = hd - 1;
				queue.add(curr.left);
			}
			
			if(curr.right != null)
			{
				curr.right.horDist = hd + 1;
				queue.add(curr.right);
			}
		}
		
		Set<Integer> keys = map.keySet();
		
		for(int key : keys)
		{
			System.out.print(map.get(key) + " ");
		}
		
	}

	TreeNode root;
	
	class TreeNode
	{
		int data;
		int horDist;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val)
		{
			data = val;
			left = null;
			right = null;			
		}
		
		public TreeNode(int val, int dist)
		{
			data = val;
			horDist = dist;
			left = null;
			right = null;			
		}
	}
	
	public void constructTree()
	{
		root = new TreeNode(20);
		
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(25);
		
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
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

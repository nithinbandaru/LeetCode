package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class LC314_Traversal_VerticalOrder {

	public static void main(String[] args) {

		LC314_Traversal_VerticalOrder tree = new LC314_Traversal_VerticalOrder();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		System.out.println("------------------");
		List<List<Integer>> verticalOrder = verticalTraversal(tree.root);
		
		for(List<Integer> v : verticalOrder)
		{
			System.out.println(v);
		}
		
		
	}

	private static List<List<Integer>> verticalTraversal(TreeNode rootNode) {

		List<List<Integer>> verticalOrder = new ArrayList<List<Integer>>();
		
		if(rootNode == null)
		{
			return verticalOrder;
		}
 		
		Map<Integer, List<Integer>> columnNodeMapping = new HashMap<Integer, List<Integer>>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> columns = new LinkedList<Integer>();
		
		queue.add(rootNode);
		columns.add(0);
		
		int minColNum = 0;
		int maxColNum = 0;
		
		while(!queue.isEmpty())
		{
			TreeNode curr = queue.poll();
			int colNum = columns.poll();
			
			if(!columnNodeMapping.containsKey(colNum))
			{
				columnNodeMapping.put(colNum, new ArrayList<Integer>());
			}
			
			columnNodeMapping.get(colNum).add(curr.data);
			
			if(curr.left != null)
			{
				queue.add(curr.left);
				columns.add(colNum - 1);
				if(colNum <= minColNum)
				{
					minColNum = colNum - 1;
				}
			}
			
			if(curr.right != null)
			{
				queue.add(curr.right);
				columns.add(colNum + 1);
				if(colNum >= maxColNum)
				{
					maxColNum = colNum + 1;
				}
			}
		}
		
		// add all vertical traversals to final list
		
		for(int i = minColNum ; i <= maxColNum ; i++)
		{
			verticalOrder.add(columnNodeMapping.get(i));
		}
		
		return verticalOrder;
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
		root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(2);
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

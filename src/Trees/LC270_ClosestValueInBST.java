package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC270_ClosestValueInBST {

	public static void main(String[] args) {

		LC270_ClosestValueInBST tree = new LC270_ClosestValueInBST();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		int target = 9;
		
		int closestValue = closestValueBST(tree.root , target);
		System.out.println(closestValue);
		
	}

	private static int closestValueBST(TreeNode rootNode, int target) {

		int closeVal = rootNode.data;
		
		while(rootNode != null)
		{
			
			if(Math.abs(target-rootNode.data) < Math.abs(target - closeVal))
			{
				closeVal = rootNode.data;
			}
			
			rootNode = rootNode.data > target ? rootNode.left : rootNode.right;
			
		}
		
		return closeVal;
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
		root = new TreeNode(13);
		
		root.left = new TreeNode(10);
		root.right = new TreeNode(25);
		
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(35);
		
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(6);
		root.right.right.right = new TreeNode(41);
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

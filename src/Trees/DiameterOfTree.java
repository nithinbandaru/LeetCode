package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/DiameterOfTree.java
public class DiameterOfTree {

	class HeightUtil
	{
		int height;
	}
	
	
	public static void main(String[] args) {

		DiameterOfTree tree = new DiameterOfTree();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		int dia = tree.diameter(tree.root);
		System.out.println(dia);
		
		
	}

	private int diameter(TreeNode rootNode) {

		HeightUtil heightObj = new HeightUtil();
		
		return diameterUtil(rootNode, heightObj);
	}

	private int diameterUtil(TreeNode rootNode, HeightUtil heightObj) {

		if(rootNode == null)
		{
			return 0;
		}
		
		HeightUtil leftHt = new HeightUtil();		
		HeightUtil rightHt = new HeightUtil();
		
		int leftDiameter = diameterUtil(rootNode.left, leftHt);
		int rightDiameter = diameterUtil(rootNode.right, rightHt);
		
		heightObj.height = 1 + Math.max(leftHt.height, rightHt.height);
		
		return Math.max(Math.max(leftDiameter, rightDiameter), 1 + leftHt.height + rightHt.height);
		
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

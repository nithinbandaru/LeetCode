package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC235_LeastCommonAncestorBST {

	public static void main(String[] args) {

		LC235_LeastCommonAncestorBST tree = new LC235_LeastCommonAncestorBST();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		
		TreeNode lca = LCAofBST(tree.root, tree.root.left.left, tree.root.left.right.right);
		System.out.println("LCA : " + lca.data);
		
	}

	private static TreeNode LCAofBST(TreeNode rootNode, TreeNode p, TreeNode q) {

		while(true)
		{
			
			if(rootNode.data < p.data && rootNode.data < q.data)
			{
				rootNode = rootNode.right;
			}
			else if(rootNode.data > p.data && rootNode.data > q.data)
			{
				rootNode = rootNode.left;
			}
			else
			{
				return rootNode;
			}
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
		root = new TreeNode(6);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		
		root.left.left = new TreeNode(0);	
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		
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

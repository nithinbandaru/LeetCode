package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC113_RootToLeafPathSumII {

	public static void main(String[] args) {

		LC113_RootToLeafPathSumII tree = new LC113_RootToLeafPathSumII();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		List<List<Integer>> paths = pathSumList(tree.root , 22);
		System.out.println(paths.size());
		for(List<Integer> path : paths)
		{
			System.out.println(path + " ");
		}
		
	}

	private static List<List<Integer>> pathSumList(TreeNode rootNode, int sum) {

		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		
		pathSumList(rootNode, sum, path, paths);
		
		return paths;
	}

	private static void pathSumList(TreeNode rootNode, int sum,
			List<Integer> path, List<List<Integer>> paths) {

		if(rootNode == null)
		{
			return;
		}
		
		path.add(rootNode.data);
		if(rootNode.left == null && rootNode.right == null && rootNode.data == sum)
		{
			paths.add( new ArrayList<>(path));
		}
		else
		{		
			pathSumList(rootNode.left, sum - rootNode.data, path, paths);
			pathSumList(rootNode.right, sum - rootNode.data, path, paths);
		}
		
		// Removes the element from wrong path before going to right path
		
		path.remove(path.size()-1);
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
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);		
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

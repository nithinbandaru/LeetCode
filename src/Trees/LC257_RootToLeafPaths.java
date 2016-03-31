package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC257_RootToLeafPaths {

	public static void main(String[] args) {

		LC257_RootToLeafPaths tree = new LC257_RootToLeafPaths();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		List<String> paths = tree.binaryTreePaths(tree.root);
		
		for(String path : paths)
		{
			System.out.println(path);
		}
		
	}
	
	public List<String> binaryTreePaths(TreeNode rootNode) {

        List<String> paths = new ArrayList<String>();
        
        if(rootNode == null)
        {
        	return paths;
        }
        
        binaryTreePathsUtil(rootNode, "", paths);
        
        return paths;
    }
	

	private void binaryTreePathsUtil(TreeNode rootNode, String path, List<String> paths) {
		
				
		if(rootNode.left == null && rootNode.right == null)
		{
			paths.add(new String(path + rootNode.data));
		}
		if(rootNode.left != null)
		{
			binaryTreePathsUtil(rootNode.left, path + rootNode.data +"->", paths);
		}	
		if(rootNode.right != null)
		{
			binaryTreePathsUtil(rootNode.right, path + rootNode.data + "->", paths);
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

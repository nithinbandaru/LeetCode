package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class LC103_ZigZagLevelOrderTraversal {

	public static void main(String[] args) {

		LC103_ZigZagLevelOrderTraversal tree = new LC103_ZigZagLevelOrderTraversal();
		tree.constructTree();
		List<List<Integer>>levels = tree.levelOrderTraversal(tree.root);
		
		for(List<Integer> level : levels)
		{
			System.out.println(level);
		}
		
		List<List<Integer>> zigzag = tree.zigZaglevelOrderTraversal(tree.root);
		
		for(List<Integer> level : zigzag)
		{
			System.out.println(level);
		}
		
	}

	private List<List<Integer>> zigZaglevelOrderTraversal(TreeNode rootNode) {

		List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null)
        {
            return levels;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        boolean zigzag = true;
        
        while(!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            
            for(int i = 0 ; i < size ; i++)
            {
                TreeNode curr = queue.poll();
                if(zigzag)
                {
                    level.add(curr.data);
                }
                else
                {
                    level.add(0,curr.data);
                }
                if(curr.left != null)
                {
                    queue.add(curr.left);
                }
                if(curr.right != null)
                {
                    queue.add(curr.right);
                }
            }
            levels.add(level);
            zigzag = !zigzag;
        }
        
        return levels;	}

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

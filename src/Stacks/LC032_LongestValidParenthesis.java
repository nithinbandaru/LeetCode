package Stacks;

import java.util.Stack;

public class LC032_LongestValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String parenthesis = ")()(()))(";
		
		int len = longestParenthesis(parenthesis);
		System.out.println(len);
	}

	private static int longestParenthesis(String s) 
	{
		 Stack<Integer> stack = new Stack<Integer>();
	     int result = 0;
	     stack.push(-1);
	     for (int i = 0; i < s.length(); i++) 
	     {
	    	 char ch = s.charAt(i);
	    	 if(ch == '(')
	    	 {
	    		 stack.push(i); // push index of open bracket
	    	 }
	    	 else
	    	 {
	    		 stack.pop();
	    		 
	    		 if(!stack.isEmpty())
	    		 {
	    			 result = Math.max(result, i - stack.peek());
	    		 }
	    		 else
	    		 {
	    			 stack.push(i);
	    		 }
	    	 }
	     }
	     
	     return result;
		
	}

	
	
}

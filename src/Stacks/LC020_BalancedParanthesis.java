package Stacks;

import java.util.Stack;

public class LC020_BalancedParanthesis {

	// Time Complexity = O(n)
	
	// Space Complexity = O(n)
	
	public static void main(String[] args) {

		String expression = "{[()}{]}";
		
		boolean balanced = IsBalanced(expression);
		
		System.out.println(balanced);
	}

	private static boolean IsBalanced(String expression) {

		if(expression == null || expression.length() % 2 != 0)
		{
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0 ; i < expression.length() ; i++)
		{
			char ch = expression.charAt(i);
			
			if(ch == '(' || ch == '[' || ch == '{')
			{
				stack.push(ch);
			}
			else
			{
				if(stack.isEmpty())					
				{
					return false;
				}
				else
				{
					if(ch == ')' && stack.pop() != '(' )
					{
						return false;
					}
					else if(ch == ']' && stack.pop() != '[' )
					{
						return false;
					}
					if(ch == '}' && stack.pop() != '{' )
					{
						return false;
					}
				}
			}
			
		}
		
		return stack.empty();
	}

} 

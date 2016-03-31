package Stacks;

import java.util.Stack;

public class LC150_EvaluatePostFixExpression {

	public static void main(String[] args) {

		String[] tokens = {"2", "1", "+", "3", "*"};		
		
		int ans = evaluateExpression(tokens);
		System.out.println(ans);
		
	}

	private static int evaluateExpression(String[] tokens) {

		int a = 0;
		int b = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(String s : tokens)
		{
			if(s.equals("+"))
			{
				stack.push(stack.pop() + stack.pop());
			}
			else if(s.equals("-"))
			{
				b = stack.pop();
				a = stack.pop();
				stack.push(a - b);
			}
			else if(s.equals("*"))
			{
				stack.push(stack.pop() * stack.pop());
			}
			else if(s.equals("/"))
			{
				b = stack.pop();
				a = stack.pop();
				stack.push(a/b);
			}
			else
			{
				stack.push(Integer.parseInt(s));
			}
			
		}
		
		return stack.pop();
	}

}

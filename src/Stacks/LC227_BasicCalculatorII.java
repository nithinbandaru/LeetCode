package Stacks;

import java.util.Stack;

public class LC227_BasicCalculatorII {

	public static void main(String[] args) {

		String expr = "5 + 8 / 2 - 1 * 4";
		
		int result = calculate(expr);
		System.out.println(result);
	}

	private static int calculate(String expr) {

		if(expr == null || expr.length() == 0)
		{
			return 0;
		}
		
		int len = expr.length();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int num = 0;
		char sign = '+';
		
		
		for(int i = 0; i < len;i++)
		{
			char ch = expr.charAt(i);
			
			if(Character.isDigit(ch))
			{
				num = 10 * num + ch -'0';
			}
			
			if( (!Character.isDigit(ch) && ch != ' ') || i == len-1)
			{
				if(sign == '+')
				{
					stack.push(num);
				}
				else if(sign == '-')
				{
					stack.push(-num);
				}
				else if(sign == '*')
				{
					stack.push(stack.pop() * num);
				}
				else if(sign == '/')
				{
					stack.push(stack.pop() / num);
				}
				
				sign = ch;
				num = 0;
			}
			
		}
		
		int result = 0;
		
		for(int i : stack)
		{
			result = result + i;
		}
		
		return result;
	}

}

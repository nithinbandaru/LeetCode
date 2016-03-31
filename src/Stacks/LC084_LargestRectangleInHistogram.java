package Stacks;

import java.util.Stack;

public class LC084_LargestRectangleInHistogram {

	// Time Complexity = O(n)
	// Space Complexity = O(n)	
	
	public static void main(String[] args) {

		int hist[] = {6, 2, 5, 4, 5, 1, 6};

		int maxArea = maxAreaHistogram(hist);
		System.out.println(maxArea);
		
	}

	private static int maxAreaHistogram(int[] hist) {

		Stack<Integer> stack = new Stack<Integer>();
		
		int area = 0;
		int maxArea = 0;
		int i;
		for(i = 0 ; i < hist.length;)
		{
			if(stack.isEmpty() || hist[i] >= hist[stack.peek()])
			{
				stack.push(i++);
			}
			else
			{
				int top = stack.pop();
				
				if(stack.isEmpty())
				{
					area = hist[top] * i;
				}
				else
				{
					area = hist[top] *(i - stack.peek() - 1);
				}
				
				
				if(area > maxArea)
				{
					maxArea = area;
				}
			}
		}
		
		while(!stack.isEmpty())
		{
			int top = stack.pop();
			
			if(stack.isEmpty())
			{
				area = hist[top] * i;
			}
			else
			{
				area = hist[top] *(i - stack.peek() - 1);
			}
			
			
			if(area > maxArea)
			{
				maxArea = area;
			}
		}		
		
		return maxArea;
	}

}

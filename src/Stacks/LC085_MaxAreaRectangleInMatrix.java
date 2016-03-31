package Stacks;

import java.util.Stack;

public class LC085_MaxAreaRectangleInMatrix {

	// Time Complexity = O(numOfRows*numOfCols)
	// Space Complexity = O(numCols)	
	
	public static void main(String[] args) {

		//int hist[] = {6, 2, 5, 4, 5, 1, 6};
		
		int[][] matrix = { {1, 0, 0, 1, 1, 1},
						   {1, 0, 1, 1, 0, 1},
						   {0, 1, 1, 1, 1, 1},
						   {0, 0, 1, 1, 1, 1}
						 };

		int maxArea = largestAreaOfRectangle(matrix);
		System.out.println(maxArea);
		
	}

	private static int largestAreaOfRectangle(int[][] matrix) {

		int numRows = matrix.length;
		int numCols = matrix[0].length;
		
		int[] DPArray = new int[numCols];
		
		int maxArea = 0;
		int area = 0;
		
		for(int i = 0 ; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				if(matrix[i][j] == 0)
				{
					DPArray[j] = 0;
				}
				else
				{
					DPArray[j] = DPArray[j] + matrix[i][j];
				}
			}
			
			area = maxAreaHistogram(DPArray);
			
			if(area > maxArea)
			{
				maxArea = area;
			}			
		}
		
		return maxArea;
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

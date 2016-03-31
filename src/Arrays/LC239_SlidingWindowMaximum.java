package Arrays;

import java.util.LinkedList;
import java.util.Arrays;

// Time complexity = O(n)
// space complexity = O(k) for maintaining the linkedlist
public class LC239_SlidingWindowMaximum {

	public static void main(String[] args) {

		int[] A = {1,3,-1,-3,5,3,6,7};
		
		int k = 3;
		
		int[] slidingWindow = slidingWindowMaximum(A, k);
		
		System.out.println(Arrays.toString(slidingWindow));
	}

	private static int[] slidingWindowMaximum(int[] A, int k) {

		// Base condition
		if(A == null || A.length == 0)
		{
		    return new int[]{};
		}
        
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// step 1 : Build initial list of window size k
		
		for(int i = 0; i < k; i++)
		{
			
			// remove all elements which are less than current element from list
			
			while(!list.isEmpty() && A[list.getLast()] < A[i])
			{
				list.removeLast();
			}
			
			// Add index of current element
			
			list.addLast(i);
			
		}
		
		// step2 : Print the max in each window
		
		int[] slidingWindow = new int[A.length - k + 1];
		int index = 0 ;
		
		for(int i = k ; i < A.length; i++)
		{
			// first element present in the list is the greatest element for the last 'k' sized sub-array
			slidingWindow[index] = A[list.getFirst()]; 
			index = index + 1;
			// now remove all indices of elements from the beginning of list which do not belong to current window

			while(!list.isEmpty() && list.getFirst() < (i -k + 1))
			{
				list.removeFirst();
			}
			
			// remove all elements which are less than current element from list
			
			while(!list.isEmpty() && A[list.getLast()] < A[i])
			{
				list.removeLast();
			}
			
			// Now add current element
			
			list.addLast(i);
			
		}
		
		slidingWindow[index] = A[list.getFirst()]; 
		
		return slidingWindow;
	}

}

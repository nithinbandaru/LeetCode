package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LC163_MissingRangesInArrayOfNumbers {

	public static void main(String[] args) {

		int[] A = { 0, 1, 3, 50, 75};
		
		List<String> missingRanges = missingRangesArray(A, 0 , 99);
		
		for(String range : missingRanges)
		{
			System.out.println(range);
		}
	}

	private static List<String> missingRangesArray(int[] A, int lowerBound, int upperBound) {

		List<String> missingRanges = new ArrayList<String>();
		
		if(A== null || A.length == 0)
		{
			missingRanges.add(getRange(lowerBound, upperBound));
			return missingRanges;
		}
		
		int prev;
		// handle lower boundary case
		
		if(A[0] - lowerBound > 1)
		{
			missingRanges.add(getRange(lowerBound, A[0]-1));
			prev = A[0];
		}
		else
		{
			prev = lowerBound;
		}
		
		for(int curr : A)
		{
			
			if(curr - prev > 1)
			{
				missingRanges.add(getRange(prev + 1, curr - 1));
			}
			
			prev = curr;
			
		}
		
		// Handle upper boundary
		
		if(upperBound - prev > 1)
		{
			missingRanges.add(getRange(prev + 1, upperBound));
		}
		
		return missingRanges;
	}

	private static String getRange(int lowerBound, int upperBound) {

		return (lowerBound == upperBound) ? String.valueOf(lowerBound) : lowerBound + "->" + upperBound;
	}

}

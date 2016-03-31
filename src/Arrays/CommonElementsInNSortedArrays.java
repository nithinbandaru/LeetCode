package Arrays;

public class CommonElementsInNSortedArrays {

	// Time Complexity is O(m1 + m2 + m3 + .. + mn)
	// Space Complexity is O(n)
	// http://www.ideserve.co.in/learn/find-common-elements-in-n-sorted-arrays
	public static void main(String[] args) {

		int[][] arrays = {{23, 34, 67, 89, 123, 566, 1000},
				          {11, 22, 23, 24,33, 37, 185, 566, 987, 1223, 1234},
				          {23, 43, 67, 98, 566, 678},
				          {1, 4, 5, 23, 34, 76, 87, 132, 566, 665},
				          {1, 2, 3, 23, 24, 344, 566}
					     };
		
		printCommonElements(arrays);
		
		
	}

	private static void printCommonElements(int[][] arrays) {

		// to store the current index for 0th array

		int baseIndex = 0;
		
		// to store the current index for each of the remaining n-1 arrays
		int[] resumeIndex = new int[arrays.length - 1];
		
		// to track in how many arrays a specific element is found
		int totalMatchesFound;
		
		// variable used to terminate the search early 
		
		boolean smallestArrayTraversalDone = false;
		
		/*
		 *  pick elements one by one from the first array
         *  and check we find a match for them in all other arrays  
         */
		
		while( baseIndex < arrays[0].length && (!smallestArrayTraversalDone))
		{
			
			totalMatchesFound = 0 ;
			
			for(int i = 1 ; i < arrays.length ; i++)
			{
				
				int currentIndex = resumeIndex[i-1];
				
				while(currentIndex < arrays[i].length && arrays[i][currentIndex] < arrays[0][baseIndex])
				{
					currentIndex++;
				}
				
				if(currentIndex < arrays[i].length)
				{
					if(arrays[i][currentIndex] == arrays[0][baseIndex])
					{
						totalMatchesFound++;
					}
				}
				else
				{
					smallestArrayTraversalDone = true;
				}
				
				resumeIndex[i-1] = currentIndex ; 
			}
			
			if(totalMatchesFound == arrays.length - 1)
			{
				System.out.println(arrays[0][baseIndex]);
			}
			
			baseIndex += 1;
			
		}		
	}

}

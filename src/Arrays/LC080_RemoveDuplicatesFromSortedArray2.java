package Arrays;

public class LC080_RemoveDuplicatesFromSortedArray2 {

	
	// duplicates are allowed at most twice
	
	public static void main(String[] args) {

		int[] A = {1, 1, 2, 2 , 2 , 3, 3, 3, 4, 5, 5, 5, 6, 6};
		
		int numOfDuplicatesAllowed = 2;
		
		int newLen = removeDuplicates(A, numOfDuplicatesAllowed);
		
		for(int i = 0 ; i < newLen ; i++)
		{
			System.out.print(A[i] + " ");
		}
		
	}

	private static int removeDuplicates(int[] A , int numOfDuplicatesAllowed) {

		if(numOfDuplicatesAllowed == A.length)
		{
			return A.length;
		}
		
		int index = 1;
		
		int diplicatesCount = 1;
		
		for(int i = 1; i < A.length ; i++)
		{
			if(A[i] != A[i-1])
			{
				diplicatesCount = 1;
				A[index] = A[i];
				index++;
			}
			else
			{
				if(diplicatesCount < numOfDuplicatesAllowed)
				{
					diplicatesCount++;
					A[index] = A[i];
					index++;					
				}
			}
		}
		
		return index;
	}

}

package Arrays;

public class LC075_SortColors012 {

	public static void main(String[] args) {

		int[] A = {0, 1, 2, 0, 1, 2, 0, 2, 0, 1, 2, 1};
		
		sortColors(A);		
		
		for(int i : A)
		{
			System.out.print(i + " ");
		}
		
	}

	// The idea is to sweep all 0s to the left and all 2s to the right, 
	// then all 1s are left in the middle
	
	// the basic idea is to use two pointer low and high and an iterator i
	// every element left low pointer is 0, elem right high pointer is 2
	
	private static void sortColors(int[] A) {

		int low = 0;
		int high = A.length-1;
		
		int i = low;
		
		while(i <= high)
		{
			if(A[i]==0) 
			{
				int temp = A[i];
	            A[i] = A[low];
	            A[low] = temp;
	            i++;
	            low++;
	        }
			else if(A[i]==2) 
			{
	            int temp = A[i];
	            A[i] = A[high];
	            A[high] = temp;
	            high--;
	        }
			else 
			{
	            i++;
	        }
		}
	}
}

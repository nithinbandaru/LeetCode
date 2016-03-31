package Arrays;


import java.util.Arrays;
public class LC259_3SumSmaller {

	public static void main(String[] args) {

		
		int[] A = {-2, 0, 1, 3}; 
		
		int target = 2;
		
		int count = tripletsCount(A, target);
		System.out.println(count);
	}

	private static int tripletsCount(int[] A, int target) {

		Arrays.sort(A);
		
		int count = 0;
		
		for(int i = 0; i < A.length - 2 ; i++)
		{
			int low = i + 1;
			int high = A.length - 1;
			
			while(low < high)
			{
				if(A[i] + A[low] + A[high] < target)
				{
					count = count + high - low;
					low++;
				}
				else
				{
					high--;
				}
			}
			
		}		
		
		return count;
	}

}

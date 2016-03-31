package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LC018_4ElementsSumToTarget {

	public static void main(String[] args) {

		int[] A = {1, 0, -1, 0, -2, 2};
		
		int target = 0;
		
		List<List<Integer>> list = fourSum(A , target);
		
		for(List<Integer> l : list)
		{
			System.out.println(l);
		}
		
		
	}

	private static List<List<Integer>> fourSum(int[] A, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(A.length < 4)
		{
			return result;
		}
		
		Arrays.sort(A);
		
		for(int i = 0 ; i < A.length - 3 ; i++)
		{
			
			if(i > 0 && A[i] == A[i-1])
			{
				continue;
			}
			
			for(int j = i+1 ; j < A.length - 2 ; j++)
			{
				
				if(j > i+1 && A[j] == A[j-1])
				{
					continue;
				}
				
				int low = j+1; 
				int high = A.length-1;
				
				while(low < high)
				{
					int sum = A[i] + A[j] + A[low] + A[high];
					
					if(sum == target)
					{
						result.add(Arrays.asList(A[i] , A[j] , A[low] , A[high]));
						
						while(low < high && A[low] == A[low+1])
						{
							low++;
						}
						while(low < high && A[high] == A[high-1])
						{
							high--;
						}
						low++;
						high--;
					}
					else if(sum < target)
					{
						low++;
					}
					else
					{
						high--;
					}
				}
			}
		}
		
		return result;
	}

}

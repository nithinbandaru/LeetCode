package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class LC015_ThreePairSum {

	public static void main(String[] args) {

		int[] A = {-2, 0, 0, 2, 2};
		
		int sum = 0;
		
		List<List<Integer>> three = getThreePair(A , sum);
		
		for(List<Integer> l : three)
		{
			System.out.println(l);
		}
		
	}

	private static List<List<Integer>> getThreePair(int[] A , int sum) {

		Arrays.sort(A);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i=0 ; i < A.length - 2 ; i++)
		{
			if(i == 0 || i > 0 && A[i] != A[i-1])
			{
				int low = i+1;
				int high = A.length - 1;
				
				while(low < high)
				{
					if(A[i] + A[low] + A[high] == sum)
					{
						result.add(Arrays.asList(A[i] , A[low], A[high]));
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
					else if(A[i] + A[low] + A[high] < sum)
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

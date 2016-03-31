package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LC219_DuplicatesInArrayWithinKDistance {

	public static void main(String[] args) {

		int[] A = { 2, 5, 7, 2 , 8, 2 ,4 };
		
		boolean dup = duplicatesWithInKDistance(A, 2);
		System.out.println(dup);
		
	}	

	private static boolean duplicatesWithInKDistance(int[] A, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < A.length ; i++)
		{
			if(map.containsKey(A[i]))
			{
				if(i - map.get(A[i]) <= k)
				{
					return true;
				}
			}
				
			map.put(A[i], i);
			
		}
		
		return false;
	}

}

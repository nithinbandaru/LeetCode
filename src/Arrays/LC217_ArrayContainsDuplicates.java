package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC217_ArrayContainsDuplicates {

	public static void main(String[] args) {

		int[] A = { 10, 7, 8, 3 , 5, 7, 6 };
		
		boolean dup = dupliatesInArrayWithSort(A);
		System.out.println(dup);
		
		boolean dup2 = dupliatesInArrayWithSet(A);
		System.out.println(dup2);
		
		
	}

	// O(n) & O(n)
	
	private static boolean dupliatesInArrayWithSet(int[] A) {

		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i<A.length;i++)
		{
			if(set.contains(A[i]))
			{
				return true;
			}
			set.add(A[i]);
		}
		
		return false;
	}

	// O(nlogn) && O(1)
	private static boolean dupliatesInArrayWithSort(int[] A) {

		Arrays.sort(A);
		
		for(int i = 1; i< A.length ; i++)
		{
			if(A[i] == A[i-1])
			{
				return true;
			}
		}
		
		return false;
	}

}

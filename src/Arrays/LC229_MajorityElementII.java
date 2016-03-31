package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LC229_MajorityElementII {

	public static void main(String[] args) {

		int[] A = { 7, 8, 7, 8, 4, 7, 8, 7, 5, 8 };
		
		List<Integer> majorElements = majorityElements(A);
		System.out.println(majorElements);
	}

	private static List<Integer> majorityElements(int[] A) {

		List<Integer> result = new ArrayList<Integer>();
		
		if(A == null || A.length == 0)
		{
			return result;
		}
		
		int count1 = 0;
		int count2 = 0;
		
		int candidate1 = 0;
		int candidate2 = 1;
		
		for(int num : A)
		{
			
			if(num == candidate1)
			{
				count1++;
			}
			else if(num == candidate2)
			{
				count2++;
			}
			else if(count1 == 0)
			{
				candidate1 = num;
				count1 = 1;
			}
			else if(count2 == 0)
			{
				candidate2 = num;
				count2 = 1;
			}
			else
			{
				count1--;
				count2--;
			}			
		}
		
		count1 = 0;
		count2 = 0;
		
		for(int num : A)
		{
			if(num == candidate1)
			{
				count1++;
			}
			else if(num == candidate2)
			{
				count2++;
			}			
		}
		
		if(count1 > A.length/3)
		{
			result.add(candidate1);
		}
		
		if(count2 > A.length/3)
		{
			result.add(candidate2);
		}
		
		return result;
	}

}

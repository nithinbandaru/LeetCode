package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LC228_SummaryArrayRanges {

	public static void main(String[] args) {

		int[] A = {0,1,2,3,5,6,7};
		
		List<String> list = summaryRanges(A);
		
		for(String s : list)
		{
			System.out.println(s);
		}
		
	}

	private static List<String> summaryRanges(int[] A) {

		List<String> list=new ArrayList<String>();
		
		for(int i = 0 ; i < A.length ; i++)
		{
			int num = A[i];
			
			while( i+1 < A.length && A[i+1] - A[i] == 1)
			{
				i++;
			}
			
			if( num != A[i])
			{
				list.add(num + " -> " + A[i]);
			}
			else
			{
				list.add(num + " ");
			}
		}
		
		return list;
		
	}

}

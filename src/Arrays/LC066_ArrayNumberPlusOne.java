package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LC066_ArrayNumberPlusOne {

	public static void main(String[] args) {

		
		//int[] A = { 9, 9 , 9 ,9 };
		
		int[] A = {0};
		
		int[] result = plusOne(A);
		
		for(int i: result)
		{
			System.out.print(i);
		}
		
	}

	private static int[] plusOne(int[] digits) {

		for(int i = digits.length - 1 ; i >=0 ; i--)
		{
			if(digits[i] != 9)
			{
				digits[i]++;
				break;
			}
			else
			{
				digits[i] = 0;
			}
		}
		
		if(digits[0] == 0)
		{
			int[] result = new int[digits.length+1];
			result[0] = 1;
			return result;
		}		
		List<Integer> a = new ArrayList<Integer>();
	
		return digits;
	}

}

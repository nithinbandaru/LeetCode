package Math;

import java.util.HashSet;
import java.util.Set;

public class LC202_HappyNumbers {

	public static void main(String[] args) {

		int num = 19;
		
		boolean happy = IsHappyNumber(num);
		System.out.println(happy);
		
	}

	private static boolean IsHappyNumber(int num) {

		Set<Integer> set = new HashSet<Integer>();
		
		set.add(num);
		
		while(num != 1)
		{
			int result = 0 ;
			
			while(num != 0)
			{
				result = result + ( num % 10) * ( num % 10);
				num = num / 10 ;
			}
			
			if(set.contains(result))
			{
				return false;
			}
			
			set.add(result);
			
			num = result;			
			
		}
		
		return true;
	}

}

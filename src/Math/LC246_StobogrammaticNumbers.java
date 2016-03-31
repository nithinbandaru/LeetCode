package Math;

import java.util.HashMap;
import java.util.Map;

public class LC246_StobogrammaticNumbers {

	public static void main(String[] args) {

		
		String num = "906";
		
		boolean isStobo = IsStoboGrammatic(num);
		System.out.println(isStobo);
		
	}

	private static boolean IsStoboGrammatic(String num) {

		Map<Character, Character> map = new HashMap<Character, Character>();
		
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		
		int start = 0;
		int end = num.length() - 1;
		
		while(start <= end)
		{
			char ch = num.charAt(start);
			
			if(!map.containsKey(ch))
			{
				return false;
			}
			
			if((map.get(ch) != num.charAt(end)))
			{
				return false;
			}
			
			start++;
			end--;			
		}
		
		return true;
	}

}

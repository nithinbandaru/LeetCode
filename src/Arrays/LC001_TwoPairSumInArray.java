package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LC001_TwoPairSumInArray {

	public static void main(String[] args) {

		
		int[] numbers = {2, 7, 11, 15};
		int target = 17;

		int[] indexes = twoPairSum(numbers, target);
		
		System.out.println(indexes[0] + " " + indexes[1]);
		
	}

	private static int[] twoPairSum(int[] numbers, int target) {

		int[] indexes = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < numbers.length ; i++)
		{
			int num = numbers[i];
			int otherNum = target - num;
			
			if(map.containsKey(otherNum))
			{
				indexes[0] = map.get(otherNum);
				indexes[1] = i;
				return indexes;
			}
			
			map.put(num, i);
			
		}
		
		return indexes;
	}

}

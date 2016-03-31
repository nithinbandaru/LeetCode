package Design;

import java.util.HashMap;
import java.util.Map;

public class LC170_TwoSum {

	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public void add(int number)
	{
		map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
	}
	
	public boolean find(int value)
	{
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			int i = entry.getKey();
			int j = value - i;
			
			if(i==j && entry.getValue() > 1 || (i != j && map.containsKey(j)))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {

		LC170_TwoSum twoSum = new LC170_TwoSum();
		
		twoSum.add(1);
		twoSum.add(3);
		twoSum.add(5);
		
		System.out.println(twoSum.find(6));
	}

}

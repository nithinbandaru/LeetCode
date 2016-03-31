package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LC278_FirstBadVersion {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7};
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "good");
		map.put(2, "good");
		map.put(3, "good");
		map.put(4, "good");
		map.put(5, "bad");
		map.put(6, "bad");
		map.put(7, "bad");
	
		int index = firstBadVersion(nums,map);
		System.out.println(index);
	}

	private static int firstBadVersion(int[] nums, Map<Integer, String> map) {

		int start = 0 ;
		int end = nums.length - 1;
		
		while(start<end)
		{
			int mid = start + (end - start)/2;
			if(!map.get(mid).equals("bad"))
			{
				start = mid+1;
			}
			else
			{
				end = mid;
			}
		}
		
		return start;
	}
	

}

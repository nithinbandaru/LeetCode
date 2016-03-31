package Strings;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LC249_GroupShiftedStrings {

	public static void main(String[] args) {

		
		String[] S = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		
		List<List<String>> group = groupShiftedStrings(S);

		for(List<String> list : group)
		{
			System.out.println(list);
		}
		
	}

	private static List<List<String>> groupShiftedStrings(String[] S) {

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		Arrays.sort(S);
		
		for(String str: S)
		{
			String  shiftPattern = "";
			
			char firstChar = str.charAt(0); 
			
			for(char c : str.toCharArray())
			{
				shiftPattern = shiftPattern + (c - firstChar < 0 ? 26 + c - firstChar : c- firstChar);
			}
			System.out.println(shiftPattern);
			if(!map.containsKey(shiftPattern))
			{
				map.put(shiftPattern, new ArrayList<String>());
			}
			
			map.get(shiftPattern).add(str);
		}
		
		return new ArrayList<List<String>>(map.values());
	}

}

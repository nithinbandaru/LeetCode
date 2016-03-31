package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class LC049_GroupAnagramsTogether {

	public static void main(String[] args) {

		String[] anagrams =  {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> group = groupAnagrams(anagrams);
		
		for(List<String> list : group)
		{
			System.out.println(list);
		}
		
		
	}

	private static List<List<String>> groupAnagrams(String[] anagrams) {

		List<List<String>> groupedAnagrams = new ArrayList<List<String>>();
		
		if(anagrams == null || anagrams.length == 0)
		{
			return groupedAnagrams;
		}
		
		HashMap<String, LinkedHashSet<String>> anagramGroups = new HashMap<String, LinkedHashSet<String>>();
		
		Arrays.sort(anagrams);
		
		for(String anagram : anagrams)
		{
		
			String sortedString = getSortedVersion(anagram);
			
			if(!anagramGroups.containsKey(sortedString))
			{
				LinkedHashSet<String> group1 = new LinkedHashSet<String>();
				group1.add(anagram);
				anagramGroups.put(sortedString, group1);
			}
			else
			{
				LinkedHashSet<String> group2 = anagramGroups.get(sortedString);
				
				if(!group2.contains(anagram))
				{
					group2.add(anagram);
				}
				
			}
		}
		
		for (Map.Entry<String, LinkedHashSet<String>> group : anagramGroups.entrySet())
	    {
			List<String> eachGroup = new ArrayList<String>();
			eachGroup.addAll(group.getValue());
			groupedAnagrams.add(eachGroup);
	    }
		
		return groupedAnagrams;
	}

	private static String getSortedVersion(String anagram) {

		char[] charArray = anagram.toCharArray();
		
		Arrays.sort(charArray);
		
		return new String(charArray);
	}

}

package Strings;

import java.util.HashMap;
import java.util.Map;

public class LC290_WordPattern {

	public static void main(String[] args) {

		String pattern = "abba";
		
		String text = "dog cat cat fish";
		
		boolean patternMatch = IsPatternMatching(pattern, text);
		System.out.println(patternMatch);		
		
	}

	private static boolean IsPatternMatching(String pattern, String text) {

		String[] words = text.split(" ");
		
		if(pattern.length() != words.length)
		{
			return false;
		}
		
		Map<Character, String> map = new HashMap<Character , String>();
		
		for(int i=0; i < words.length ;i++)
		{
			char ch = pattern.charAt(i);
			
			if(map.containsKey(ch))
			{
				if(!map.get(ch).equals(words[i]))
				{
					return false;
				}
			}
			else
			{
				if(map.containsValue(words[i]))
				{
					return false;
				}
				map.put(ch, words[i]);
			}			
					
		}
		
		return true;
	}

}

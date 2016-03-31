package Strings;

import java.util.HashMap;

public class LC003_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		
		String s = "geeksforgeeks";
		int len = lengthOfLongestSubstring(s);
		System.out.println(len);
	}
	
	public static int lengthOfLongestSubstring(String s) {
		
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int maxLen = 0;
        
        for (int currIndex = 0, beginningOfNextSubString = 0; currIndex < s.length(); currIndex++)
        {        	
            if (map.containsKey(s.charAt(currIndex)))
            {
            	beginningOfNextSubString = Math.max(beginningOfNextSubString, map.get(s.charAt(currIndex)) + 1);
            }
            
            map.put(s.charAt(currIndex),currIndex);
            
            maxLen = Math.max(maxLen, currIndex - beginningOfNextSubString + 1);
        }
        
        return maxLen;
	}

}

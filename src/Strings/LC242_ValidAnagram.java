package Strings;

public class LC242_ValidAnagram {

	public static void main(String[] args) {

		
		String s = "anagram";
		String t = "nagabam";
		
		boolean anagram = IsValidAnagram(s,t);
		System.out.println(anagram);
	}

	private static boolean IsValidAnagram(String s, String t) {
		
		int[] alphabet = new int[26];
		
		for(int i = 0 ; i < s.length() ; i++)
		{
			char ch = s.charAt(i);
			alphabet[ch-'a']++; 
		}
		
		for(int i = 0 ; i < t.length(); i++)
		{
			char ch = t.charAt(i);
			
			if(--alphabet[ch-'a'] < 0)
			{
				return false;
			}			
		}
		
		return true;
	}

}

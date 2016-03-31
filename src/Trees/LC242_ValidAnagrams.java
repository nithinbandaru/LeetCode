package Trees;

public class LC242_ValidAnagrams {

	public static void main(String[] args) {

		String s1 = "car";
		String s2 = "rat";
		
		boolean anagrams = IsValidAnagram(s1, s2);
		System.out.println(anagrams);
	}

	private static boolean IsValidAnagram(String s, String t) {

		if(s == null || t == null || s.length() != t.length())
		{
			return false;
		}
		
		int[] alphabets = new int[26];
		
		for(int i= 0; i < s.length() ;i++)
		{
			alphabets[s.charAt(i) -'a']++;
		}
		
		for(int i=0; i < t.length() ; i++)
		{	
			if(--alphabets[t.charAt(i) -'a'] < 0)
			{
				return false;
			}
		}
		
		return true;
	}

}

package Strings;

public class LC214_ShortestPalindromeByAppendingCharacters {

	public static void main(String[] args) {

		String s = "abcd";
		
		
		String pal = shortestPalindrome(s);
		System.out.println(pal);
		
	}
	
	public static String shortestPalindrome(String s) {
		String rev_s = new StringBuilder(s).reverse().toString();
		//use special character to avoid overlap
		String l = s + rev_s; 
		int[] p = new int[l.length()];
	
	
		for(int i=1; i<l.length(); i++)
		{
			//update prefix boundary to previous match position
			int j = p[i-1];
			while(j>0 && l.charAt(i)!=l.charAt(j))
			{
				j = p[j-1];
			}
			if(l.charAt(i) == l.charAt(j)) 
			{
				p[i] = j + 1;
			}				
		}
		
		return rev_s.substring(0, s.length() - p[l.length() - 1]) + s;	
		
	}

}

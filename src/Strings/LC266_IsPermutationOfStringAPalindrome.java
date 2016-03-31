package Strings;

import java.util.HashSet;
import java.util.Set;

public class LC266_IsPermutationOfStringAPalindrome {

	public static void main(String[] args) {

		
		String str = "carerac";
		
		boolean isPal = IsPermutationPalindrome(str);
		System.out.println("Palindrome Permutation : " + isPal);
	}

	private static boolean IsPermutationPalindrome(String text) {

		Set<Character> set = new HashSet<Character>();
		
		for(int i = 0 ; i < text.length() ; i++)
		{
			char ch = text.charAt(i);
			
			if(set.contains(ch))
			{
				set.remove(ch);
			}
			else
			{
				set.add(ch);
			}
		}
		
		return ( set.size() <= 1);
	}

}

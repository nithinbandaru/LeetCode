package Strings;

public class LC186_ReverseWordsBestAlgo {

	// https://leetcode.com/discuss/24227/my-java-solution-with-explanation
	
	// Rotation Of Array Inspiration
	public static void main(String[] args) {

		String sentence = "the sky is blue";
		
		String revSentence = reverseWords(sentence);
		System.out.println(revSentence);
		
	}

	private static String reverseWords(String sentence) {

		char[] ch = sentence.toCharArray();
		
		// 1. Reverse entire string
		reverseString(ch, 0, ch.length-1);
		
		// 2. Reverse each word

		int start = 0;
		for(int i = 0; i < ch.length; i++)
		{
			if(ch[i] == ' ')
			{
				reverseString(ch, start, i-1);
				start = i + 1;
			}
		}
			
		// 3. Reverse last word
		
		reverseString(ch, start, ch.length - 1);
		
		return new String(ch);
	}
	
	
	public static void reverseString(char[] ch, int start, int end)
	{	
		while(start < end)
		{
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;			
		}
	}

}

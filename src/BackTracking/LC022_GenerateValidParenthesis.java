package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LC022_GenerateValidParenthesis {

	public static void main(String[] args) {

		int n = 5;
		
		List<String> validParenthesis = generateParentheses(n);
		System.out.println(validParenthesis.size());
		for(String p : validParenthesis)
		{
			//System.out.println(p);
		}
		
	}

	private static List<String> generateParentheses(int n) {

		List<String> validParen = new ArrayList<String>();
		
		generateParenthesesBackTrack(validParen, "" , 0 , 0 , n);
		
		return validParen;
	}

	private static void generateParenthesesBackTrack(List<String> validParen,
			String str, int open, int close, int n) {

		if(str.length() == 2 * n)
		{
			validParen.add(str);
			return;
		}
		
		if(open < n)
		{
			generateParenthesesBackTrack(validParen , str + "(" , open + 1 , close , n);
		}
		
		if(close < open)
		{
			generateParenthesesBackTrack(validParen , str + ")" , open , close + 1 , n);
		}		
		
	}

}

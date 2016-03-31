package Strings;

import java.util.HashMap;

public class LC288_UniqueWordAbbreviation {

	public static void main(String[] args) {

		
		String text = "hello";
		
		
		//String[] dict = { "deer", "door", "cake", "card" };
		
		String[] dict = {"hello"};
		
		boolean isUnique = IsAbbreviationUnique(dict, text);
		
		System.out.println(isUnique);
	}

	private static boolean IsAbbreviationUnique(String[] dict, String text) {

		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i=0; i<dict.length;i++)
		{
			String abbr = getAbbreviation(dict[i]);
			
			if(!map.containsKey(dict[i]))
			{
				map.put(dict[i], abbr);
			}
		}
		
		String abbrText = getAbbreviation(text);
		
		if(!map.containsValue(abbrText))
		{
			return true;
		}
		return false;
	}

	private static String getAbbreviation(String text) {

		int textLen = text.length();
		if(textLen <=2)
		{
			return text;
		}
		
		return text.charAt(0) + Integer.toString(textLen-2) + text.charAt(textLen-1);
	}

}

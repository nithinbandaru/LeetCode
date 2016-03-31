package Strings;

public class LC014_LongestCommonPrefix {

	// Time complexity = O( arrayLength * longest String length)
	
	public static void main(String[] args) {

		//String[] strArray = { "hello" , "helper" , "hellNo", "hellraiser" , "helter"};
		String[] strArray = {"abcd", "abce", "abcf", "bcde"};
		 
		
		String prefix = longestPrefix(strArray);
		System.out.println("prefix " + prefix);
		
	}

	private static String longestPrefix(String[] strArray) {

		if(strArray == null || strArray.length == 0)
		{
			return "";
		}
		
		String prefix = strArray[0];
		
		for(int i = 1 ; i < strArray.length ; i++)
		{
			while(strArray[i].indexOf(prefix) != 0)
			{	
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		
		return prefix;
	}

}

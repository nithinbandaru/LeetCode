package Strings;

public class LC058_LengthOfLastWord {

	public static void main(String[] args) {

		String str = "   hello    world   ";
		String k = "a";
		int len = lengthOflastWord(k);
		System.out.println(len);
		
	}

	private static int lengthOflastWord(String text) {

		if(text == null || text.length() == 0)
		{
			return 0;
		}
		
		text = text.trim();
		
		int len = text.length();
		int lastLength = 0;

	  
	    while(len > 0 && text.charAt(len-1)!=' '){
	        lastLength++;
	        len--;
	    }

	    return lastLength;		
	}

}

package Strings;

public class LC028_ReturnIndexOfString {

	public static void main(String[] args) {

		String needle = "abc";
		
		String haystack = "ewerlkkabc";
		
		int index = findNeedleInHayStack(needle , haystack);
		System.out.println(index);
		
	}

	private static int findNeedleInHayStack(String needle, String haystack) {
		
		if(needle.equals("")) return 0;
	    int N = needle.length();
	    int H = haystack.length();	    
	    
	    int scanLength = H-N;
	    
	    for(int i=0; i <= scanLength; i++) 
	    {
	    	String sub = haystack.substring(i,i+N);

	    	if(sub.equals(needle)) 
	    	{
	    		return i;
	    	}
	    }
	        
	    return -1;
		
	}

}

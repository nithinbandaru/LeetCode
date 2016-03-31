package Strings;

public class LC161_OneEditDistance {

	public static void main(String[] args) {

		String s = "aDc";
		String t = "aBc";
		
		boolean oneEdit = IsOneEditAway(s,t);
		System.out.println(oneEdit);
	}

	private static boolean IsOneEditAway(String s, String t) {

		if(Math.abs(s.length()-t.length()) > 1)
		{
			return false;
		}
		
		if(s.length()==t.length())
		{
			return canModifyByOne(s,t);
		}
		if(s.length() > t.length())
		{
			return canDeleteByOne(s,t);
		}
		
		return canDeleteByOne(t,s);
	}

	private static boolean canDeleteByOne(String s, String t) {

		for(int i = 0 , j = 0 ; i < s.length() && j < t.length() ; i++, j++)
		{
			if(s.charAt(i) != t.charAt(j))
			{
				return s.substring(i+1).equals(t.substring(j));
			}
		}		
		
		return true;
	}

	private static boolean canModifyByOne(String s, String t) {

		int charDiff = 0;
		
		for(int i = 0 ; i < s.length() ; i++)
		{
			if(s.charAt(i) != t.charAt(i))
			{
				charDiff++;
			}			
		}
				
		return (charDiff==1);
	}

}

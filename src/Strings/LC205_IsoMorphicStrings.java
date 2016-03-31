package Strings;

public class LC205_IsoMorphicStrings {

	public static void main(String[] args) {

		
		String s = "egg";
		String t = "add";
		
		boolean b = IsIsomorphic(s, t);
		System.out.println(b);
		
	}

	private static boolean IsIsomorphic(String s, String t) {

		int[] m1 = new int[26];
		int[] m2 = new int[26];
		int n = s.length();
		
        for (int i = 0; i < n; ++i) 
        {
            if (m1[s.charAt(i)-'a'] != m2[t.charAt(i)-'a']) 
            {
            	return false;
            }
            m1[s.charAt(i)-'a'] = i + 1;
            m2[t.charAt(i)-'a'] = i + 1;
        }
        return true;		
		
	}

}

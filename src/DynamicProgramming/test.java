package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class test {

	public static void main(String[] args) {

		String s = "snapchat";
		Set<String> dict = new HashSet<String>();
		dict.add("chat");
		//dict.add("snapchat");
		dict.add("snap");

		System.out.println(wordBreak(s,dict));
		
		for(String str : dict) {
			if(wordBreak(str, dict)) {
				System.out.println(str);
			}
		}
		
		
	}
	
	public static boolean wordBreak(String s, Set<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        //Second DP
        for(int i=1; i <= s.length(); i++)
        {
            for(int j=0; j < i; j++)
            {
            	String str = s.substring(j, i);
                if(f[j] && dict.contains(str))
                {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

}

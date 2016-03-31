package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LC139_WordBreak {

	public static void main(String[] args) {

		String s = "leetcode";
		ArrayList<String> dict = new ArrayList<String>();
		dict.add("chat");
		dict.add("ever");
		dict.add("snapchat");
		dict.add("snap");
		dict.add("salesperson");
		dict.add("per");
		dict.add("person");
		dict.add("sales");
		dict.add("son");
		dict.add("whatsoever");
		dict.add("what");
		dict.add("so");
		
		String[] arrayString = dict.toArray(new String[dict.size()]);
		
		String[] arrayStringOriginal = dict.toArray(new String[dict.size()]);
		
		Arrays.sort(arrayString,new Comparator<String>()
				{
			  public int compare(String s1,String s2)
			   {
			    return s1.length() - s2.length();
			    }
			});
		
		HashSet<String> results = new HashSet<String>();
		
		for(String str : arrayString) {
			if(!wordBreak(str, results)) {
				System.out.println(str);
				results.add(str);
			}
		}
		
		ArrayList<String> output = new ArrayList<String>();
		for(String str : arrayStringOriginal) {
			if(results.contains(str)) {
				output.add(str);
			}
		}
		
		System.out.println(output.toArray(new String[output.size()]));
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

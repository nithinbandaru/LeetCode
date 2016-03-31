package DynamicProgramming;

public class LC097_StringInterleaving {

	public static void main(String[] args) {

		String str1 = "XXYM";
        String str2 = "XXZT";
        String str3 = "XXXZXYTM";

		boolean interleaving = IsStringLeaving(str1.toCharArray(), str2.toCharArray(), str3.toCharArray());
		System.out.println(interleaving);
		
	}

	private static boolean IsStringLeaving(char[] s1, char[] s2, char[] s3) {

		boolean[][] T = new boolean[s1.length+1][s2.length+1];
		
		if(s1.length + s2.length != s3.length)
		{
			return false;
		}
		
		for(int i = 0; i < T.length; i++)
		{
			for(int j = 0; j < T[0].length; j++)
			{
				int k = i + j - 1;
				
				if(i == 0 && j == 0)
				{
					T[i][j] = true;
				}
				else if(i == 0)
				{
					if(s3[k] == s1[j-1])
					{
						T[i][j] = T[i][j-1];
					}
				}
				else if(j == 0)
				{
					if(s3[k] == s2[i-1])
					{
						T[i][j] = T[i-1][j];
					}
				}
				else
				{
					T[i][j] = (s3[k] == s1[j-1] ? T[i][j-1] : false) || 
							  (s3[k] == s2[i-1] ? T[i-1][j] : false);
				}
			}
		}
		
		return T[s1.length][s2.length];
	}

}

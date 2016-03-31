package DynamicProgramming;

public class LC091_DecodeNumberToAlphabets {

	public static void main(String[] args) {


		String msg = "123";
		
		int numWays = decodeNumberOfWays(msg);
		System.out.println(numWays);
		
	}

	private static int decodeNumberOfWays(String msg) {

		int len = msg.length();
		
		if(len == 0)
		{
			return 0;
		}
		
		int[] decodeCount = new int[len + 1];
		
		decodeCount[len] = 1;
		decodeCount[len-1] = (msg.charAt(len-1) == '0' ? 0 : 1);
		
		for(int i = len-2; i >= 0 ; i--)
		{
			if(msg.charAt(i) == '0')
			{
				continue;
			}
			else
			{
				int val = Integer.parseInt(msg.substring(i,i+2));
				
				if(val <= 26)
				{
					decodeCount[i] = decodeCount[i+1] + decodeCount[i+2]; 
				}
				else
				{
					decodeCount[i] = decodeCount[i+1];
				}
			}
		}
		
		return decodeCount[0];
	}

}

package DynamicProgramming;

public class LC045_MinimumJumpsToReachEndOfArray {

	public static void main(String[] args) {

		int[] A = { 5, 6, 0, 4, 2, 4, 1, 0, 0, 4};
		
		int[] B = {2, 1, 0, 0, 4};
		
		int minJumps = minJumpsToReachEndOfArray(A);
		System.out.println(minJumps);
		
		int[] result = whitePages(A);
		for(int i : result)
		{
			System.out.print(i + " ");
		}
		
		int j = result.length-1;
		StringBuilder buff = new StringBuilder();
        while(j > 0){
            buff.append(result[j]+",");
            j = result[j];
        }
		System.out.println(buff.reverse().append(",").append(result.length-1 + ",out").substring(1));
		
		
	}

	
	private static int[] whitePages(int[] A) {

		int len = A.length;
		
		if(len == 0 || A[0] == 0)
		{
			return null;
		}
		
		int[] result = new int[len];
		int[] jumps = new int[len];
		
		jumps[0] = 0;
		
		for(int i  = 1; i < len; i++)
		{
			jumps[i] = Integer.MAX_VALUE;
		}
		
		
		for(int i = 1; i < len; i++)
		{
			for(int j = 0; j < i; j++)
			{
				// can reach i from jth index
				if(j + A[j] >= i)
				{
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					result[i] = j;
					break;					
				}
			}
		}
		
		return result;
	}
	
	
	
	private static int minJumps  (int[] A) {

		if(A.length <= 1 || A[0] == 0)
		{
			return 0;
		}
		
		int ladder = A[0]; // keep track of largest ladder u have
		int stairs = A[0]; // keep track of stairs in current ladder
		
		int jump = 1;
		
		for(int level = 1;  level < A.length ; level++)
		{
			if(level == A.length-1)
			{
				return jump;
			}
			
			if(level + A[level] > ladder)
			{
				ladder = level + A[level]; // build up the ladder
			}
			
			stairs--;
			
			if(stairs == 0)
			{
				jump++; // no stairs left, jump now
				stairs = ladder - level; // get new set of stairs
			}
		}
		
		return jump;
	}


	
	private static int minJumpsToReachEndOfArray(int[] A) {

		int len = A.length;
		
		if(len == 0 || A[0] == 0)
		{
			return Integer.MAX_VALUE;
		}
		
		int[] result = new int[len];
		int[] jumps = new int[len];
		
		jumps[0] = 0;
		
		for(int i  = 1; i < len; i++)
		{
			jumps[i] = Integer.MAX_VALUE;
		}
		
		
		for(int i = 1; i < len; i++)
		{
			for(int j = 0; j < i; j++)
			{
				// can reach i from jth index
				if(j + A[j] >= i)
				{
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					result[i] = j;
					break;					
				}
			}
		}
		
		int j = len-1;
        while(j > 0){
            System.out.print(result[j] + "->");
            j = result[j];
        }
		System.out.println();
		return jumps[len-1];
	}

}

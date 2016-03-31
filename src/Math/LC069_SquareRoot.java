package Math;

public class LC069_SquareRoot {

	public static void main(String[] args) {

		int num = 28;
		
		int sqrt = squareRoot(num);
		System.out.println(sqrt);
		
	}

	private static int squareRoot(int num) {

		if(num == 0 || num == 1)
		{
			return num;
		}
		
		int left = 1 ;
		int right = num;
		int ans = 0;
		
		while(left <= right)
		{
			int mid = left + ( right - left)/2;
			
			if(mid <= num/mid)
			{
				left = mid + 1;
				ans = mid;
			}
			else
			{
				right = mid -1 ;
			}
			
		}
		
		return ans;
	}

}

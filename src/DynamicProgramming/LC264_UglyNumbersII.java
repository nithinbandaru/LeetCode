package DynamicProgramming;

public class LC264_UglyNumbersII {

	public static void main(String[] args) {

		int num = 10;
		
		int uglyNum = NthUglyNumber(num);
		
		System.out.println(uglyNum);
	}

	private static int NthUglyNumber(int num) {

		int[] ugly = new int[num];
		
		ugly[0] = 1;
		
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		int next_multiple_of_2 = ugly[i2] * 2;
		int next_multiple_of_3 = ugly[i3] * 3;
		int next_multiple_of_5 = ugly[i5] * 5;
		
		int nextUglyNum = 1;
		
		for(int i = 1; i < num ; i++)
		{
			nextUglyNum = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));
			
			ugly[i] = nextUglyNum;
			
			if(nextUglyNum == next_multiple_of_2)
			{
				i2 = i2 + 1;
				next_multiple_of_2 = ugly[i2] * 2;
			}
			
			if(nextUglyNum == next_multiple_of_3)
			{
				i3 = i3 + 1;
				next_multiple_of_3 = ugly[i3] * 3;
			}
			
			if(nextUglyNum == next_multiple_of_5)
			{
				i5 = i5 + 1;
				next_multiple_of_5 = ugly[i5] * 5;
			}
			
		}
		
		return nextUglyNum;
	}

}

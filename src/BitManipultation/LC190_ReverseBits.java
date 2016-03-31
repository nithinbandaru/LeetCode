package BitManipultation;

public class LC190_ReverseBits {

	public static void main(String[] args) {

		int num = 43261596 ;
		
		int revNum = reverseBits(num);
		System.out.println(revNum);
		
	}

	private static int reverseBits(int num) {

		int revNum = 0;
		
		for(int i = 0 ; i < 32; i++)
		{
			revNum = revNum + (num & 1); // get the last digit and add to revNum
			num = num >>> 1; // do unsigned shift
			
			if(i  < 31)
			{
				revNum = revNum << 1;
			}
		}
		
		return revNum;
	}

}

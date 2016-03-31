package Math;

public class LC191_CountNumberOfBits {

	public static void main(String[] args) {

		int num = 7;
		
		int ones = countOnes(num);
		System.out.println("Num Of Ones: " +ones);
		
	}

	private static int countOnes(int num) {

		int ones = 0;
		
		while(num != 0)
		{   
			ones = ones + (num & 1);
			num = num >>> 1;
		}
		
		return ones;
	}

}

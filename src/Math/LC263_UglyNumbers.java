package Math;

public class LC263_UglyNumbers {

	public static void main(String[] args) {

		int num = 14 ;
		
		boolean ugly = IsUgly(num);
		
		System.out.println("Ugly Numbers: " + ugly);
	}

	private static boolean IsUgly(int num) {

		if(num > 0)
		{	
			for( int i = 2 ; i < 6 ; i++)
			{
				while( num % i == 0)
				{
					num = num / i;
				}
			}
		}
		
		return (num == 1);
	}

}

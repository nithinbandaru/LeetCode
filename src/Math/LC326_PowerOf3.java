package Math;

public class LC326_PowerOf3 {

	public static void main(String[] args) {

		int num = 246;
		
		boolean pow3 = IsPowerofThree(num);
		
		System.out.println(pow3);
		
		boolean powLog3 = IsPowerofThreeWithLogs(num);
		System.out.println(powLog3);
	}

	private static boolean IsPowerofThreeWithLogs(int num) {
		
		double dividend = Math.log10(num);
		double divisor = Math.log10(3);
		
		double quotient = dividend / divisor ;
		
		if(quotient % 1 == 0)
		{
			return true;
		}
		
		return false;
	}

	private static boolean IsPowerofThree(int num) {

		if(num > 0)
		{
			while(num % 3 == 0)
			{
				num = num / 3;
			}
		}
		
		return (num == 1);
	}

}

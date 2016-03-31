package Math;

public class Factorial {

	public static void main(String[] args) {

		int num = 6;
		
		int fact = factorialRecursive(num);
		System.out.println(fact);
		
	}

	private static int factorialRecursive(int num) {

		if(num == 0)
		{
			return 1;
		}
		
		return  num * factorialRecursive(num-1);
	}

}

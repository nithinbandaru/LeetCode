package Math;

public class AddWithOutOperator {

	public static void main(String[] args) {

		
		int x = 5;
		int y = 3;
		
		int sum = add(x, y);
		System.out.println(sum);
	}

	private static int add(int x, int y) {

		while(y != 0)
		{
			int carry = x & y;
			
			x = x ^ y;
			
			y = carry << 1;
		}
				
		return x;
	}

}

package Math;

public class AddTwoStringNumbers {

	public static void main(String[] args) {

		String num1 = "1234";
		String num2 = "100";
		
		String sum = add(num1, num2);
		
		System.out.println(sum);
		
	}

	private static String add(String num1, String num2) {

		int i = num1.length()-1;
		int j = num2.length()-1;
		
		StringBuilder result = new StringBuilder();
		
		int carry = 0;
		
		while(i >=0 || j >=0 || carry != 0)
		{
			int digit1 =  i < 0 ? 0 : Integer.parseInt(Character.toString(num1.charAt(i)));
			int digit2 =  j < 0 ? 0 : Integer.parseInt(Character.toString(num2.charAt(j)));
			
			int sum = digit1 + digit2 + carry;
			carry = sum / 10;
			result.append(sum%10);
			i--;
			j--;			
		}
		
		return result.reverse().toString();
	}

}

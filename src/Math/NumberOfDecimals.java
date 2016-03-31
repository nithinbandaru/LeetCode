package Math;

public class NumberOfDecimals {

	public static void main(String[] args) {

		double num = 542.3784577707;
		
		int count = countDecimals(num);
		
		System.out.println("Num of decimals : " + count);
	}

	private static int countDecimals(double num) {

		String str = Double.toString(num);
		
		System.out.println(str);
		int len = str.length();
		
		int index = str.indexOf(".");
		
		return (len-index-1);
	}

}

package Strings;

public class LC006_ZigZagConversion {

	/*
	If n is the size of the string and m is the numRows, the solution is O(n+m). 
	It takes O(m) to create the StringBuffer array and then traversing the String s takes O(n). 
	Putting the solution together is O(m), so overall the runtime is O(n+m)
	*/
	public static void main(String[] args) {

		String text = "PAYPALISHIRING";
		
		String zigzag = convertToZigZag(text , 4);
		
		System.out.println(zigzag);
	}

	private static String convertToZigZag(String text, int numRows) {
		
		char[] charsInText = text.toCharArray();
		
		int lenString = text.length();
		
		// create a array stringbuilder to save string in each row
		
		StringBuilder[] buff = new StringBuilder[numRows];
		
		// create objects of StringBuilder
		
		for(int i=0; i < buff.length ; i++)
		{
			buff[i] = new StringBuilder();
		}
		
		int i = 0;
		
		while(i < lenString)
		{
			// vertically down characters
			
			for(int j = 0 ; j < numRows && i  < lenString; j++)
			{
				buff[j].append(charsInText[i++]);
				
			}
			
			// obliquely up characters
			
			for(int j = numRows - 2 ; j >= 1 && i  < lenString ; j--)
			{
				buff[j].append(charsInText[i++]);
				
			}
		}
		
		for(int k = 1 ;  k < numRows ; k++)
		{
			buff[0].append(buff[k]);
		}
		
		
		return buff[0].toString();
		
	}

}

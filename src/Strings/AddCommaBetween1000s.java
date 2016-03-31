package Strings;

public class AddCommaBetween1000s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String num = "1000000";
		
		String newNum = addCommas(num);
		System.out.println(newNum);
	}

	private static String addCommas(String num) {

		//String buff = new String();
		StringBuilder buff = new StringBuilder();
		
		int numLength = num.length();
		
        for (int i=0; i<numLength; i++) 
        { 
            if ((numLength-i)%3 == 0 && i != 0) 
            {
            	//buff += ",";
            	buff.append(",");
            }
           // buff += num.charAt(i);
            buff.append(num.charAt(i));
        }

		
		
		return buff.toString();
	}

}

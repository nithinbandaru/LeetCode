package Math;

public class LC273_IntegerToEnglishWords {

	private static final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private static final String[] thousands = {"", "Thousand", "Million", "Billion"};

	public static void main(String[] args) {

		int num = 7821989;
		
		String word = numberToWords(num);
		System.out.println(word);
	}

	
	public static String numberToWords(int num) {
	    if (num == 0)
	        return "Zero";
	    int i = 0;
	    String words = "";

	    while (num > 0) {
	        if (num % 1000 != 0)
	            words = numberToWordsUtil(num % 1000) + thousands[i] + " " + words;
	        num /= 1000;
	        i++;
	    }

	    return words.trim();
	}

	private static String numberToWordsUtil(int num) {
	    if (num == 0)
	        return "";
	    else if (num < 20)
	        return lessThan20[num] + " ";
	    else if (num < 100)
	        return tens[num / 10] + " " + numberToWordsUtil(num % 10);
	    else
	        return lessThan20[num / 100] + " Hundred " + numberToWordsUtil(num % 100);
	}
	
}

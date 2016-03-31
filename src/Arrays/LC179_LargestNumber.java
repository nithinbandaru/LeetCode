package Arrays;

import java.util.Arrays;
import java.util.Comparator;
public class LC179_LargestNumber {

	public static void main(String[] args) {

		int[] nums = {3, 30, 34, 5, 9};
		
		String num = largestNumber(nums);
		System.out.println(num);
		
	}
	
	public static String largestNumber(int[] nums) 
	{
	    String[] numbers = new String[nums.length];
	    
	    for(int i = 0; i < nums.length; i++)
	    {
	    	numbers[i] = String.valueOf(nums[i]);
	    }
	    
	    System.out.println(Arrays.toString(numbers));
	    
	    Arrays.sort(numbers, new Comparator<String>(){
	       
	    	public int compare(String s1, String s2){
	            String leftRight = s1+s2;
	            String rightLeft = s2+s1;

	            return rightLeft.compareTo(leftRight);
	        }
	    });
	 
	    System.out.println(Arrays.toString(numbers));
	    
	    StringBuilder largestNumber = new StringBuilder();
	    
	    for(String num: numbers)
	    {
	    	largestNumber.append(num);
	    }
	 
	    while(largestNumber.charAt(0)=='0' && largestNumber.length()>1)
	    {
	    	largestNumber.deleteCharAt(0);
	    }
	 
	    return largestNumber.toString();
	}


}

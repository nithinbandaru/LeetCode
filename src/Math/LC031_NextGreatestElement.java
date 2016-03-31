package Math;

public class LC031_NextGreatestElement {

	// Time Complexity O(n)
	public static void main(String[] args) {
		
		int[] num = { 5, 3 , 4, 9, 6, 1 } ;
		
		int[] nextGreatNum = nextGreatestNumber(num);
		
		for(int i : nextGreatNum)
		{
			System.out.print(i);
		}
		
		
	}

	private static int[] nextGreatestNumber(int[] num) {

		int len = num.length;
		if(len < 2)
		{
			return num;
		}
		
		int index = len - 1;
		// Traverse the given number from rightmost digit, 
		// keep traversing till you find a digit which is smaller than the previously traversed digit.
		while(index > 0)
		{
			if(num[index-1] < num[index])
			{
				break;
			}
			index--;
		}
		
		// If all digits sorted in descending order, then output revere sorted number
		if(index == 0)
		{
			reverseSort(num , 0 , len-1);
			return num;
		}
		else
		{
			// Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’.
			int val = num[index-1];
			
			int j = len - 1;
			
			while(j >= index)
			{
				if(num[j] > val)
				{
					break;
				}
				j--;
			}
			// Swap the above found two digits
			int temp = num[index-1];
			num[index-1] = num[j];
			num[j] = temp;
			// Now sort all digits from position next to ‘d’ to the end of number
			reverseSort(num , index , len - 1);
			
		}
		
		return num;
	}

	private static void reverseSort(int[] num, int start, int end) {

		while(start < end)
		{
			int temp = num[start];
			num[start] = num[end];
			num[end] = temp;
			start++;
			end--;
		}		
		
	}

}

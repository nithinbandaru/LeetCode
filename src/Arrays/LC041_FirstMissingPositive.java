package Arrays;

public class LC041_FirstMissingPositive {

	public static void main(String[] args) {

		int[] A = { 3, 4, -1, 1 };
		
		int num = firstMissingPositive(A);
		System.out.println(num);		
		
	}

	private static int firstMissingPositive(int[] A) {

		int len = A.length;
		
		for(int i = 0 ; i < len ; i++)
		{
			int num = A[i];
			
			while(num <= len && num > 0 && A[num-1] != num)
			{
				int temp = A[i];
				A[i] = A[num-1];
				A[num-1] = temp;
				num = A[i];
			}
		}
		
		for(int i = 0 ; i < len ; i++)
		{
			if(A[i] != i+1)
			{
				return i+1;
			}
		}
				
		return len+1;
	}

}

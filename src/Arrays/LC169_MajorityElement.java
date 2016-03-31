package Arrays;

public class LC169_MajorityElement {

	public static void main(String[] args) {

		int[] arr  = {3 ,3 , 6 ,4, 4 ,4 ,2 ,4 ,4};
		
		Integer majorityElement = getMajorityElement(arr);
		System.out.println("Majority Element : " + majorityElement);
				
	}

	private static Integer getMajorityElement(int[] A) {

		// 1. select the majority candidate
		Integer candidate = null;
		
		int count = 0;
		for(int i = 0 ; i < A.length ; i++)
		{
			if(count == 0)
			{
				candidate = A[i];
				count = 1;
				continue;
			}
			else
			{
				if(candidate == A[i])
				{
					count++;
				}
				else
				{
					count--;
				}
			}
		}
		
		if(count==0)
		{
			return null;
		}
		
		// 2. Check if its the majority candidate
		count = 0 ;
		
		for(int i=0 ; i < A.length ; i++)
		{
			if(candidate == A[i])
			{
				count++;
			}
		}
		
		if(count > A.length / 2)
		{
			return candidate;
		}
		
		return null;
	}

}

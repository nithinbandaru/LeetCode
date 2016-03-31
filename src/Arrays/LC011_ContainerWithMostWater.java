package Arrays;

public class LC011_ContainerWithMostWater {

	public static void main(String[] args) {

		
		int[] containerHeights = { 1, 5 ,4 , 3 } ;
		
		int water = maxAreaOfWater(containerHeights);
		System.out.println(water);
		
	}

	private static int maxAreaOfWater(int[] A) {

		int left = 0;
		int right = A.length - 1;
		
		int area = 0;
		int maxArea = 0;
		
		while(left < right)
		{
			int minHtContainer = Math.min(A[left], A[right]);
			area = minHtContainer * (right - left);
			maxArea = Math.max(area, maxArea);
			
			if(A[left] < A[right])
			{
				left++;
			}
			else
			{
				right--;
			}
		}
		
		return maxArea;
	}

}

package Arrays;

import java.util.Arrays;

public class FisherYateShuffleAlgorithm {

	public static void main(String[] args) {

		
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8};
		
		shuffleArray(A);
		
 		System.out.println(Arrays.toString(A));
	}


	private static void shuffleArray(int[] A) {
		
		int index = A.length - 1;
		
		for(int i = index ; i> 0 ; i--)
		{
			int randIndex = (int) (Math.random() * index) ;
			//System.out.println(randIndex);
			int temp = A[randIndex];
			A[randIndex] = A[i];
			A[i] = temp;
			
		}
	}

}

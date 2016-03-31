package Trees;

public class LC096_CountUniqueBST {

	public static void main(String[] args) {

		int numKeys = 5;
		
		int count = countUniqueBST(numKeys);
		System.out.println(count);
		
	}

	private static int countUniqueBST(int numKeys) {

		int[] BSTCount = new int[numKeys+1];
		
		BSTCount[0] = 1;
		BSTCount[1] = 1;
		
		for(int i = 2; i <= numKeys; i++)
		{
			for(int j = 0; j < i; j++)
			{
				BSTCount[i] = BSTCount[i] + BSTCount[j] * BSTCount[i-j-1];
			}
		}		
		
		return BSTCount[numKeys];
	}

}

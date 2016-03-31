package Arrays;

public class LC243_ShortestWordDistanceI {

	public static void main(String[] args) {

		
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		int distance = minDistanceBetweenWords(words, "coding" , "makes");
		
		System.out.println(distance);
	}

	private static int minDistanceBetweenWords(String[] words, String word1,
			String word2) {

		int index1 = -1 ; 
		int index2 = -1 ;
		
		int minDist = Integer.MAX_VALUE;
		
		for(int i=0; i < words.length;i++)
		{
			if(words[i].equals(word1))
			{
				index1 = i;
			}
			
			if(words[i].equals(word2))
			{
				index2 = i;
			}
			
			if(index1 != -1 && index2 != -1)
			{
				minDist = Math.min(minDist, Math.abs(index1 - index2));
			}
		}
		
		return minDist;
	}

}

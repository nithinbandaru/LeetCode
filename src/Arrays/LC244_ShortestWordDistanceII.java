package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC244_ShortestWordDistanceII {

	public static void main(String[] args) {

		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		String word1 = "coding";
		String word2 = "makes";
		
		int minDist = ShortestDistanceBetweenWordsII(words, word1, word2);
		System.out.println(minDist);
		
	}

	private static int ShortestDistanceBetweenWordsII(String[] words,
			String word1, String word2) {

		HashMap<String, List<Integer>> wordAndItsIndicesList = getIndicesList(words);
		
		List<Integer> word1List = wordAndItsIndicesList.get(word1);
		List<Integer> word2List = wordAndItsIndicesList.get(word2);
		
		int minDist = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		System.out.println(word1List);
		System.out.println(word2List);
		while(i < word1List.size() && j < word2List.size())
		{
			int index1 = word1List.get(i);			
			int index2 = word2List.get(j);
			
			if(index1 < index2)
			{
				minDist = Math.min(minDist, index2 - index1);	
				i++;
			}
			else
			{
				minDist = Math.min(minDist, index1 - index2);	
				j++;
			}
		}
		
		return minDist;
	}

	private static HashMap<String, List<Integer>> getIndicesList(String[] words) {

		HashMap<String, List<Integer>> wordAndItsIndicesList = new HashMap<String, List<Integer>>();
		
		for(int i = 0 ; i < words.length ; i++)
		{
			String w = words[i];
			
			if(wordAndItsIndicesList.containsKey(w))
			{
				wordAndItsIndicesList.get(w).add(i);
			}
			else
			{
				List<Integer> indicesList = new ArrayList<Integer>();
				indicesList.add(i);
				wordAndItsIndicesList.put(w, indicesList);
			}			
		}
		
		return wordAndItsIndicesList;
	}

}

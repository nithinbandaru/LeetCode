package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC187_RepeatedDNASequences {

	private static final Map<Character, Integer> encodings = new HashMap<Character,Integer>();
	
	static
	{
		encodings.put('A', 1);
		encodings.put('C', 2);
		encodings.put('G', 3);
		encodings.put('T', 4);
	}
	
	private static final int TWO_POW_9 = (int) Math.pow(2, 9);
	
	public static void main(String[] args) {

		String dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		
		String dna2 = "ACCCTCCCACTTGGATGCCGCACGTGTCGACTAACCTTACATTGTCCCCCCACCTCCAGACGGTTAACTCTTGAAATGGGGGAATAGCTGCTTGCGCGTG";
		
		List<String> dnaSeq = repeatedDNASequences(dna2);
		
		System.out.println(dnaSeq);
	}

	private static List<String> repeatedDNASequences(String dna) {

		int rollingHash = 0;
		
		Set<Integer> rollingHashesList = new HashSet<Integer>();
		Set<String> repeatDNASeq = new HashSet<String>();
		
		for(int i = 0; i < dna.length(); i++)
		{
			if(i > 9)
			{
				rollingHash = rollingHash - TWO_POW_9 * encodings.get(dna.charAt(i-10));
			}
			rollingHash = 2 * rollingHash + encodings.get(dna.charAt(i));
			
			if(i > 8)
			{
				if(!rollingHashesList.contains(rollingHash))
				{
					rollingHashesList.add(rollingHash);
				}
				else
				{
					repeatDNASeq.add(dna.substring(i-9, i+1));
				}
			}
		}
		
		return new ArrayList<>(repeatDNASeq);
	}

}

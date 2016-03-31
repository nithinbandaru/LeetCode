package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC046_PermutationOfArrays {

	public static void main(String[] args) {

		int[] A = {1 , 2 , 3 };
		
		List<List<Integer>> permutations = generatePermutations(A);
		
		for(List<Integer> p : permutations)
		{
			System.out.println(p);
		}
		
	}

	private static List<List<Integer>> generatePermutations(int[] A) {

		Queue<List<Integer>> res = new LinkedList<List<Integer>>();
	    res.add(new ArrayList<Integer>());
	    
	    for (int n : A) 
	    {
	        int size = res.size();
	        
	        for (; size > 0; size--) 
	        {
	            List<Integer> r = res.poll();
	            
	            for (int i = 0; i <= r.size(); i++)
	            {
	                List<Integer> t = new ArrayList<Integer>(r);
	                t.add(i, n);
	                res.add(t);
	            }
	        }
	    }
	    
	    List<List<Integer>> permutations = new ArrayList<List<Integer>>();
	    
	    permutations.addAll(res);		
		
		return permutations;
	}

}

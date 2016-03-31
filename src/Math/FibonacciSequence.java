package Math;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {

	public static void main(String[] args) {

		int num = 6;
		
		List<Integer> fibSeq = fibonacciIterative(num);
		
		System.out.println(fibSeq);
		
		int nthFib = fibonacciRecursive(num);
		System.out.println(nthFib);
		
	}

	// Time Complexity = O(2^n)
	private static int fibonacciRecursive(int num) {

		if(num <= 1)
		{
			return num;
		}
				
		return fibonacciRecursive(num-1) + fibonacciRecursive(num-2);
	}
	
	// Time Complexity = O(n)

	private static List<Integer> fibonacciIterative(int num) {

		List<Integer> fibSeq = new ArrayList<Integer>();
		
		int f1 = 0;
		int f2 = 1;
		
		fibSeq.add(f1);	
		fibSeq.add(f2);
		
		if(num <= 1)
		{
			return fibSeq;
		}
		
		int nthFib = 0;
		
		for(int i = 2;  i <= num ; i++)
		{
			nthFib = f1 + f2;
			fibSeq.add(nthFib);
			f1 = f2;
			f2 = nthFib;
		}
		
		return fibSeq;
	}

}

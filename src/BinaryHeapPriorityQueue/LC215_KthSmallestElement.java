package BinaryHeapPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC215_KthSmallestElement {

	public static void main(String[] args) {

		int[] A = {3,2,1,5,6,4};
		// Use Max Heap  
		int smallestElement = KthSmallestElement(A, 2);
		System.out.println(smallestElement);
		
	}

	private static int KthSmallestElement(int[] A, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int val : A)
		{
			pq.offer(val);
			
			if(pq.size() > k)
			{
				pq.poll();
			}
		}
		
		return pq.peek();
	}

}

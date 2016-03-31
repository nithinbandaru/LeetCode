package BinaryHeapPriorityQueue;

import java.util.PriorityQueue;

public class LC215_KthLargestElement {

	public static void main(String[] args) {

		int[] A = {3,2,1,5,6,4};
		// Use Min Heap By Default
		int largestElement = KthLargestElement(A, 2);
		System.out.println(largestElement);
	}

	private static int KthLargestElement(int[] A , int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

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

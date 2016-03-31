package Design;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/discuss/64811/easy-to-understand-double-heap-solution-in-java
// Time complexity = O(logn) for insertion
public class LC295_MedianFromDataStream {

	private PriorityQueue<Integer> minHeap; // stores larger half of elements
	private PriorityQueue<Integer> maxHeap; // smaller half of elements
	
	public LC295_MedianFromDataStream()
	{
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}
	
	public void addNum(int num)
	{
		// case 1: if both heaps are empty
		if(minHeap.size() == 0 && maxHeap.size() == 0)
		{
			minHeap.offer(num);
		}
		else if( minHeap.size() > maxHeap.size())
		{
		
			if(num > minHeap.peek())
			{
				maxHeap.offer(minHeap.poll());
				minHeap.offer(num);
			}
			else
			{
				maxHeap.offer(num);
			}
			
		}
		else if( minHeap.size() < maxHeap.size())
		{
			if(num < maxHeap.peek())
			{
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(num);
			}
			else
			{
				minHeap.offer(num);
			}
		}
		else // both sizes are equal
		{
			if(num < maxHeap.peek())
			{
				maxHeap.offer(num);
			}
			else
			{
				minHeap.offer(num);
			}
		}
		
	}
	
	public double findMedian()
	{
		if(minHeap.size() == 0 && maxHeap.size()==0)
		{
			return 0.0;
		}
		if(minHeap.size() > maxHeap.size())
		{
			return (double)(minHeap.peek());
		}
		if(maxHeap.size() > minHeap.size())
		{
			return (double)(maxHeap.peek());
		}
		
		return (double)((minHeap.peek() + maxHeap.peek())/2.0) ;
	}
	
	
	public static void main(String[] args) {

		LC295_MedianFromDataStream streamMedian = new LC295_MedianFromDataStream();
		
		streamMedian.addNum(1);
		System.out.println(streamMedian.findMedian()); // should be 1
		
		streamMedian.addNum(2);
		System.out.println(streamMedian.findMedian()); // should be 5
		
		streamMedian.addNum(3);
		System.out.println(streamMedian.findMedian()); // should be 5
		
		streamMedian.addNum(4);
		System.out.println(streamMedian.findMedian()); // should be 7.5
		
		streamMedian.addNum(5);
		System.out.println(streamMedian.findMedian()); // should be 5
		
		streamMedian.addNum(6);
		System.out.println(streamMedian.findMedian()); // should be 5
		
		streamMedian.addNum(7);
		streamMedian.addNum(8);
		System.out.println(streamMedian.findMedian()); // should be 6.5

		streamMedian.addNum(9);
		streamMedian.addNum(10);
		System.out.println(streamMedian.findMedian()); // should be 6.5
		
	}

}

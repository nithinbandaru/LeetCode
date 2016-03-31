package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC253_NumberOfConferenceRoomsRequired {

	public static void main(String[] args) {

		LC253_NumberOfConferenceRoomsRequired meetings = new LC253_NumberOfConferenceRoomsRequired();		
		
		Interval[]  intervals = new Interval[3];
		for(int i = 0 ; i < intervals.length ; i++)
		{
			intervals[i] = new Interval();
		}
		intervals[0].start = 0;
		intervals[0].end = 30;
		intervals[1].start = 5;
		intervals[1].end = 10;
		intervals[2].start = 15;
		intervals[2].end = 20;
		
		int numRooms = numberOfConferenceRoomsRequired(intervals);
		System.out.println(numRooms);
	}
	
	 private static int numberOfConferenceRoomsRequired(Interval[] intervals) {
		 
		 int numRooms = 0;
		 
		 if(intervals == null || intervals.length == 0)
		 {
			 return 0;
		 }
		 
		 // sort intervals by start time
		 
		 Arrays.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval a, Interval b) {
				
				return (a.start - b.start);				
				
			}
		 });
		 
		 // keep min heap to keep track of min end times
		 
		 PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){

			@Override
			public int compare(Interval a, Interval b) {
				
				return a.end-b.end;
			}
			 
		 });
		 
		 pq.offer(intervals[0]);
		 
		 for(int i = 1; i < intervals.length; i++)
		 {
			 Interval interval = pq.poll();
			 
			 if(intervals[i].start >= interval.end)
			 {
				 interval.end = intervals[i].end;
			 }
			 else
			 {
				 pq.offer(intervals[i]);
			 }
			 
			 pq.offer(interval);
		 }
		 
		 numRooms = pq.size();
		 
		 return numRooms;
	 }

	// Definition for an interval.
	 public static class Interval 
	 {
	      int start;
	      int end;
	      Interval() 
	      { 
	    	  start = 0; 
	    	  end = 0; 
	      }
	      Interval(int s, int e) 
	      { 
	    	  start = s; 
	    	  end = e; 
	      }
	  }
	 

}

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LC057_InsertAndMergeIntervals {

	public static void main(String[] args) {

		Interval[]  intervals = new Interval[5];
		for(int i = 0 ; i < intervals.length ; i++)
		{
			intervals[i] = new Interval();
		}
		intervals[0].start = 1;
		intervals[0].end = 2;
		intervals[1].start = 3;
		intervals[1].end = 5;
		intervals[2].start = 6;
		intervals[2].end = 7;
		intervals[3].start = 8;
		intervals[3].end = 10;
		intervals[4].start = 12;
		intervals[4].end = 16;
		
		Interval newInterval = new Interval(4,9);
		
		
		List<Interval> merge = insertAndMergeIntervals(intervals, newInterval);
		
		for(Interval i : merge)
		{
			System.out.println(i.start + "," + i.end);
		}
		
		
	}
	
	 private static List<Interval> insertAndMergeIntervals(Interval[] intervals,
			Interval newInterval) {

		 List<Interval> result = new ArrayList<Interval>();
		 
		 int i = 0;
		 
		 // find where overlapping starts
		 
		 while( i < intervals.length && intervals[i].end <= newInterval.start)
		 {
			 result.add(intervals[i]);
			 i++;
		 }
		 
		 while( i < intervals.length && intervals[i].start <= newInterval.end)
		 {
			 newInterval = new Interval(Math.min(newInterval.start, intervals[i].start) ,
					 					Math.max(newInterval.end, intervals[i].end));
			 i++;
		 }
		 
		 result.add(newInterval);
		 
		 while(i < intervals.length)
		 {
			 result.add(intervals[i]);
			 i++;
		 }
		 
		 return result;
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

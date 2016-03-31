package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC056_MergeIntervals {

	public static void main(String[] args) {

		Interval[]  intervals = new Interval[4];
		for(int i = 0 ; i < intervals.length ; i++)
		{
			intervals[i] = new Interval();
		}
		intervals[0].start = 1;
		intervals[0].end = 3;
		intervals[1].start = 2;
		intervals[1].end = 6;
		intervals[2].start = 8;
		intervals[2].end = 10;
		intervals[3].start = 15;
		intervals[3].end = 18;
		
		
		
		List<Interval> merge = mergeIntervals(intervals);
		
		for(Interval i : merge)
		{
			System.out.println(i.start + "," + i.end);
		}
		
		
	}
	
	 private static List<Interval> mergeIntervals(Interval[] intervals) {

		 if(intervals.length <= 1)
		 {
			 return Arrays.asList(intervals);
		 }
		 
		 // sort by ascending start times
		 
		 Arrays.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval a, Interval b) {
				return (a.start - b.start);				
			}			 
		 });
		 
		 List<Interval> result = new ArrayList<Interval>();
		 
		 int start = intervals[0].start;
		 int end = intervals[0].end;
		 		 
		 for(int i = 1 ; i < intervals.length ; i++)
		 {
			 if(intervals[i].start < end) // implies overlapping interval
			 {
				 end = Math.max(intervals[i].end, end);
			 }
			 else
			 {
				 result.add(new Interval(start, end));
				 start = intervals[i].start;
				 end = intervals[i].end;
			 }
		 }
		 
		 // Add the last interval
		 result.add(new Interval(start, end));
		 
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

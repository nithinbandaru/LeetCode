package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LC252_CanAttendAllMeetings {

	public static void main(String[] args) {

		LC252_CanAttendAllMeetings meetings = new LC252_CanAttendAllMeetings();		
		
		Interval[]  intervals = new Interval[3];
		for(int i = 0 ; i < intervals.length ; i++)
		{
			intervals[i] = new Interval();
		}
		intervals[0].start = 0;
		intervals[0].end = 3;
		intervals[1].start = 5;
		intervals[1].end = 10;
		intervals[2].start = 15;
		intervals[2].end = 20;
		
		boolean canAttend = CanAttendAllMeetings(intervals);
		System.out.println(canAttend);
	}
	
	 private static boolean CanAttendAllMeetings(Interval[] intervals) {

		 if(intervals == null)
		 {
			 return false;
		 }
		 
		 Arrays.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval a, Interval b) {
				return (a.start - b.start);				
			}			 
		 });
		 
		 for(int i = 1 ; i < intervals.length ; i++)
		 {
			 if(intervals[i].start < intervals[i-1].end)
			 {
				 return false;
			 }
		 }
		 
		 return true;
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

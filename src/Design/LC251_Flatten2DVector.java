package Design;

import java.util.*;

public class LC251_Flatten2DVector {
	
	Queue<Iterator<Integer>> itrQueue;
	Iterator<Integer> currItr;
	
	public LC251_Flatten2DVector(List<List<Integer>> list2D)
	{
		itrQueue = new LinkedList<Iterator<Integer>>();
		
		for(int i = 0; i < list2D.size(); i++)
		{
			itrQueue.add(list2D.get(i).iterator());
		}
		
		currItr = itrQueue.poll();
	}
	
	public int next()
	{
		if(currItr.hasNext())
		{
			return currItr.next();
		}
		
		return -1;
	}

	public boolean hasNext()
	{
		if(currItr == null)
		{
			return false;
		}
		
		while(!currItr.hasNext())
		{
			if(!itrQueue.isEmpty())
			{
				currItr = itrQueue.poll();
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {

		List<List<Integer>> list2D = new ArrayList<List<Integer>>();
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);		

		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);		

		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(5);
		l3.add(6);
		l3.add(7);
		
		list2D.add(l1);
		list2D.add(l2);
		list2D.add(l3);
		
		LC251_Flatten2DVector flattenItr = new LC251_Flatten2DVector(list2D);
		
		while(flattenItr.hasNext())
		{
			System.out.print(flattenItr.next() + " ");
		}
		
	}

}

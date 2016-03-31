 package Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LC281_ZigzagIterator {

	private Iterator<Integer> i, j, temp;
	
	public LC281_ZigzagIterator(List<Integer> l1, List<Integer> l2)
	{
		j = l1.iterator();
		i = l2.iterator();
	}
	
	public boolean hasNext()
	{
		return i.hasNext() || j.hasNext();
	}
	
	public int next()
	{
		if(j.hasNext())
		{
			temp = j;
			j = i;
			i = temp;
		}
		
		return (int) i.next();
	}
	
	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(4);
		l2.add(5);
		l2.add(6);
		l2.add(7);
		
		LC281_ZigzagIterator itr = new LC281_ZigzagIterator(l1, l2);
		
		while(itr.hasNext())
		{
			System.out.print(itr.next() + " ");
		}
		
	}

}

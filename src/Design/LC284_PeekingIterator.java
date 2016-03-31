package Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LC284_PeekingIterator implements Iterator<Integer> {

	private Iterator<Integer> itr;
	private Integer next = null;
	
	public LC284_PeekingIterator(Iterator<Integer> iterator)
	{
		itr = iterator;
		if(itr.hasNext())
		{
			next = itr.next();
		}
	}
	
	public int peek()
	{
		return next;
	}
	
	@Override
	public boolean hasNext() {
				
		return next != null;
	}

	@Override
	public Integer next() {

		Integer result = next;		
		next = itr.hasNext() ? itr.next() : null;		
		return result;
	}

	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		
		LC284_PeekingIterator peekingItr = new LC284_PeekingIterator(l1.iterator());
		
		while(peekingItr.hasNext())
		{
			System.out.println(peekingItr.next() + " " + peekingItr.peek());
		}
		
	}


}

package Queue;

import java.util.Stack;

public class LC232_MyQueueUsingStacks {

	Stack<Integer> queue = new Stack<Integer>();
	
	public static void main(String[] args) {
		
		LC232_MyQueueUsingStacks myQueue = new LC232_MyQueueUsingStacks();
		
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		
		for(int i = 0 ; i < 4 ; i++)
		{
			System.out.println(myQueue.peek());		
			myQueue.pop();		
			
		}
		System.out.println(myQueue.empty());
		
	}
	
	
	public void push(int x)
	{
		Stack<Integer> temp = new Stack<Integer>();
		
		while(!queue.isEmpty())
		{
			temp.push(queue.pop());
		}
		
		queue.push(x);
		
		while(!temp.isEmpty())
		{
			queue.push(temp.pop());
		}
		
	}
	
	public void pop()
	{
		queue.pop();
	}
	
	public int peek()
	{
		return queue.peek();
	}
	
	public boolean empty()
	{
		return queue.isEmpty();
	}

}

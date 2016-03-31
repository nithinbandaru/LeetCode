package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class LC225_StackUsingQueues {
	
	Queue<Integer> queue;
	
	public LC225_StackUsingQueues()
	{
		queue = new LinkedList<Integer>();
	}
	
	public void push(int x)
	{
		queue.add(x);
		
		for(int i = 1 ; i < queue.size(); i++)
		{
			queue.add(queue.poll());
		}
		
	}
	
	public void pop()
	{
		queue.poll();
	}
	
	
	public int top()
	{
		return queue.peek();
	}
	
	public boolean empty()
	{
		return queue.isEmpty();
	}
	
	public static void main(String[] args) {

		LC225_StackUsingQueues myStack = new LC225_StackUsingQueues();
		
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		
		System.out.println(myStack.top());
		myStack.pop() ;
		System.out.println(myStack.top());
		myStack.pop() ;
		
		System.out.println(myStack.top());
		myStack.pop() ;
		
		System.out.println(myStack.top());
		myStack.pop() ;
		
		System.out.println(myStack.empty());
	}

}

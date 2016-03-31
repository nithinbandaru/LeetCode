package Stacks;

public class LC155_MinStack {

	Node top;
	class Node
	{
		int data;
		int min;
		Node next;
		
		public Node(int x)
		{
			data = x;
			min = x;
			next = null;
		}
	}
	
	public static void main(String[] args) {

		LC155_MinStack mStack = new LC155_MinStack();
		mStack.push(7);
		mStack.push(8);
		System.out.println(mStack.getMin());
		mStack.push(5);
		mStack.push(9);
		System.out.println(mStack.getMin());
		mStack.push(5);
		mStack.push(2);
		System.out.println(mStack.getMin());
		mStack.pop();
		mStack.pop();
		System.out.println(mStack.getMin());
		
		
	}
	
	
	public void push(int x)
	{
		
		if(top == null)
		{
			top = new Node(x);
		}
		else
		{
			Node newNode = new Node(x);
			newNode.next = top;
			newNode.min = Math.min(top.min , x);
			top = newNode;
		}		
		
	}
	
	public void pop()
	{
		if(top != null)
		{
			top = top.next;
		}
	}
	
	
	public int top()
	{
		if(top != null)
		{
			return top.data;
		}
		
		return -1;
	}
	
	public int getMin()
	{
		
		if(top != null)
		{
			return top.min;
		}
		
		return -1;
		
	}
	

}

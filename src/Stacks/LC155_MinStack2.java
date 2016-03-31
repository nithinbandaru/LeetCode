package Stacks;

import java.util.Stack;

public class LC155_MinStack2 {

	
	public static void main(String[] args) {

		LC155_MinStack2 mStack = new LC155_MinStack2();
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
	
	private Stack<Integer> s1;
	private Stack<Integer> s2;
	
	public LC155_MinStack2()
	{
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	
	public void push(int x)
	{
		
		s1.push(x);
		
		if(s2.isEmpty() || x <= getMin())
		{
			s2.push(x);
		}
		
	}
	
	public void pop()
	{
		if(s1.peek() == getMin())
		{
			s2.pop();
		}
		
		s1.pop();
	}
	
	public int top()
	{
		return s1.peek();
	}
	
	public int getMin()
	{
	
		return s2.peek();
		
	}
	

}

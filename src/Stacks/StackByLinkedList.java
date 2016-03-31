package Stacks;

public class StackByLinkedList {

	private ListNode head;
	
	
	public static void main(String[] args) {

		StackByLinkedList myStack = new StackByLinkedList();
		
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		
		while(!myStack.isEmpty())
		{
			System.out.println(myStack.top());
			System.out.println(myStack.pop());			
		}
		
	}
	
	public void push(int x)
	{
		if(head == null)
		{
			head = new ListNode(x);
		}
		else
		{
			ListNode newNode = new ListNode(x);
			newNode.next = head;
			head = newNode;
		}
	}
	
	public int top()
	{
		if(head == null)
		{
			return -1;
		}
		
		return head.data;
	}
	
	public int pop()
	{
		if(head == null)
		{
			return -1;
		}
		int data = head.data;
		head = head.next;
		return data;
	}
	
	public boolean isEmpty()
	{
		return (head == null);
	}
	
	
	
	
	class ListNode
	{
		
		int data;
		ListNode next;
		
		public ListNode(int val)
		{
			data = val;
			next = null;
		}		
		
	}

}

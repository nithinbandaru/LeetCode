package Queue;

public class QueueByLinkedList {

	ListNode head;
	ListNode tail;
	
	public static void main(String[] args) {

		QueueByLinkedList myQueue = new QueueByLinkedList();
		
		myQueue.enQueue(1);
		myQueue.enQueue(2);
		myQueue.enQueue(3);
		myQueue.enQueue(4);
		
		while(!myQueue.isEmpty())
		{
			System.out.println(myQueue.deQueue());
		}
	}
	
	public boolean isEmpty()
	{
		return (head == null);
	}
	
	public void enQueue(int x)
	{
		
		ListNode newNode = new ListNode(x);
		
		if(tail != null)
		{
			tail.next = newNode;
		}
		
		tail = newNode;
		
		if(head == null)
		{
			head = tail;
		}
	}
	
	public int deQueue()
	{
		int data = -1;
		if(head != null)
		{
			data = head.data;
			head = head.next;
		}
		
		return data;
	}
	
	
	class ListNode
	{
		int data;
		ListNode next;
		
		public ListNode(int x)
		{
			data = x;
			next = null;
		}
	}

}

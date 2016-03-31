package LinkedList;


public class LC234_PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC234_PalindromeLinkedList list = new LC234_PalindromeLinkedList();
		
		list.addAtBeginnning(10);		
		list.addAtBeginnning(20);		
		list.addAtBeginnning(30);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		boolean isPal = IsListPalindrome(list.head);
		
		System.out.println(isPal);
		
			
	}	
	
	private static boolean IsListPalindrome(LinkNode headNode) {

		// 1. Finding middle point of Linked List
		
		LinkNode slowPtr = headNode;
		LinkNode fastPtr = headNode;
		LinkNode prevOfSlowPtr	= headNode;
		
		if(headNode != null && headNode.next != null)
		{
			while(fastPtr != null && fastPtr.next != null)
			{
				fastPtr = fastPtr.next.next;
				prevOfSlowPtr = slowPtr;
				slowPtr = slowPtr.next;				
			}
		
		
		System.out.println(prevOfSlowPtr.data + " " +slowPtr.data);
		
		// 2. If it is odd Length then move slow pointer one step ahead
		
		if(fastPtr != null)
		{
			slowPtr = slowPtr.next;
		}
		prevOfSlowPtr.next = null;
		
		System.out.println(slowPtr.data);
		
		// 3. Reverse second half
		
		LinkNode secondHalfHead = slowPtr;
		LinkNode prevSecondHalf = null;
		LinkNode nextNodeSecondHalf = slowPtr;
		
		while(secondHalfHead != null)
		{
			nextNodeSecondHalf = secondHalfHead.next;
			secondHalfHead.next = prevSecondHalf;
			prevSecondHalf = secondHalfHead;
			secondHalfHead = nextNodeSecondHalf;
		}
		
		LinkNode tailNode = prevSecondHalf;
		System.out.println(tailNode.data);
		
		// 4. compare 1st half and second half
		
		while(headNode != null && tailNode != null)
		{
			System.out.println(headNode.data + " # " +  tailNode.data);
			if(headNode.data != tailNode.data)
			{
				return false;
			}
			
			headNode = headNode.next;
			tailNode = tailNode.next;
			
		}
		}
		return true;
	}

	LinkNode head;
	
	public void addAtBeginnning(int data)
	{
		LinkNode newNode = new LinkNode(data);
		newNode.next = head;
		head = newNode;
	}
	
	
	
	public void printLinkedList(LinkNode headNode)
	{
		LinkNode temp = headNode;
		
		if(temp == null)
		{
			System.out.println("List is empty");
			return;
		}
		
		while(temp != null)
		{
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	public class LinkNode
	{
		int data;
		LinkNode next;
		
		public LinkNode(int data)
		{
			this.data = data;
			next = null;
		}
		
	}


}

package LinkedList;


public class LC143_ReOrderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC143_ReOrderList list = new LC143_ReOrderList();
		
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
			
		LinkNode newHead = list.reOrderList(list.head);
		list.printLinkedList(newHead);
		
	}	
	
	private LinkNode reOrderList(LinkNode headNode) {

		if(headNode == null || headNode.next == null)
		{
			return headNode;
		}
		
		
		// 1. Find middle of list
		
		LinkNode p1 = headNode; // slowPtr
		LinkNode p2 = headNode; // fastPtr
		
		while(p2.next != null && p2.next.next != null)
		{
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		System.out.println(p1.data);
		
		// 2. Reverse 2nd half of list
		
		LinkNode midNode = p1;
		
		LinkNode preCurrNode = midNode.next;
		
		
		while(preCurrNode.next != null)
		{
			LinkNode currNode = preCurrNode.next;
			preCurrNode.next = currNode.next;
			currNode.next = midNode.next;
			midNode.next = currNode;
		}
		
		// 3. Rearrange Node
		
		p1 = headNode;
		p2 = midNode.next;
		System.out.println(p2.data);
		while(p1 != midNode)
		{
			// adjust links
			midNode.next = p2.next;
			p2.next = p1.next;
			p1.next = p2;
			// move pointers
			p1 = p2.next;
			p2 = midNode.next;			
		}
		
		return headNode;
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

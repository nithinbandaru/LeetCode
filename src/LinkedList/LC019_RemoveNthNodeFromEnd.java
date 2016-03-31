package LinkedList;


public class LC019_RemoveNthNodeFromEnd {

	// Time Complexity = O(n)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC019_RemoveNthNodeFromEnd list = new LC019_RemoveNthNodeFromEnd();
		
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		LinkNode newHead = list.deleteNthNode(list.head , 6);
		
		list.printLinkedList(newHead);
		
	}	
	
	private LinkNode deleteNthNode(LinkNode headNode, int n) {

		if(headNode == null)
		{
			return headNode;
		}
		
		LinkNode dummy = new LinkNode(0);
		
		LinkNode p1 = dummy;
		LinkNode p2 = dummy;
		
		dummy.next = headNode;
		
		// while p1 is at node (n+1) , p2 is at node 1 ..
		// This ensures a gap of n between two node
		for(int i = 1 ; i <= n+1; i++)
		{
			p1 = p1.next;
		}
		
		while(p1 !=null)
		{
			p2=p2.next;
			p1=p1.next;
		}
		
		p2.next = p2.next.next;
		
		return dummy.next;
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

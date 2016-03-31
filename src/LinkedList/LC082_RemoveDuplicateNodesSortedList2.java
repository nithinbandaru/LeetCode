package LinkedList;


public class LC082_RemoveDuplicateNodesSortedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC082_RemoveDuplicateNodesSortedList2 list = new LC082_RemoveDuplicateNodesSortedList2();
		
		list.addAtBeginnning(50);		
		list.addAtBeginnning(40);		
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		LinkNode newHead = list.removeDuplicateNode(list.head);
		
		list.printLinkedList(newHead);
			
	}	
	
	private LinkNode removeDuplicateNode(LinkNode headNode) {

		LinkNode dummyHead = new LinkNode(0);
		dummyHead.next = headNode;
		LinkNode prev = dummyHead;
		
		LinkNode curr = headNode;
		
		while(curr != null)
		{
			while(curr.next != null && curr.data == curr.next.data)
			{
				curr = curr.next;
			}
			
			if(prev.next == curr)
			{
				prev = prev.next;
			}
			else
			{
				prev.next = curr.next;
			}
			
			curr = curr.next;
			
		}
		
		return dummyHead.next;
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

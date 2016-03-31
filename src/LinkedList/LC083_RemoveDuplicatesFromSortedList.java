package LinkedList;


public class LC083_RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC083_RemoveDuplicatesFromSortedList list = new LC083_RemoveDuplicatesFromSortedList();
		
		list.addAtBeginnning(40);		
		list.addAtBeginnning(30);		
		list.addAtBeginnning(30);
		list.addAtBeginnning(30);
		list.addAtBeginnning(30);
		list.addAtBeginnning(10);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		LinkNode newHead = list.deleteDuplicates(list.head);
		
		list.printLinkedList(newHead);
			
	}	
	
	private LinkNode deleteDuplicates(LinkNode headNode) {

		LinkNode curr = headNode;
		
		while(curr != null)
		{
			if(curr.next == null)
			{
				break;
			}
			
			if(curr.data == curr.next.data)
			{
				curr.next = curr.next.next;
			}
			else
			{
				curr = curr.next;
			}
			
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

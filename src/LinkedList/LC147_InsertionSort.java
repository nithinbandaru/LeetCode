package LinkedList;


public class LC147_InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC147_InsertionSort list = new LC147_InsertionSort();
		
		list.addAtBeginnning(40);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(70);
		list.addAtBeginnning(10);
		list.addAtBeginnning(50);
		list.addAtBeginnning(20);
		list.addAtBeginnning(30);
		
		list.printLinkedList(list.head);
			
		LinkNode newHead = list.insertionSortList(list.head);
		list.printLinkedList(newHead);
	}	
	
	public LinkNode insertionSortList(LinkNode headNode) {
		
		if(headNode == null)
		{
			return null;
		}
		
		LinkNode sortedHead = null;
		
		LinkNode curr = headNode;
		
		while(curr != null)
		{
			LinkNode nextNode = curr.next;
			
			sortedHead = SortedInsert(sortedHead , curr);
			
			curr = nextNode;
		}
		
		
		return sortedHead;
		
	}
            

	
	private LinkNode SortedInsert(LinkNode sortedHead, LinkNode newNode) {

		if(sortedHead == null || newNode.data < sortedHead.data)
		{
			newNode.next = sortedHead;
			sortedHead = newNode;
		}
		else
		{
			LinkNode curr = sortedHead;
			
			while(curr.next != null && curr.next.data < newNode.data)
			{
				curr = curr.next;
			}
			newNode.next = curr.next;
			curr.next = newNode;
			
		}
		return sortedHead;
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

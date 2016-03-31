package LinkedList;


public class LC206_ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC206_ReverseLinkedList list = new LC206_ReverseLinkedList();
		
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		list.reverseListRecursive(list.head);
		
		list.printLinkedList(list.head);		
		
		LinkNode newHead = list.reverseListIterative(list.head);
		
		list.printLinkedList(newHead);
			
	}	
	
	private void reverseListRecursive(LinkNode tempNode) {

		
		if(tempNode.next == null)
		{
			head = tempNode;
			return;
		}
		reverseListRecursive(tempNode.next);
		
		LinkNode nextNode = tempNode.next;
		nextNode.next = tempNode;
		tempNode.next = null;
		
	}

	private LinkNode reverseListIterative(LinkNode headNode) {

		if(headNode == null)
		{
			return null;
		}
		
		LinkNode prevNode= null;
		LinkNode currNode = headNode;
		LinkNode nextNode = headNode;
		
		while(currNode != null )
		{			
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		
		headNode = prevNode;
		
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

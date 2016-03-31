package LinkedList;


public class LC092_ReverseLinkedListGivenRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC092_ReverseLinkedListGivenRange list = new LC092_ReverseLinkedListGivenRange();
		
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		LinkNode newHead = list.reverseList(list.head , 1 , 4);
		
		list.printLinkedList(newHead);		
			
	}	
	
	private LinkNode reverseList(LinkNode headNode, int start, int end) {

		if(headNode == null)
		{
			return null;
		}
		
		LinkNode dummyHead = new LinkNode(0);
		dummyHead.next = headNode;
		LinkNode prevNode = dummyHead;
		
		for(int i = 1 ; i < start; i++)
		{
			prevNode = prevNode.next;
		}
		
		LinkNode currNode = prevNode.next;
		LinkNode nextNode = currNode.next;
		
		
		for(int i = 0 ; i < (end - start) ; i++)
		{
			currNode.next = nextNode.next;
			nextNode.next = prevNode.next;
			prevNode.next = nextNode;
			nextNode = currNode.next;
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

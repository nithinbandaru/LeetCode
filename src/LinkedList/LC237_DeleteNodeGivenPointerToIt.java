package LinkedList;


public class LC237_DeleteNodeGivenPointerToIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC237_DeleteNodeGivenPointerToIt list = new LC237_DeleteNodeGivenPointerToIt();
		
				
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		list.deleteNode(list.head.next.next);
		
		list.printLinkedList(list.head);
		
		
	}	
	
	private void deleteNode(LinkNode nodePointer) {

		if(nodePointer != null && nodePointer.next != null)
		{
			LinkNode nextNode = nodePointer.next;
			nodePointer.data = nextNode.data;
			nodePointer.next = nextNode.next;
		}	

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

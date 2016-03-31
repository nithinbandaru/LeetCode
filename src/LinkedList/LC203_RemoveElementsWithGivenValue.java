package LinkedList;


public class LC203_RemoveElementsWithGivenValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC203_RemoveElementsWithGivenValue list = new LC203_RemoveElementsWithGivenValue();
		
		list.addAtBeginnning(6);		
		list.addAtBeginnning(5);		
		list.addAtBeginnning(4);
		list.addAtBeginnning(3);
		list.addAtBeginnning(6);
		list.addAtBeginnning(2);
		list.addAtBeginnning(1);
		
		list.printLinkedList(list.head);
		
		LinkNode newHead = removeElements(list.head , 6);
		
		list.printLinkedList(newHead);
		
	}	
	
	private static LinkNode removeElements(LinkNode headNode, int key) {

		if(headNode == null)
		{
			return null;
		}
		
		while( headNode != null && headNode.data == key)
		{
			headNode = headNode.next;
		}
		
		LinkNode temp = headNode;
		
		while(temp != null && temp.next != null)
		{
			if(key == temp.next.data)
			{
				temp.next = temp.next.next;
			}
			else
			{
				temp = temp.next;
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

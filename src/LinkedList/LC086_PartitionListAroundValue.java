package LinkedList;


public class LC086_PartitionListAroundValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC086_PartitionListAroundValue list = new LC086_PartitionListAroundValue();
		
		list.addAtBeginnning(20);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(20);
		list.addAtBeginnning(30);
		list.addAtBeginnning(40);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		int value = 30;
		
		LinkNode newHead = list.partitionList(list.head , value);		
		
		list.printLinkedList(newHead);
			
	}	
	
	private LinkNode partitionList(LinkNode headNode, int value) {

		LinkNode dummyHead1 = new LinkNode(0);
		LinkNode dummyHead2 = new LinkNode(0);
		
		LinkNode curr1 = dummyHead1;
		LinkNode curr2 = dummyHead2;
		
		while(headNode != null)
		{
			if(headNode.data < value)
			{
				curr1.next = headNode;
				curr1 = headNode;
			}
			else
			{
				curr2.next = headNode;
				curr2 = headNode;
			}
			
			headNode = headNode.next;
		}
		
		curr2.next = null;
		curr1.next = dummyHead2.next;		
				
		return dummyHead1.next;
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

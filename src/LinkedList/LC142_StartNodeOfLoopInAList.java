package LinkedList;


public class LC142_StartNodeOfLoopInAList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC142_StartNodeOfLoopInAList list = new LC142_StartNodeOfLoopInAList();
		
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.head.next.next.next.next.next.next = list.head.next.next.next;		
		
		//list.printLinkedList(list.head);
		
		LinkNode node = startOfLoopNode(list.head);
		
		System.out.println(node.data);
			
	}	
	
	private static LinkNode startOfLoopNode(LinkNode headNode) {

		if(headNode == null || headNode.next == null)
		{
			return null;
		}
		
		LinkNode slowPtr = headNode;
		LinkNode fastPtr = headNode;
		
		boolean IsLoopFound = false;
		
		while(slowPtr != null && fastPtr != null)
		{
			slowPtr = slowPtr.next;
			
			if(fastPtr.next == null)
			{
				return null;
			}
			
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr)
			{
				IsLoopFound = true;
				break;
			}
		}
		
		if(!IsLoopFound)
		{
			return null;
		}
		
		slowPtr = headNode;
		
		while(slowPtr != fastPtr)
		{
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		
		return slowPtr;
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

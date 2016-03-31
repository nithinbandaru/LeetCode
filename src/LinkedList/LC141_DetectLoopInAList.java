package LinkedList;


public class LC141_DetectLoopInAList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC141_DetectLoopInAList list = new LC141_DetectLoopInAList();
		
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.head.next.next.next.next.next.next = list.head.next.next.next;		
		
		//list.printLinkedList(list.head);
		
		boolean loop = loopExists(list.head);
		
		System.out.println(loop);
			
	}	
	
	private static boolean loopExists(LinkNode headNode) {

		if(headNode == null || headNode.next == null)
		{
			return false;
		}
		
		LinkNode slowPtr = headNode;
		LinkNode fastPtr = headNode;
		
		while(fastPtr.next != null && fastPtr.next.next != null)
		{
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr == fastPtr)
			{
				return true;
			}
		}
		
		return false;
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

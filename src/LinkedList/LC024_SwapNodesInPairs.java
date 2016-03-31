package LinkedList;


public class LC024_SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC024_SwapNodesInPairs list = new LC024_SwapNodesInPairs();
		
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		LinkNode newHead = list.swapNodesInPairs(list.head);
		list.printLinkedList(newHead);
		
		
			
	}	
	
	private LinkNode swapNodesInPairs(LinkNode headNode) {

		LinkNode dummy = new LinkNode(0);
		dummy.next = headNode;
		
		LinkNode curr = dummy;
		
		while(curr.next != null && curr.next.next != null)
		{
			LinkNode first = curr.next;
			LinkNode second = curr.next.next;
			
			first.next = second.next;
			curr.next = second;
			second.next = first;
			curr = first;
		}
		
		return dummy.next;
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

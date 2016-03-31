package LinkedList;


public class LC025_ReverseKNodesInGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC025_ReverseKNodesInGroup list = new LC025_ReverseKNodesInGroup();
		
		list.addAtBeginnning(80);
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		int k = 5; 
		
		LinkNode newHead = list.reverseInGroups(list.head, k);
		
		list.printLinkedList(newHead);		
			
	}	
	
	private LinkNode reverseInGroups(LinkNode headNode, int k) {

		if(k <= 1 || headNode == null || headNode.next == null)
		{
			return headNode;
		}
		
		// Make a dummy node and point all pointers to it
		
		LinkNode fakeHead = new LinkNode(0);
		fakeHead.next = headNode;
		
		LinkNode prevNode,tailNode;
		prevNode = tailNode = fakeHead;
		
		LinkNode nextNode = null;
		
		LinkNode currNode = prevNode.next;
		
		while(true)
		{
			// check if there are k nodes to reverse
			
			for(int i = 0; i < k ; i++)
			{
				tailNode = tailNode.next;
				
				if(tailNode == null)
				{
					return fakeHead.next;
				}
			}
			
			// start reverse in groups of k
			
			for(int i = 0; i < k - 1; i++)
			{
				nextNode = currNode.next;
				currNode.next = nextNode.next;
				nextNode.next = prevNode.next;
				prevNode.next = nextNode;				
				
			}
			
			prevNode = tailNode = currNode;
			currNode = prevNode.next;	
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

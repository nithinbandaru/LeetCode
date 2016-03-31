package LinkedList;


public class LC328_SegregateOddEvenNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC328_SegregateOddEvenNodes list = new LC328_SegregateOddEvenNodes();
		
		list.addAtBeginnning(70);		
		list.addAtBeginnning(60);		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		LinkNode newHead = list.segregateOddEven(list.head);
		
		list.printLinkedList(newHead);
			
	}	
	
	private LinkNode segregateOddEven(LinkNode headNode) {


		if(headNode != null)
		{
			LinkNode oddNode = headNode;
			
			LinkNode evenNode = oddNode.next;
			
			LinkNode evenHead = evenNode;
			
			while(evenNode != null && evenNode.next != null)
			{
				oddNode.next = oddNode.next.next;
				evenNode.next = evenNode.next.next;
				
				oddNode = oddNode.next;
				evenNode = evenNode.next;				
				
			}
			
			oddNode.next = evenHead;
			
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

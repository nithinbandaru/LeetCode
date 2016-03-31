package LinkedList;


public class LC160_IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC160_IntersectionOfTwoLinkedLists list = new LC160_IntersectionOfTwoLinkedLists();
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		LC160_IntersectionOfTwoLinkedLists list1 = new LC160_IntersectionOfTwoLinkedLists();
		list1.addAtBeginnning(6);		
		list1.addAtBeginnning(5);
		list1.addAtBeginnning(30);
		list1.addAtBeginnning(3);
		list1.addAtBeginnning(2);
		list1.addAtBeginnning(1);
		
		LC160_IntersectionOfTwoLinkedLists list2 = new LC160_IntersectionOfTwoLinkedLists();
		
		
		LinkNode node = list2.getIntersectionPoint(list.head , list1.head);
		System.out.println(node.data);
		
	}	
	
	private LinkNode getIntersectionPoint(LinkNode headA, LinkNode headB) {
		
		if(headA == null || headB == null)
		{
			return null;
		}
		
		
		LinkNode p1 = headA;
		LinkNode p2 = headB;
		
		while(p1.data != p2.data)
		{
			
			p1 = (p1 == null) ? headB : p1.next;
			p2 = (p2 == null) ? headA : p2.next;
			
		}		
		
		return p1;
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

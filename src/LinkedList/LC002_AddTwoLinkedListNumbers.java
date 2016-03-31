package LinkedList;


public class LC002_AddTwoLinkedListNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC002_AddTwoLinkedListNumbers list1 = new LC002_AddTwoLinkedListNumbers();
		list1.addAtBeginnning(3);
		list1.addAtBeginnning(4);
		list1.addAtBeginnning(2);
		
		list1.printLinkedList(list1.head);
		
		LC002_AddTwoLinkedListNumbers list2 = new LC002_AddTwoLinkedListNumbers();
		list2.addAtBeginnning(4);
		list2.addAtBeginnning(6);
		list2.addAtBeginnning(5);
		
		list2.printLinkedList(list2.head);
		
		LC002_AddTwoLinkedListNumbers list3 = new LC002_AddTwoLinkedListNumbers();
		
		LinkNode newHead = addTwoNumbers(list1.head , list2.head);
		list3.printLinkedList(newHead);
		
	}	
	
	private static LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {

		LinkNode prev = new LinkNode(0);
		LinkNode newHead = prev;
		int carry = 0;
		
		while( l1 != null || l2 != null || carry != 0 )
		{			
			LinkNode currNode = new LinkNode(0);
			int sum = ((l1 == null) ? 0 : l1.data) + ((l2 == null) ? 0 : l2.data) + carry;
			currNode.data = sum % 10;
			carry = sum / 10;
			prev.next = currNode;
			prev = currNode;
			
			l1 = (l1==null) ? l1 : l1.next;
			l2 = (l2==null) ? l2 : l2.next;			
		}
		
		return newHead.next;
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
	
	
	public static class LinkNode
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

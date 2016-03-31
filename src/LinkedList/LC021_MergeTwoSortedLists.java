package LinkedList;

public class LC021_MergeTwoSortedLists {

	// Time Complexity = O(m+n)
	// Space Complexity = O(1)
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC021_MergeTwoSortedLists list1 = new LC021_MergeTwoSortedLists();
		list1.addAtBeginnning(25);
		list1.addAtBeginnning(22);
		
		list1.addAtBeginnning(15);
		list1.addAtBeginnning(10);
		list1.addAtBeginnning(5);
		
		list1.printLinkedList(list1.head);	
		
		LC021_MergeTwoSortedLists list2 = new LC021_MergeTwoSortedLists();
		list2.addAtBeginnning(30);		
		list2.addAtBeginnning(20);
		list2.addAtBeginnning(7);
		list2.addAtBeginnning(2);
		list2.printLinkedList(list2.head);	
		
		LC021_MergeTwoSortedLists list3 = new LC021_MergeTwoSortedLists();
		LinkNode newHead = list3.MergeSortedLinkedlists(list1.head , list2.head);
		list3.printLinkedList(newHead);
		
	}	
	
	private LinkNode MergeSortedLinkedlists(LinkNode head1, LinkNode head2) {

		
		if(head1 == null && head2 == null)
		{
			return null;
		}
		
		if(head1 == null)
		{
			return head2;
		}
		
		if(head2 == null)
		{
			return head1;
		}
		
		
		LinkNode newHead = null;
		
		if(head1.data <= head2.data)
		{
			newHead = head1;
			head1 = head1.next;
			
		}
		else
		{
			newHead = head2;
			head2 = head2.next;			
		}
		
		LinkNode temp = newHead;
		
		while(head1 != null && head2 != null)
		{
			if(head1.data <= head2.data)
			{
				temp.next = head1;
				head1 = head1.next;
			}
			else
			{
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		
		if(head1 != null)
		{
			temp.next = head1;
		}
		
		if(head2 != null)
		{
			temp.next = head2;
		}
		
		return newHead;
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

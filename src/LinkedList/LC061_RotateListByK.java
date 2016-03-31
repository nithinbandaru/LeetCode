package LinkedList;


public class LC061_RotateListByK {

	// Time Complexity = O(n)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC061_RotateListByK list = new LC061_RotateListByK();
		
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.printLinkedList(list.head);
		
		LinkNode newHead = list.rotateList(list.head , 2);
		
		list.printLinkedList(newHead);
		
	}	
	
	private LinkNode rotateList(LinkNode headNode, int k) {

		if(headNode == null || head.next == null || k == 0)
		{
			return headNode;
		}
		
		LinkNode tail = headNode;
		int lenOfList = 1;
		
		while(tail.next != null)
		{
			tail = tail.next;
			lenOfList++;
		}
		
		tail.next = headNode;
		
		k = k % lenOfList;
		
		for(int i = 0 ; i < lenOfList - k ; i++)
		{
			tail = tail.next;
		}
		
		headNode = tail.next;
		tail.next = null;		
		
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

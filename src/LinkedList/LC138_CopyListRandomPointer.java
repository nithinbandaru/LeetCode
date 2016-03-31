package LinkedList;


public class LC138_CopyListRandomPointer {

	// picture : http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC138_CopyListRandomPointer list = new LC138_CopyListRandomPointer();
				
		list.addAtBeginnning(50);
		list.addAtBeginnning(40);
		list.addAtBeginnning(30);
		list.addAtBeginnning(20);
		list.addAtBeginnning(10);
		
		list.head.random = list.head.next.next;
		list.head.next.random = list.head;
		list.head.next.next.random = list.head.next.next.next.next;
		list.head.next.next.next.random = list.head.next.next;
		list.head.next.next.next.next.random = list.head.next;
		
		list.printLinkedList(list.head);
		
		LinkNode newHead = list.copyList(list.head);
		
		list.printLinkedList(newHead);
		
	}	
	
	private LinkNode copyList(LinkNode headNode) {

		// 1 . copy each node adjacent to it
		LinkNode curr = headNode;
		LinkNode nextNode;
		
		while(curr != null)
		{
			nextNode = curr.next;
			
			LinkNode copy = new LinkNode(curr.data);
			curr.next = copy;
			copy.next = nextNode;
			curr = nextNode;
		}
		
		// 2. copy random pointers
		
		curr = headNode;
		
		while(curr != null)
		{
			if(curr.random != null)
			{
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}
		
		// 3. Restore original and copied list
		
		curr = headNode;
		
		LinkNode fakeHead = new LinkNode(0);
		LinkNode copyItr = fakeHead;
		
		LinkNode storeCopy;
		
		while(curr != null)
		{
			nextNode = curr.next.next;
			
			// extract the copy
			
			storeCopy = curr.next;
			copyItr.next = storeCopy;
			copyItr = storeCopy;
			
			// restore original
			
			curr.next = nextNode;
			curr = nextNode;
		}
		
		return fakeHead.next;
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
		temp = headNode;
		while(temp != null)
		{
			System.out.print(temp.random.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	public class LinkNode
	{
		int data;
		LinkNode next;
		LinkNode random;
		
		public LinkNode(int data)
		{
			this.data = data;
			next = null;
			random = null;
		}
		
	}


}

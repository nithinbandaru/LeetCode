package LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class LC023_MergeKSortedLists {

	// Time Complexity = O(n logk)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC023_MergeKSortedLists list1 = new LC023_MergeKSortedLists();
		
		list1.addAtBeginnning(45);
		list1.addAtBeginnning(35);
		list1.addAtBeginnning(25);
		list1.addAtBeginnning(15);
		list1.addAtBeginnning(5);
		
		list1.printLinkedList(list1.head);		

		
		LC023_MergeKSortedLists list2 = new LC023_MergeKSortedLists();
		
		list2.addAtBeginnning(50);
		list2.addAtBeginnning(40);
		list2.addAtBeginnning(30);
		list2.addAtBeginnning(20);
		list2.addAtBeginnning(10);
		
		list2.printLinkedList(list2.head);
		
		LC023_MergeKSortedLists list3 = new LC023_MergeKSortedLists();
		
		list3.addAtBeginnning(57);
		list3.addAtBeginnning(47);
		list3.addAtBeginnning(27);
		list3.addAtBeginnning(17);
		list3.addAtBeginnning(7);
		
		list3.printLinkedList(list3.head);
		
		LC023_MergeKSortedLists list4 = new LC023_MergeKSortedLists();
		
		List<LinkNode> lists = new ArrayList<LinkNode>();
		lists.add(list1.head);
		lists.add(list2.head);
		lists.add(list3.head);
		
		LinkNode newHead = list4.mergeKLists(lists);
		list4.printLinkedList(newHead);
			
	}	
	
	private LinkNode mergeKLists(List<LinkNode> lists) {

		if(lists == null || lists.size() == 0)
		{
			return null;
		}
		
		PriorityQueue<LinkNode> queue = new PriorityQueue<LinkNode>(lists.size(), new Comparator<LinkNode>(){

			@Override
			public int compare(LinkNode l1, LinkNode l2) {

				if(l1.data < l2.data)
				{
					return -1;
				}
				else if(l1.data == l2.data)
				{
					return 0;
				}				
				return 1;
			}			
		});
		
		LinkNode fakeHead = new LinkNode(0);
		
		LinkNode tail = fakeHead;
		
		for(LinkNode headNode : lists)
		{
			if(headNode != null)
			{
				queue.add(headNode);
			}			
		}
		
		
		while(!queue.isEmpty())
		{
			tail.next = queue.poll();
			tail = tail.next;
			
			if(tail.next != null)
			{
				queue.add(tail.next);
			}
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

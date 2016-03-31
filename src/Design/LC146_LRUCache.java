package Design;

import java.util.HashMap;

public class LC146_LRUCache {

	private HashMap<Integer, DLinkNode> cache;
	private int count;
	private int capacity;
	private DLinkNode head;
	private DLinkNode tail;
	
	public LC146_LRUCache(int capacity)
	{
		this.count = 0;
		this.capacity = capacity;
		
		cache = new HashMap<Integer, DLinkNode>();
		
		head = new DLinkNode();
		tail = new DLinkNode();
		
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key)
	{
		DLinkNode node = cache.get(key);
		if(node == null)
		{
			return -1;
		}
		
		moveToHead(node);		
		return node.value;
	}
	
	
	public void set(int key, int value)
	{
		DLinkNode node = cache.get(key);
		
		if(node == null)
		{
			DLinkNode newNode = new DLinkNode(key, value);
			cache.put(key, newNode);
			addNodeAfterHead(newNode);
			
			count++;
			
			if(count > capacity)
			{
				// pop the tail node
				
				DLinkNode tailNode = popTail();
				cache.remove(tailNode.key);
				count--;
			}
		}
		else
		{
			node.value = value;
			moveToHead(node);
		}
	}
	
	
	private void moveToHead(DLinkNode node) {

		removeNode(node);
		addNodeAfterHead(node);
	}


	private DLinkNode popTail() {

		DLinkNode tailNode = tail.prev;
		removeNode(tailNode);
		return tailNode;
	}


	private void removeNode(DLinkNode tailNode) {

		DLinkNode tailPrev = tailNode.prev;
		DLinkNode tailNext = tailNode.next;
		
		tailPrev.next = tailNext;
		tailNext.prev = tailPrev;
	}


	// always add new node right next to the head
	private void addNodeAfterHead(DLinkNode newNode) {

		newNode.prev = head;
		newNode.next = head.next;
		
		head.next.prev = newNode;
		head.next = newNode;
		
	}


	public static void main(String[] args) {

		LC146_LRUCache lru = new LC146_LRUCache(5);
		
		lru.set(1, 100);
		lru.set(2, 100);
		lru.set(3, 100);
		lru.set(4, 100);
		lru.set(5, 100);
		lru.set(6, 100);
		
		System.out.println(lru.get(1));
		
		
	}

	
	
	class DLinkNode
	{
		int key;
		int value;
		DLinkNode prev;
		DLinkNode next;
		
		public DLinkNode()
		{
			prev = null;
			next = null;					
		}
		
		public DLinkNode(int key, int value)
		{
			this.key = key;
			this.value = value;
			prev = null;
			next = null;					
		}
	}
	
}

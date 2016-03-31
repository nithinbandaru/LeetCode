package Design;

import java.util.ArrayList;

public class HashTable<K, V> {

	private ArrayList<DLinkNode<K,V>> list;
	
	public HashTable(int capacity)
	{
		list = new ArrayList<DLinkNode<K,V>>();
		list.ensureCapacity(capacity);
		for(int i =0 ; i < capacity; i++)
		{
			list.add(null);
		}
	}
	
	// Insert key, value
	
	public void put(K key, V value)
	{
		DLinkNode<K,V> node = getNodeForKey(key);
		
		if(node != null)
		{
			node.value = value;
			return;
		}
		
		node = new DLinkNode<K,V>(key, value);
		
		int index = getIndexForKey(key);
		
		if(list.get(index) != null)
		{
			node.next = list.get(index);
			node.next.prev = node;			
		}
		
		list.set(index, node);
	}
	
	private DLinkNode<K, V> getNodeForKey(K key) {

		int index = getIndexForKey(key);
		
		DLinkNode<K,V> curr = list.get(index);
		
		while(curr != null)
		{
			if(curr.key == key)
			{
				return curr;
			}
			curr = curr.next;
		}
		
		return null;
	}

	private int getIndexForKey(K key) {

		int index = Math.abs(key.hashCode() % list.size());
		return index;
	}

	
	// Remove node
	
	public void remove(K key)
	{
		DLinkNode<K,V> node = getNodeForKey(key);
		
		if(node.prev != null)
		{
			node.prev.next = node.next;
		}
		else
		{
			int hashkey = getIndexForKey(key);
			list.set(hashkey, node.next);
		}
		
		if(node.next != null)
		{
			node.next.prev = node.prev;
		}
		
	}
	
	public V get(K key)
	{
		DLinkNode<K,V> node = getNodeForKey(key);
		return node == null ? null : node.value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public class DLinkNode<K,V>
	{
		K key;
		V value;
		DLinkNode<K,V> prev;
		DLinkNode<K,V> next;
		
		public DLinkNode()
		{
			prev = null;
			next = null;					
		}
		
		public DLinkNode(K key, V value)
		{
			this.key = key;
			this.value = value;
			prev = null;
			next = null;					
		}
	}

}

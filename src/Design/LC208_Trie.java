package Design;

import java.util.ArrayList;
import java.util.List;

public class LC208_Trie {

	
	private TrieNode root;
	
	public LC208_Trie()
	{
		root = new TrieNode();
	}
	
	public void insert(String word)
	{
		
		TrieNode rootNode = root;
		
		for(int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			// System.out.println(ch-'a');
			if(rootNode.children[ch-'a'] == null)
			{
				rootNode.children[ch-'a'] = new TrieNode();
			}
			
			rootNode = rootNode.children[ch-'a'];			
		}
		
		rootNode.isWord = true;
		
	}
	
	public boolean search(String word)
	{
		TrieNode rootNode = root;
		
		for(int i =0 ; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			
			if(rootNode.children[ch-'a'] == null)
			{
				return false;
			}
			
			rootNode = rootNode.children[ch-'a'];
		}
		
		return rootNode.isWord;
	}
	
	public boolean startsWith(String word)
	{
		TrieNode rootNode = root;
		
		for(int i = 0 ; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			if(rootNode.children[ch-'a'] == null)
			{
				return false;
			}
			
			rootNode = rootNode.children[ch-'a'];
		}
		
		return true;
	}
	
	
	public List<String> listWords()
	{
		List<String> list = new ArrayList<String>();
		
		collectWords(root, "", list);
		
		return list;		
	}
	
	
	public List<String> listPrefixMatchWords(String prefix)
	{
		List<String> list = new ArrayList<String>();
		
		TrieNode rootNode = root;
		
		for(int i = 0 ; i < prefix.length(); i++)
		{
			char ch = prefix.charAt(i);
			if(rootNode.children[ch-'a'] != null)
			{
				rootNode = rootNode.children[ch-'a'];
			}
		}
		
		collectWords(rootNode, prefix, list);
		
		return list;		
	}
	
	private void collectWords(TrieNode rootNode, String prefix, List<String> list) {

		if(rootNode == null)
		{
			return;
		}
		
		if(rootNode.isWord)
		{
			list.add(prefix);
		}
		
		for(int i = 0; i < 26; i++)
		{
			if(rootNode.children[i] != null)
			{
				collectWords(rootNode.children[i] , prefix + (char)('a' + i), list);
			}
		}
	}

	public static void main(String[] args) {

		
		LC208_Trie trie = new LC208_Trie();
		
		trie.insert("nithin");
		trie.insert("nitro");
		trie.insert("nitrogen");
		trie.insert("nimble");
		trie.insert("nimboo");
		
		trie.insert("sur");
		trie.insert("shell");
		trie.insert("shelter");
		trie.insert("surf");
		trie.insert("surreal");
		
		List<String> words = trie.listWords();
		
		System.out.println(words);
		
		boolean prefix = trie.startsWith("nit");
		boolean found = trie.startsWith("nitro");
		
		
		List<String> prefixMatch = trie.listPrefixMatchWords("sur");
		
		System.out.println(prefixMatch);
		
		System.out.println(prefix + " " + found);
		
	}	
	
	
	class TrieNode
	{
		public boolean isWord;
		public TrieNode[] children = new TrieNode[26];
		
		public TrieNode()
		{
			
		}
	}

}

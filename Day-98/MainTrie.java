import java.util.*;

class TrieNode{
	HashMap<Character, TrieNode> map;
	Boolean end;

	TrieNode(Boolean assign){
		map = new HashMap<Character, TrieNode>();
		end = assign;
	}
}

class Trie{
	TrieNode root = new TrieNode(false);

	void insert(String str){
		TrieNode ptr = root;
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			Boolean end = false;
			if(i == str.length()-1)
				end = true;
			if(ptr.map.containsKey(ch))
				ptr = ptr.map.get(ch);
			else{
				TrieNode node = new TrieNode(end);
				ptr.map.put(ch, node);
				ptr = node;
			}
		}
	}

	Boolean search(String str){
		TrieNode ptr = root;
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(!ptr.map.containsKey(ch))
				return false;
			else
				ptr = ptr = ptr.map.get(ch);
		}
		if(ptr.end)
			return true;
		else
			return false;
	}

}

class MainTrie{
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("pqr");
		trie.insert("abcd");
		System.out.println(trie.search("pqr"));
	}
}
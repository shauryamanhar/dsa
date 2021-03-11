package dsa.shaurya.tree.tries;

public class Trie {
	class TrieNode{
		TrieNode[] arr;
		boolean isEnd;
		public TrieNode() {
			this.arr=new TrieNode[26];
			this.isEnd=false;
		}
	}
	
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	
	//insert
	public void insert(String word) {
		TrieNode p = root;
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			int index = c-'a';
			if(p.arr[index]==null) {
				TrieNode temp = new TrieNode();
				p.arr[index]=temp;
				p=temp;
			}else {
				p=p.arr[index];
			}
		}
		p.isEnd=true;
	}//insert
	
	//search node
	public TrieNode searchNode(String word) {
		TrieNode p = root;
		for(int i=0;i<word.length();i++) {
			int index = word.charAt(i)-'a';
			if(p.arr[index]!=null) {
				p = p.arr[index];
			}else {
				return null;
			}
		}
		if(p==null) {
			return null;
		}
		return p.isEnd==true?p:null;
	}//search node
	public boolean searchWith(String word) {
        TrieNode p = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(p.arr[index]!=null){
                p=p.arr[index];
            }else{
                return false;
            }
        }
        if(p==null){
            return false;
        }
        return true;
	}//search node
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("shaurya");
		System.out.println(trie.searchNode("shaury")!=null?"found":"not found");
		System.out.println(trie.searchWith("shaurya")?"found":"not found");
	}
	
}

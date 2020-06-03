package dsa.shaurya.tree.tries;

public class TriesImpl {
	static class Trie{
		Trie next[];
		Trie(){
			next = new Trie[26];
		}
		
		void add(char str[],int i) {
			if(i<str.length) {
				if(next[str[i]-'a']==null) {
					next[str[i]-'a']=new Trie();
				}
				next[str[i]-'a'].add(str, i+1);
			}
		}
		
		Trie get(char str[],int i) {
			
			if(i<str.length) {
				System.out.println("found "+str[i]);
				if(next[str[i]-'a']!=null) {
					return next[str[i]-'a'].get(str, i+1);
				}
				return null;//fail case
			}
			return this;
		}
		
	}
	public static void main(String[] args) {
		char ch[] = "hello".toCharArray();
		char q[] = "hello".toCharArray();
		Trie trie = new Trie();
		trie.add(ch, 0);
		System.out.println(trie.get(q, 0));

	}
	
}

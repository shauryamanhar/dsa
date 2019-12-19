package dsa.shaurya.graph;

import java.util.*;
public class Trie{
  private class TrieNode{
    Map<Character,TrieNode> children;
    boolean endOfWord;
    TrieNode(){
      children = new HashMap<Character,TrieNode>();
      endOfWord = false;
    }
  }//TrieNode
  private final TrieNode root;

  public Trie(){
    root = new TrieNode();
  }

  //iterative insert into tree
  public void insert(String word){
    TrieNode current = root;
    for (int i=0;i<word.length() ;i++ ) {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if(node==null){
        node = new TrieNode();
        current.children.put(ch,node);
      }
    }//for
    //mark end of end of word
    current.endOfWord=true;
  }//insert
}//trie

package DataStructure.tree;

/**
 * @author akshay Date 2019-06-15 18:35
 */
class TrieNode {

  public char val;
  public boolean isWord;
  public TrieNode[] children = new TrieNode[26];

  public TrieNode() {
  }

  TrieNode(char c) {
    TrieNode node = new TrieNode();
    node.val = c;
  }
}

public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
    root.val = ' ';
  }

  public void insert(String word) {
    TrieNode ws = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (ws.children[c - 'a'] == null) {
        ws.children[c - 'a'] = new TrieNode(c);
      }
      ws = ws.children[c - 'a'];
    }
    ws.isWord = true;
  }

  public boolean search(String word) {
    TrieNode ws = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (ws.children[c - 'a'] == null) {
        return false;
      }
      ws = ws.children[c - 'a'];
    }
    return ws.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode ws = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (ws.children[c - 'a'] == null) {
        return false;
      }
      ws = ws.children[c - 'a'];
    }
    return true;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    System.out.println("Insert word apple....");
    trie.insert("apple");
    System.out.println("Search word apple :: " + trie.search("apple"));   // returns true
    System.out.println("Search word app :: " + trie.search("app"));   // returns false
    System.out.println("word start with app :: " + trie.startsWith("app"));   // returns true
    System.out.println("Insert word app....");
    trie.insert("app");
    trie.search("app");     // returns true
    System.out.println("Search word app :: " + trie.search("app"));   // returns true
  }
}

class TrieNode {
    public char val;
    public boolean isLast; 
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root=new TrieNode();
        root.val=' ';
    }
    
    public void insert(String word) {
        TrieNode w=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(w.children[c-'a']==null)
            {
                w.children[c-'a']=new TrieNode(c);
            }
            w=w.children[c-'a'];
        }
        w.isLast=true;
    }
    
    public boolean search(String word) {
        TrieNode w= root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(w.children[c-'a']==null)
                return false;
            w=w.children[c-'a'];
        }
        return w.isLast;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode w=root;
        for(int i=0;i<prefix.length();i++)
        {
            char c=prefix.charAt(i);
            if(w.children[c-'a']==null)
                return false;
            w=w.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
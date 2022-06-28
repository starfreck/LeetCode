class Trie {

    TrieNode root;
    
    private static class TrieNode {
        
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
        
    }
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        
        if(word == null || word.isEmpty()){
            return;
        }
        
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++) {
            
            char c = word.charAt(i);
            int index = c - 'a';
            
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            
            if(current.children[index] == null) {
                 return false;
            }
            current = current.children[index];
        }
        
        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        
        if(search(prefix)){
            return true;
        }
        
        TrieNode current = root;
        
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            
            if(current.children[index] == null) {
                 return false;
            }
            current = current.children[index];
        }
        
        for(int j = 0; j < 26; j++){
            if(current.children[j] != null){
                return true;
            } 
        }
        return false;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
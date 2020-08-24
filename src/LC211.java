import java.util.HashMap;

public class LC211 {

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    Trie trie ;
    /** Initialize your data structure here. */
    public LC211() {
         trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie node = trie;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch))
                node.children.put(ch, new Trie());
            node = node.children.get(ch);
        }
        node.word = word;
    }

    /** Returns if the word is in the node. */
    public boolean searchInNode(String word, Trie node) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                // if the current character is '.'
                // check all possible nodes at this level
                if (ch == '.') {
                    for (char x : node.children.keySet()) {
                        Trie child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else {
                // if the character is found
                // go down to the next level in trie
                node = node.children.get(ch);
            }
        }
        return node.word != null;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, trie);
    }


}

class Trie{
    HashMap<Character, Trie> children = new HashMap<>();
    String word = null;
    public Trie(){}
}

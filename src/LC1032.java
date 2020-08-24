import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean word = false;
    public TrieNode() {}
}
public class LC1032 {
    TrieNode trie = new TrieNode();
    Deque<Character> stream = new ArrayDeque();

    public LC1032(String[] words) {
        for(String word : words){
            TrieNode node = trie;
            for(int i = word.length() - 1; i >=0; i --){
                char c = word.charAt(i);
                if(!node.children.containsKey(c)){
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.word = true;
        }


    }

    public boolean query(char letter) {
        stream.addFirst(letter);

        TrieNode node = trie;
        for (char ch : stream) {
            if (node.word) {
                return true;
            }
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.word;
    }

}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Trie{
    HashMap<Character, Trie> children = new HashMap<>();
    String word = null;
    public Trie(){}
}

class Solution {
    List<String> result = new ArrayList<>();
    char[][] _board = null;

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        // first put all works in trie
        for(String word : words){
            char[] w = word.toCharArray();
            Trie tmp = root;
            for (char c : w) {
                if (tmp.children.containsKey(c)) {
                    tmp = tmp.children.get(c);
                } else {
                    Trie newTrie = new Trie();
                    tmp.children.put(c, newTrie);
                    tmp = newTrie;
                }
            }
            tmp.word = word;
        }

        // for each point on board, search as start point
        this._board = board;
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(root.children.containsKey(board[i][j])){
                    search(i, j, root);
                }
            }
        }
        return result;
    }

    public void search(int row, int column, Trie parent){

        char ch = _board[row][column];
        Trie node = parent.children.get(ch);

        if(node.word != null){
            result.add(node.word);
            node.word = null;
        }

        _board[row][column] = '#';

        int[] rowChange = {-1, 1, 0, 0};
        int[] columnChange = {0, 0, 1, -1};
        for(int i = 0; i < 4; i ++){
            int newRow = row + rowChange[i];
            int newColumn = column + columnChange[i];

            if(newRow < 0 || newRow >= _board.length || newColumn < 0 || newColumn >= _board[0].length || _board[newRow][newColumn] == '#')
                continue;
            if(node.children.containsKey(_board[newRow][newColumn]))
                search(newRow, newColumn, node);
        }

        _board[row][column] = ch;

        if(node.children.isEmpty())
            parent.children.remove(ch);


    }
}



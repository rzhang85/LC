public class LC79 {

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();

        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(DFS(board, i , j , w, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean DFS(char[][] board, int i, int j, char[] w, int index){
        if(index == w.length)
            return true;
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if(board[i][j] != w[index])
            return false;
        char tmp = board[i][j];
        board[i][j] = '#';
        boolean result = DFS(board, i - 1, j , w, index + 1) ||
                DFS(board, i + 1, j , w, index + 1) ||
                DFS(board, i, j - 1 , w, index + 1) ||
                DFS(board, i, j + 1, w, index + 1);
        board[i][j] = tmp;
        return result;
    }


}

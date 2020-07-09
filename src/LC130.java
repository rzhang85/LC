public class LC130 {
    char[][] board;
    int [][] flag ;

    public void solve(char[][] board) {
        if(board.length <= 2 || board[0].length <= 2)
            return;
        this.board = board;
        flag = new int[board.length][board[0].length];

        for(int i = 1; i < board.length -1; i ++){
            for(int j = 1; j < board[i].length -1; j ++){
                if(board[i][j] == 'O' && flag[i][j] != 1){

                    checkReigion(i,j);
                }
            }
        }


    }

    public boolean checkReigion(int i, int j){
        // flag check if a reigion has been scanned before
        if(i == 0 || i == board.length -1 || j == 0 || j == board[0].length -1){
            if(board[i][j] == 'O')
                return false;
        }

        if(board[i][j] == 'X'){
            return true;
        }
        else{
            flag[i][j] = 1;

            boolean left, right, top, bottom;


            if(board[i-1] [j] == 'X' || flag[i-1] [j] == 1)
                top = true;
            else
                top = checkReigion(i-1, j);

            if(board[i+1] [j] == 'X' || flag[i+1] [j] == 1)
                bottom = true;
            else
                bottom = checkReigion(i+1, j);

            if(board[i][j-1] == 'X' || flag[i][j-1] == 1)
                left = true;
            else
                left = checkReigion(i, j-1);

            if(board[i][j+1] == 'X' || flag[i][j+1] == 1)
                right = true;
            else
                right = checkReigion(i, j+1);

            // flip if this node satisfied
            if(left && right && top && bottom){
                board[i][j] = 'X';
            }

            return left && right && top && bottom;
        }

    }


}

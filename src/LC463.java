public class LC463 {
    private int sum = 0;
    private int[][] _grid;
    public int islandPerimeter(int[][] grid) {
        this._grid = grid;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    DFS(i, j);
                    break;
                }

            }
        }

        return sum;
    }

    public boolean DFS(int x, int y){
        if(x < 0 || x >= _grid.length || y < 0 || y >= _grid[0].length)
            return false;

        if(_grid[x][y] == 0)
            return false;

        if(_grid[x][y] == 2)
            return true;
        // turn current cell to 2, prevent going back.
        _grid[x][y] = 2;
        if(!DFS(x - 1, y))
            sum += 1;
        if(!DFS(x + 1, y))
            sum += 1;
        if(!DFS(x, y - 1))
            sum += 1;
        if(!DFS(x, y + 1))
            sum += 1;

        return true;

    }
}

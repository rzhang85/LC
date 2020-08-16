import java.util.LinkedList;

public class LC994 {

    public int orangesRotting(int[][] grid) {

        int freshCount = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        int time = 0;
        // add all rotten oranges to list
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 2)
                    queue.add(new int[] {i,j});
                else if(grid[i][j] == 1)
                    freshCount ++;
            }
        }

        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // defined 4 direction 2d-array

        // start BFS
        while(!queue.isEmpty() && freshCount > 0){
            int size = queue.size(); // current layer
            time ++;
            for( int i = 0; i < size; i ++){
                int[] orange = queue.poll();
                for(int[] d : direction){
                    int newX = orange[0] + d[0];
                    int newY = orange[1] + d[1];
                    if(newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] != 1){
                        continue;
                    }
                    queue.add(new  int[] {newX, newY});
                    grid[newX][newY] = 2;
                    freshCount --;
                }
            }
        }

        if(freshCount == 0){
            return time;
        }
        else{
            return -1;
        }

    }
}

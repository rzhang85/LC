import java.util.Arrays;

public class LC174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] HP = new int[m + 1][n + 1];

        for(int[] row : HP)
        Arrays.fill(row, Integer.MAX_VALUE);

        HP[m][n - 1] = 1;
        HP[m-1][n] = 1;

        for(int i = m - 1; i >=0; i --){
            for (int j = n - 1; j >= 0; j --){
                HP[i][j] = Math.max(1, Math.min(HP[i+1][j], HP[i][j+1]) - dungeon[i][j]) ;
            }
        }

        return  HP[0][0];
    }
}

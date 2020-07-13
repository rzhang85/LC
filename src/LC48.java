public class LC48 {
    public void rotate(int[][] matrix) {
        // transpose
        for(int i = 0; i < matrix.length; i ++){
            for(int j = i + 1; j < matrix.length; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // reverse each row
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix.length /2 ; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = tmp;
            }
        }

    }
}

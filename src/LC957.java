public class LC957 {

    public int[] nextDay(int[] cells){
        int[] nextCells = new int[cells.length];

        for(int i = 1; i < cells.length - 1; i ++){
            nextCells[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return nextCells;
    }

    public int convert(int[] cells){
        int sum = 0;
        for(int cell: cells){
            sum <<= 1;
            sum = sum | cell;
        }
        return sum;
    }

    public int[] prisonAfterNDays(int[] cells, int N) {


        return cells;
    }



}

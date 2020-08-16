import java.util.Arrays;

public class LC435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals smaller end first, and if end same them sort bigger start first.
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int result = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (prevEnd > interval[0])
                result++;
            else prevEnd = interval[1];
        }

        return result;
    }

}

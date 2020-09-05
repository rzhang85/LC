import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LC436 {
    public int[] findRightInterval(int[][] intervals) {
        int[][] endIntervals = Arrays.copyOf(intervals, intervals.length);
        int[] result = new int[intervals.length];
        HashMap<int[], Integer> hashmap = new HashMap<>();
        for(int i = 0; i < intervals.length; i ++){
            hashmap.put(intervals[i], i);
        }

        // sort intervals based on start point and end point
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //Arrays.sort(intervals, (a , b) -> a[0] - b[0]);
        Arrays.sort(endIntervals, Comparator.comparingInt(a -> a[1]));

        int j = 0;
        for (int[] endInterval : endIntervals) {
            while (j < intervals.length && endInterval[1] > intervals[j][0]) {
                j++;
            }

            result[hashmap.get(endInterval)] = j == intervals.length ? -1 : hashmap.get(intervals[j]);
        }

        return result;
    }
}

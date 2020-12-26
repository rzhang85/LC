import java.util.Arrays;
import java.util.Comparator;

public class LC452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2){
                if (o1[1] <= 0 && o2[1] >= 0){
                    return -1;
                }
                if (o1[1] >= 0 && o2[1] <= 0){
                    return 1;
                }
                return o1[1] - o2[1];
            }

        });

        int result = 1;
        int currentEnd = points[0][1];
        for(int[] point : points){
            if(point[0] > currentEnd){
                result ++;
                currentEnd = point[1];
            }
            else{

            }
        }

        return result;
    }
}

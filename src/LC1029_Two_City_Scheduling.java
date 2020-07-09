import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1029_Two_City_Scheduling {

    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        // Assume everyone goes to A
        for (int[] cost : costs) {
            sum += cost[0];
        }

        List<Integer> costDiff_A = new ArrayList<>();
        for (int[] cost : costs) {
            costDiff_A.add(cost[1] - cost[0]);
        }
        Collections.sort(costDiff_A);
        for(int i = 0; i < costs.length/2; i ++){
            sum += costDiff_A.get(i);
        }

        return sum;

    }

}

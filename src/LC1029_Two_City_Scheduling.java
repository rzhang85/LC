import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1029_Two_City_Scheduling {

    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        // Assume everyone goes to A
        for (int i = 0; i < costs.length; i++){
            sum += costs[i][0];
        }

        List<Integer> costDiff_A = new ArrayList<>();
        for (int i = 0; i < costs.length; i ++){
            costDiff_A.add(costs[i][1] - costs[i][0]);
        }
        Collections.sort(costDiff_A);
        for(int i = 0; i < costs.length/2; i ++){
            sum += costDiff_A.get(i);
        }

        return sum;

    }

}

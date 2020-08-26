import java.util.HashSet;
import java.util.Set;

public class LC983 {

    int[] costs;
    Set<Integer> daySet;
    int[] calculated;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        daySet = new HashSet<>();
        calculated = new int[366];
        for(int day : days)
            daySet.add(day);

            return dp(1);
    }

    public int dp(int i){
        if(i > 365)
            return 0;

        if(calculated[i] != 0)
            return calculated[i];

        int answer = 0;
        if(daySet.contains(i)){
            answer = Math.min(dp(i + 1) + costs[0], Math.min(dp(i + 7) + costs[1], dp(i + 30) + costs[2]));
        }
        else{
            answer = dp(i + 1);
        }
        calculated[i] = answer;
        return answer;
    }


}

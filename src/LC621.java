import java.util.Arrays;

public class LC621 {

    public int leastInterval(char[] tasks, int n) {
        char[] frequency = new char[26];
        for(char c : tasks){
            frequency[c - 'A'] += 1;
        }

        Arrays.sort(frequency);

        int f_max = frequency[25];
        int idle_time = (f_max-1) * n;

        for(int i = 24; i >= 0 && idle_time > 0; i --){
            idle_time -= Math.min(frequency[i], f_max  - 1);
        }

        idle_time = Math.max(0, idle_time);
        return idle_time + tasks.length;

    }
}

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LC1286 {

    public Deque<String> combinations = new ArrayDeque<>();

    public LC1286(String characters, int combinationLength) {
        int n = characters.length();
        int total = 1 << n; // total number of possible combinations, which equals 2^n
        for (int bitmask = 0; bitmask < total; bitmask++) {
            if(Integer.bitCount(bitmask) == combinationLength){  // combination with right length
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if ((bitmask & (1 << n - j - 1)) != 0) {
                        sb.append(characters.charAt(j));
                    }
                }
                combinations.push(sb.toString());
            }
        }

    }

    public String next() {
        return combinations.pop();
    }

    public boolean hasNext() {
        return !combinations.isEmpty();
    }
}

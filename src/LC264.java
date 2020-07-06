import java.util.HashSet;
import java.util.PriorityQueue;

public class LC264 {
    public int nthUglyNumber(int n) {
        // Use heap to maintain order
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        heap.add((long)1);
        Long number = (long)1;

        while(n > 0){
            number = heap.poll();
            if(!seen.contains(number * 2)){
                seen.add(number * 2);
                heap.add(number * 2);
            }
            if(!seen.contains(number * 3)){
                seen.add(number * 3);
                heap.add(number * 3);
            }
            if(!seen.contains(number * 5)){
                seen.add(number * 5);
                heap.add(number * 5);
            }
            n --;
        }

        return number.intValue();

    }
}

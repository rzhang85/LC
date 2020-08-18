import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC967 {
    public int[] numsSameConsecDiff(int N, int K) {
        if(N == 1){
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        // Use a BFS to check layer by layer
        // initialize queue with 1,2,3,4,5,6,7,8,9
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        queue.addLast(4);
        queue.addLast(5);
        queue.addLast(6);
        queue.addLast(7);
        queue.addLast(8);
        queue.addLast(9);

        // iterate each layer
        for(int i = 1; i < N; i ++){
            int size = queue.size();
            // iterate each element in a particular layer
            for(int j = 0; j < size; j ++){
                Integer current = queue.pop();
                int remaining = current % 10;
                if(K != 0){
                    if(remaining - K >= 0){
                        queue.addLast((current * 10 + remaining - K));
                    }
                    if(remaining + K < 10){
                        queue.addLast((current * 10 + remaining + K));
                    }
                }
                else{
                    queue.addLast(current * 10 + remaining);
                }
            }
        }

        int[] result = new int[queue.size()];
        for(int i = 0; i < result.length; i ++){
            result[i] = queue.get(i);
        }

        return result;
    }
}

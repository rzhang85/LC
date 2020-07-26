import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC260 {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for(int i : nums){
            if(hashset.contains(i)){
                hashset.remove(i);
            }
            else{
                hashset.add(i);
            }
        }

        List<Integer> result = new ArrayList<>(hashset);
        int[] result_array = new int[result.size()];
        int i = 0;
        for(int number : result){
            result_array[i] = number;
            i++;
        }
        return result_array;
    }
}

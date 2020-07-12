import java.util.ArrayList;
import java.util.List;

public class LC78 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for(int i = 0; i <= nums.length; i ++){
            findSubSetsLengthK(nums, i, new ArrayList<Integer>(), 0);
        }

        return result;
    }

    public void findSubSetsLengthK(int[] nums, int K, ArrayList<Integer> current, int first){
        if(current.size() == K){
            result.add(new ArrayList(current));
            return;
        }

        for(int i = first; i < nums.length; i ++){
            current.add(nums[i]);

            findSubSetsLengthK(nums, K, current, i + 1);

            current.remove(current.size() - 1);
        }

    }
}

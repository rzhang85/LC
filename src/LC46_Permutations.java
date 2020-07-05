import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC46_Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LC46_Permutations tt = new LC46_Permutations();
        List<List<Integer>> result = tt.permute(nums);
        for (List<Integer> i : result){
            System.out.print(i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> numsList = new ArrayList<>();
        for(int num : nums){
            numsList.add(num);
        }
        backtracking(numsList, result, 0);
        return result;
    }

    public void backtracking (ArrayList<Integer> nums,
                              List<List<Integer>> result,
                              int startIndex){

        if(startIndex == nums.size()){
            result.add(new ArrayList<>(nums));
        }
        for(int i = startIndex; i < nums.size(); i ++ ){
            Collections.swap(nums, i, startIndex);
            backtracking(nums, result, startIndex+1);
            Collections.swap(nums, i, startIndex);

        }
    }
}

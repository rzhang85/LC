import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            if (nums[i] <= 0){
                if(i == 0 || nums[i-1] != nums[i]){
                    twoSum(nums, i, result);
                }
            }
            else{
                break;
            }
        }

        return result;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> result){
        int lo = i + 1;
        int high = nums.length - 1;
        while(lo < high){
            int sum = nums[lo] + nums[i] + nums[high];

            if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo - 1])){
                lo ++;
            }
            else if(sum > 0 || (high < nums.length - 1 && nums[high] == nums[high + 1])){
                high --;
            }
            else if(sum == 0){
                result.add(Arrays.asList(nums[lo] , nums[i], nums[high]));
                lo ++;
                high --;
            }

        }

    }
}

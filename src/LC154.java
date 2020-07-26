public class LC154 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int middle = (low + high) / 2;
            if(nums[middle] < nums[high]){
                high = middle;
            }
            else if(nums[middle] > nums[high]){
                low = middle + 1;
            }
            else{
                high -= 1;
            }


        }

        return nums[low];
    }
}

import java.util.Arrays;

public class LC55 {

    enum status{
        T,
        F,
        U
    }

    public boolean canJump(int[] nums) {
        status[] result = new status[nums.length];
        Arrays.fill(result, status.U);
        result[nums.length - 1] = status.T;
        for(int i = nums.length - 2; i >= 0; i --){
            if(result[i] == status.U){
                for(int j = 0; j < nums[i] && i + j < nums.length; j ++){
                    if(result[i + j + 1] == status.T){
                        result[i] = status.T;
                        break;
                    }
                }
                if(result[i] != status.T){
                    result[i] = status.F;
                }
            }


        }


        return result[0] == status.T;
    }

    public boolean canJump2(int[] nums) {
        int lastPos = 0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]+i >= lastPos){
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}

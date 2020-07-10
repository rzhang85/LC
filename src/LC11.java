public class LC11 {
    public int maxArea(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int current = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, current);

            // since the amount of water is bonded by lower edge, push lower edge to shrink width.
            if(height[left] < height[right]){
                left ++;
            }
            else{
                right --;
            }

        }

        return result;
    }
}

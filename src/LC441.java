public class LC441 {

    public int arrangeCoins(int n) {
        int left = 0, right = n;

        while(left < right - 1){
            int middle = (left + right) / 2;

            long sum = (1 + (long)middle) * (long)middle / 2;
            if (sum < n){
                left = middle;
            }
            else if(sum > n){
                right = middle;
            }
            else{
                return middle;
            }

        }

        return left;

    }

}

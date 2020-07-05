public class LC518 {

    public int change_2_sum = 0;
    public int[] coins;

    public int change(int amount, int[] coins) {
        if(amount == 0){
            return 1;
        }

        // Maintain an array to calculate number of combinations for each amount
        // compute this sliding array by each coin in increasing order
        int[] sliding = new int[amount + 1];

        sliding[0] = 1;

        for(int coin : coins){
            for(int current_amount = coin; current_amount < sliding.length; current_amount ++){
                sliding[current_amount] = sliding[current_amount] + sliding[current_amount-coin];
            }
        }

        return sliding[amount];

    }



    // Status: Time Limit Exceeded
    public int change_2(int amount, int[] coins){
        if (amount == 0)
            return 0;
        this.coins = coins;

        coin_Re(amount, 0);
        return change_2_sum;
    }


    public void coin_Re(int amount_left, int coin_index){

        if (amount_left == 0){
            change_2_sum ++;
            return;
        }
        if(coin_index >= coins.length){
            return;
        }

        else{
            int possible_range = amount_left/coins[coin_index] + 1;

            for(int i = 0; i < possible_range;  i ++){
                coin_Re(amount_left - i * coins[coin_index], coin_index + 1);
            }

        }

    }


}

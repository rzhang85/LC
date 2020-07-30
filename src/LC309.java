public class LC309 {
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;
        for(int price:prices){
            int old_sold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(old_sold, reset);
        }

        return Math.max(sold, reset);
    }
}

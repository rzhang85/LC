public class LC70 {
    public int climbStairs(int n) {
        if(n < 2){
            return 1;
        }
        int[] nTrack = new int[n + 1];
        nTrack[0] = 1;
        nTrack[1] = 1;
        for(int i = 2; i < nTrack.length; i ++){
            nTrack[i] = nTrack[i - 1] + nTrack[i - 2];
        }
        return nTrack[n];
    }
}

public class LC461 {
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int sum = 0;
        while(z > 0){
            sum += z%2;
            z = z >> 1;
        }

        return sum;
    }
}

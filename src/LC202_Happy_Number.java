import java.util.HashSet;

public class LC202_Happy_Number {


    public boolean isHappy(int n) {
        HashSet<Integer> notHappy = new HashSet<>();

        while(notHappy.add(n)){
            int sum = 0;
            while(n > 0){
                sum += (n%10) * (n%10);
                n /= 10;
            }
            if(sum == 1)
                return true;
            n = sum;
        }

        return false;
    }
}


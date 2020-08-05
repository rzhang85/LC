import java.util.ArrayList;
import java.util.List;

public class LC342 {
    public boolean isPowerOfFour(int num) {
        Power p = new Power();
        return p.numbers.contains(num);
    }
}

class Power{
    private final int n = 15;
    public List<Integer> numbers = new ArrayList<>();

    public Power(){
        int current = 1;
        numbers.add(current);
        for(int i = 1; i <= n; i ++){
            current = current * 4;
            numbers.add(current);

        }

    }

}

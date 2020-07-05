import java.util.ArrayList;

public class LC60 {

    public String getPermutation(int n, int k) {
        if(n == 1)
            return "1";

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        StringBuilder result = new StringBuilder();
        int factorial = 1;
        int temp = k - 1;

        for (int i = 1; i < n ; i ++){
            factorial *= i;
            numbers.add(i + 1);
        }

        for(int j = n - 1; j > 0; j --){
            int currentIndex = temp / factorial;
            result.append(numbers.get(currentIndex));

            numbers.remove(currentIndex);
            temp = temp - currentIndex * factorial;
            factorial = factorial/j;

        }
        result.append(numbers.get(0));

        return result.toString();
    }
}

import java.util.HashSet;
import java.util.Scanner;

public class Home {
    public static int target = 2;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        String str = "520";

        permutation(str, "");
        System.out.println(set.size());
    }

    public static void permutation(String str, String ans){
        if(str.length() == 0){
            int num = Integer.parseInt(ans);
            if(num % target == 0)
                set.add(num);
            return;
        }
        for(int i = 0; i < str.length(); i ++){
            char c = str.charAt(i);

            String tmp = str.substring(0, i) + str.substring(i + 1);
            permutation(tmp, ans + c) ;
        }

    }

}

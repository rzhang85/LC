import java.util.ArrayList;

public class LC459 {


    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n < 2){
            return false;
        }
        if(n == 2){
            return s.charAt(0) == s.charAt(1);
        }

        for(int i = (int)Math.sqrt(n); i > 0; i --){        // e.g. 16 = 1*16, 2*8, 4*4, the first number will range in [0, sqrt(n)]
            if(n % i == 0){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                if(i != 1)
                    list.add(n / i);

                // check two number each time
                for(int len : list){
                    String str = s.substring(0, len);
                    int firstHash = str.hashCode();
                    int currentHash = str.hashCode();
                    int index = len;
                    while(index != n && firstHash == currentHash){
                        str = s.substring(index, index + len);
                        currentHash = str.hashCode();
                        index += len;
                    }
                    if(index == n && firstHash == currentHash){
                        return true;
                    }
                }

            }

        }
        return false;
    }
}

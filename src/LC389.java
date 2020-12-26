import java.util.HashMap;

public class LC389 {

    public char findTheDifference(String s, String t) {
        int[] counter = new int[26];
        for(char c : s.toCharArray()){
            counter [c - 'a'] ++;
        }
        for(char c : t.toCharArray()){
            counter[c - 'a'] --;
            if(counter[c - 'a'] < 0){
                return c;
            }
        }


        return ' ';
    }


}

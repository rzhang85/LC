import java.util.ArrayList;
import java.util.List;

public class LC763 {
    public List<Integer> partitionLabels(String S) {
        // record the last seen index of each character
        int[] last = new int[26];
        for(int i = 0; i < S.length(); i ++){
            last[S.charAt(i) - 'a'] = i;
        }


        ArrayList<Integer> res = new ArrayList<>();
        int j = 0; int currentStart = 0;
        for(int i = 0; i < S.length(); i ++){
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if(j == i){ // if current character's last apperance is current index, do a partition
                res.add(i - currentStart + 1);
                currentStart = i + 1;
            }


        }


        return res;

    }
}

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        HashMap<Character, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < t.length(); i ++){
            Integer count = hashmap.get(t.charAt(i));
            if(count == null){
                hashmap.put(t.charAt(i), 1);
            }
            else{
                hashmap.put(t.charAt(i), count + 1);
            }
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE, resultIndex = 0 ,matchCount = 0;
        for(right = 0; right < s.length(); right ++){
            char ch = s.charAt(right);
            Integer count = hashmap.get(ch);
            if(count == null){
                continue;
            }

            // find an related character
            hashmap.put(ch, count - 1);
            if(count == 1){
                // 1 -> 0, find a match
                matchCount ++;
            }

            while(matchCount == hashmap.size()){
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    resultIndex = left;
                }
                char chLeftMost = s.charAt(left);
                left += 1;
                Integer leftMostCount = hashmap.get(chLeftMost);
                if(leftMostCount == null){
                    continue;
                }
                hashmap.put(chLeftMost, leftMostCount + 1);
                if(leftMostCount == 0){
                    // 0 - > 1
                    matchCount --;
                }
            }


        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(resultIndex, resultIndex + minLength);
    }
}

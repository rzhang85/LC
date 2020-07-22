import java.util.HashMap;

public class LC159 {
    HashMap<Character, Integer> words = new HashMap<>();
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            words.put(c, right);

            if(words.size() > 2){
                int leftMost = s.length();
                for(int index: words.values())
                    leftMost = Math.min(leftMost, index);

                left = leftMost + 1;
                words.remove(s.charAt(leftMost));
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right ++;
        }

        return maxLength;
    }
}

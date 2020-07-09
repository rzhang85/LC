public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        int[] alpha = new int[128];
        int result = 0;
        int lastAppear = 0;
        for(int i = 0; i < s.length(); i ++){
            // find the last appear of current char
            lastAppear = Math.max(alpha[s.charAt(i)], lastAppear);
            result = Math.max(result, i - lastAppear + 1);
            alpha[s.charAt(i)] = i + 1;

        }

        return result;
    }
}

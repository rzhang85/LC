import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC151 {

    public String reverseWords(String s) {
        s = s.trim();

        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);

        return String.join(" ", words);
    }


    // In C++, you can perform this in O(1) space

    public String reverseWords_C(String s) {
        s = s.trim();
        char[] charArray = s.toCharArray();
        List<Character> words = new ArrayList<>();
        for(char c : charArray)
            words.add(c);

        // reverse the entire string
        int start = 0, end = words.size() - 1;
        while(start < end){
            char tmp = words.get(start);
            words.set(start, words.get(end));
            words.set(end, tmp);
            start ++;
            end --;
        }

        // reverse each word based on space
        int startIndex = 0;

        for(int i = 0; i < words.size(); i ++){
            if(i == words.size() - 1){
                reverseWord(words, startIndex, i);
                break;
            }

            if(words.get(i) == ' '){
                reverseWord(words, startIndex, i - 1);
                while(words.get(i + 1) == ' '){
                    words.remove(i + 1);
                }
                startIndex = i + 1;
            }
        }


        StringBuilder sb = new StringBuilder();
        for(char c : words){
            sb.append(c);
        }

        return sb.toString();
    }

    public void reverseWord(List<Character> words, int start, int end){
        while(start < end){
            char tmp = words.get(start);
            words.set(start, words.get(end));
            words.set(end, tmp);
            start ++;
            end --;
        }
    }
}

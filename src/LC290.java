import java.util.HashMap;

public class LC290 {
    public boolean wordPattern(String pattern, String str) {
        HashMap hashmap = new HashMap();
        String[] words = str.split(" ");
        if(pattern.length() != words.length)
            return false;


        for(int i = 0; i < words.length; i ++){
            if(!hashmap.containsKey(words[i])){
                hashmap.put(words[i], i);
            }
            if(!hashmap.containsKey(pattern.charAt(i))){
                hashmap.put(pattern.charAt(i), i);
            }
            if(!hashmap.get(words[i]).equals(hashmap.get(pattern.charAt(i))))
                return false;
        }


        return true;
    }
}

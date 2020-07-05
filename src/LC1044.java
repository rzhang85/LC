import java.util.HashSet;

public class LC1044 {

    public String longestDupSubstring(String S){

        // used for binary search on largest substring length
        int left = 1, right = S.length();
        int middle;


        int[] Ascii = new int[S.length()];
        for(int i = 0; i < S.length(); i ++){
            Ascii[i] = S.charAt(i) - 97;
        }

        while(left <= right){
            middle = (left + right) / 2 ;
            if (searchWithLength(Ascii, middle) == -1)
                right = middle - 1 ;
            else
                left = middle + 1;

        }

        int startIndex = searchWithLength(Ascii, left - 1);
        if(startIndex == -1)
            return "";
        return S.substring(startIndex, startIndex + left -1);
    }

    public int searchWithLength(int[] string, int K){
        HashSet<Long> hashes = new HashSet<>();

        // use this module to prevent overflow
        long modulus = (long)Math.pow(2, 32);
        long aL = 1;
        for (int i = 1; i <= K; i++)
            aL = (aL * 26) % modulus;

        // add first sub string with length K
        long hash = 0;
        for(int i = 0 ; i < K; i ++){
            hash = (hash * 26 +  string[i]) % modulus;
        }
        hashes.add(hash);

        // compare each sub string by hashset from index 1 to n-K
        for (int i = 1; i <= string.length - K; i ++){
            hash = (hash * 26 - string[i - 1] * aL % modulus + modulus) % modulus;
            hash = (hash + string[i + K - 1]) % modulus;
            if(hashes.contains(hash))
                return i;

            hashes.add(hash);
        }

        return -1;
    }

}


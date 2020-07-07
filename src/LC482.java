public class LC482 {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "");
        int l = S.length();
        if(l <= K){
            return S;
        }
        int index = l % K;
        StringBuilder sb = new StringBuilder();

        if(index != 0){
            sb.append(S.substring(0, index));
            sb.append("-");
        }
        while(index < l){
            sb.append(S.substring(index , index + K));
            sb.append("-");
            index += K;
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}

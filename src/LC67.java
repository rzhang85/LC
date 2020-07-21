public class LC67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int maxLength = Math.max(a.length(), b.length());

        int increament = 0;
        for(int i = 0;i < maxLength; i ++){
            int a_i = 0, b_i = 0;
            if(i < a.length())
                a_i = a.charAt(a.length() - i - 1) == '0' ? 0 : 1;
            if(i < b.length())
                b_i = b.charAt(b.length() - i - 1) == '0' ? 0 : 1;

            int sum = a_i + b_i + increament;
            if(sum == 0){
                sb.append("0");
                increament = 0;
            }
            else if (sum == 1){
                sb.append("1");
                increament = 0;
            }
            else if(sum == 2){
                sb.append("0");
                increament = 1;
            }
            else if(sum == 3){
                sb.append("1");
                increament = 1;
            }
        }
        if(increament == 1){
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}

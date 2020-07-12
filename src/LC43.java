public class LC43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int[] result = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i --){
            for(int j = num2.length() - 1; j >=0; j --){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int current = a * b;
                // insert current number to i+j, i+j+1
                int previousValue = result[i+j+1];  // plus remaining value before
                current += previousValue;
                result[i+j] += current / 10;
                result[i+j+1] = current % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length ; i ++){
            if (!(i == 0 && result[i] == 0))
                sb.append(result[i]);
        }
        return sb.toString();
    }
}

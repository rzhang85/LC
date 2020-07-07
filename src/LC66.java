public class LC66 {
    public int[] plusOne(int[] digits) {

        for(int i = digits.length - 1; i >= 0; i --){
            if(digits[i] + 1 < 10){
                digits[i] += 1;
                break;
            }
            else{
                digits[i] = 0;
            }
        }

        if(digits[0] == 0){
            int[] newDigits = new int[digits.length + 1];
            for(int i = 0; i < digits.length; i ++){
                newDigits[i + 1] = digits[i];
            }
            newDigits[0] = 1;
            return newDigits;
        }
        else{
            return digits;
        }

    }
}

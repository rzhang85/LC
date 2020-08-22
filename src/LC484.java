import java.util.Stack;

public class LC484 {

    public int[] findPermutation(String s) {
        int[] result = new int[s.length() + 1];
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == 'I'){
                stack.push(i + 1);
                while(!stack.isEmpty()){
                    result[j] = stack.pop();
                    j ++;
                }
            }
            else{
                stack.push(i + 1);
            }
        }
        stack.push(s.length() + 1);
        while(!stack.isEmpty()){
            result[j] = stack.pop();
            j++;
        }



        return result;
    }
}

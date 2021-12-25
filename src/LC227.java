import java.util.Stack;

public class LC227 {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        char lastOperation = '+';

        for (char c : s.toCharArray()) {
            if (c == ' ') {

            } else if (Character.isDigit(c)) {
                // save digit to temp
                sb.append(c);
            } else {
                String str = sb.toString();
                int current = Integer.parseInt(str);
                sb.setLength(0);

                // check lastOperation

                switch (lastOperation) {
                    case '+':
                    case '-':
                        if (lastOperation == '-') {
                            stack.push(-current);
                        } else {
                            stack.push(current);
                        }
                        break;
                    case '*':
                        int previous = (int) stack.pop();
                        current = previous * current;
                        stack.push(current);
                        break;
                    case '/':
                        int previousNum = (int) stack.pop();
                        current = previousNum / current;
                        stack.push(current);
                        break;
                }
                lastOperation = c;
            }
        }

        int current = Integer.parseInt(sb.toString());

        if (lastOperation == '-') {
            current = -current;
        }
        else if (lastOperation == '*'){
            int previousNum = (int) stack.pop();
            current = previousNum * current;
        }
        else if(lastOperation == '/'){
            int previousNum = (int) stack.pop();
            current = previousNum / current;
        }

        int result = current;

        while (!stack.isEmpty()) {
            int previous = (int) stack.pop();
            result = previous + result;
        }

        return result;
    }


}

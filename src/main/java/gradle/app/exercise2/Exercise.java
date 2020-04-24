package gradle.app.exercise2;

import java.io.IOException;
import java.util.Stack;

public class Exercise {
    public String getTokens(String expression) throws IOException {
        TokenStream ts = new TokenStreamReader(expression);
        StringBuilder sb = new StringBuilder();
        while (ts.getToken().tokenType != Token.TokenType.NONE) {
            sb.append(ts.getToken());
            ts.consumeToken();
        }
        return sb.toString();
    }

    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != ch) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

}

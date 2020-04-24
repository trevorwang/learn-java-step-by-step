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

    public int compute(String expression) throws IOException {
        TokenStream ts = new TokenStreamReader(expression);
        Stack<Token> stack = new Stack<>();
        while (ts.getToken().tokenType != Token.TokenType.NONE) {
            Token t = ts.getToken();
            if (t.tokenType == Token.TokenType.INT) {
                stack.push(t);
            }
            switch (t.tokenType) {
                case MULT:
                    int v1 = (Integer) stack.pop().value;
                    int v2 = (Integer) stack.pop().value;
                    stack.push(new Token(Token.TokenType.INT, v2 * v1));
                    break;
                case DIV:
                    v1 = (Integer) stack.pop().value;
                    v2 = (Integer) stack.pop().value;
                    stack.push(new Token(Token.TokenType.INT, v2 / v1));
                    break;
                case MINUS:
                    v1 = (Integer) stack.pop().value;
                    v2 = (Integer) stack.pop().value;
                    stack.push(new Token(Token.TokenType.INT, v2 - v1));
                    break;
                case PLUS:
                    v1 = (Integer) stack.pop().value;
                    v2 = (Integer) stack.pop().value;
                    stack.push(new Token(Token.TokenType.INT, v2 + v1));
                    break;
            }
            ts.consumeToken();
        }
        return (Integer) stack.pop().value;
    }

}

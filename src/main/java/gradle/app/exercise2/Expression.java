package gradle.app.exercise2;

import java.io.IOException;

import static gradle.app.exercise2.Token.TokenType.*;

public class Expression {
    public TokenStream ts;

    public Expression(String expr) {
        ts = new TokenStreamReader(expr);
    }

    public int evaluate() {
        int t = term();
        Token op = null;

        try {
            op = ts.getToken();
            while (op.tokenType == PLUS || op.tokenType == MINUS) {
                ts.consumeToken();
                int t2 = term();
                if (op.tokenType == PLUS) {
                    t += t2;
                } else {
                    t -= t2;
                }

                op = ts.getToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    private int term() {
        int t = factor();

        Token op = null;
        try {
            op = ts.getToken();

            while (op.tokenType == MULT || op.tokenType == DIV) {
                ts.consumeToken();
                int t2 = factor();
                if (op.tokenType == MULT) {
                    t *= t2;
                } else {
                    t /= t2;
                }
                op = ts.getToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    private int factor() {
        Token t = null;
        try {
            t = ts.getToken();
            if (t.tokenType == INT) {
                ts.consumeToken();
                return ((Integer) t.value);
            } else if (t.tokenType == LPAR) {
                ts.consumeToken();
                int v = evaluate();
                match(ts.getToken(), RPAR);
                return v;
            } else if (t.tokenType == MINUS) {
                ts.consumeToken();
                return -factor();
            } else {
                throw new IOException("Illegal Expression!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // should not reach here
        return 0;
    }

    private void match(Token t, Token.TokenType tt) {
        assert t.tokenType == tt;
        ts.consumeToken();
    }
}

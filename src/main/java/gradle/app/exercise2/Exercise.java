package gradle.app.exercise2;

import java.io.IOException;

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
}

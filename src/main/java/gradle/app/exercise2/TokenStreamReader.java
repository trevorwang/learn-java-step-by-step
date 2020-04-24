package gradle.app.exercise2;

import java.io.IOException;
import java.io.StringReader;

public class TokenStreamReader extends StringReader implements TokenStream {

    int mChar = Integer.MIN_VALUE;
    Token mCurrentToken = null;

    public TokenStreamReader(String in) {
        super(in);
    }

    @Override
    public Token getToken() throws IOException {
        if (mCurrentToken == null) {
            mCurrentToken = getNextToken();
        }
        return mCurrentToken;
    }

    private Token getNextToken() throws IOException {
        int ch = readValidChar();
        char chChar = (char) ch;
        mChar = Integer.MIN_VALUE;
        if (ch == -1) {
            return Token.NONE;
        } else if (ch == '(') {
            return new Token(Token.TokenType.LPAR, chChar);
        } else if (ch == ')') {
            return new Token(Token.TokenType.RPAR, chChar);
        } else if (ch == '+') {
            return new Token(Token.TokenType.PLUS, chChar);
        } else if (ch == '-') {
            return new Token(Token.TokenType.MINUS, chChar);
        } else if (ch == '*') {
            return new Token(Token.TokenType.MULT, chChar);
        } else if (ch == '/') {
            return new Token(Token.TokenType.DIV, chChar);
        } else if (ch <= '9' && ch >= '0') {
            mChar = ch;
            String number = readNumber();
            return new Token(Token.TokenType.INT, Integer.valueOf(number));
        }
        return Token.NONE;
    }

    private int readValidChar() throws IOException {
        if (mChar == Integer.MIN_VALUE) {
            mChar = read();
        }
        while (mChar == ' ') {
            mChar = read();
        }
        return mChar;
    }

    private String readNumber() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (mChar >= '0' && mChar <= '9') {
            sb.append(mChar - '0');
            mChar = read();
        }
        return sb.toString();
    }

    @Override
    public void consumeToken() {
        mCurrentToken = null;
    }
}

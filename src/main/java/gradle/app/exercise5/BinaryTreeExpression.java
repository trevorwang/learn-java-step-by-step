package gradle.app.exercise5;

import gradle.app.exercise2.Token;
import gradle.app.exercise2.TokenStream;
import gradle.app.exercise2.TokenStreamReader;

import java.io.IOException;

import static gradle.app.exercise2.Token.TokenType.*;

public class BinaryTreeExpression {
    public TokenStream ts;

    public BinaryTreeExpression(String expr) {
        ts = new TokenStreamReader(expr);
    }

    public Node<Token> expression() {
        Node<Token> left = term();

        try {
            while (ts.getToken().tokenType == PLUS || ts.getToken().tokenType == MINUS) {
                if (match(PLUS)) {
                    Node<Token> root = new Node<>(new Token(PLUS, "+"));
                    root.left = left;
                    root.right = term();
                    left = root;
                } else if (match(MINUS)) {
                    Node<Token> root = new Node<>(new Token(MINUS, "-"));
                    root.left = left;
                    root.right = term();
                    left = root;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return left;
    }

    private Node<Token> term() {
        Node<Token> left = factor();
        try {
            while (ts.getToken().tokenType == MULT || ts.getToken().tokenType == DIV) {
                if (match(MULT)) {
                    Node<Token> root = new Node<>(new Token(MULT, "*"));
                    root.left = left;
                    root.right = factor();
                    left = root;
                } else if (match(DIV)) {
                    Node<Token> root = new Node<>(new Token(Token.TokenType.DIV, "/"));
                    root.left = left;
                    root.right = factor();
                    left = root;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return left;
    }

    private Node<Token> factor() {
        Token t = null;
        Node<Token> left;
        try {
            t = ts.getToken();

            if (t.tokenType == INT) {
                ts.consumeToken();
                return new Node<Token>(t);
            } else if (match(LPAR)) {
                Node<Token> v = expression();
                assert match(RPAR);
                return v;
            } else if (match(MINUS)) {
                Node<Token> v = new Node<>(new Token(INT, 0));
                Node<Token> root = new Node<>(new Token(MINUS, "-"));
                root.left = v;
                root.right = factor();
                return root;
            } else {
                throw new IOException("Illegal Expression!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // should not reach here
        return null;
    }

    private boolean match(Token.TokenType tt) throws IOException {
        if (ts.getToken().tokenType == tt) {
            ts.consumeToken();
            return true;
        }
        return false;
    }
}

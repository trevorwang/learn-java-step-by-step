package gradle.app.exercise2;

public class Token implements Comparable<Token> {
    @Override
    public int compareTo(Token o) {
        return (o.tokenType == this.tokenType && o.value.equals(this.value)) ? 0 : -1;
    }

    public enum TokenType {
        LPAR,  // (
        RPAR,  // )
        PLUS,   // +
        MINUS,  // -
        MULT,  // *
        DIV,   // /
        INT,   //  0...9
        NONE,  //
    }

    public final static Token NONE = new Token(TokenType.NONE, null);

    public TokenType tokenType;
    public Object value;

    public Token(TokenType tt, Object v) {
        this.tokenType = tt;
        this.value = v;
    }

    @Override
    public String toString() {
        String vString;
        if (value instanceof Integer) {
            vString = "INTEGER(" + value.toString() + ")";
        } else {
            vString = "\"" + value.toString() + "\"";
        }
        return "{" + tokenType.toString()
                + "," + vString
                +
                '}';
    }
}

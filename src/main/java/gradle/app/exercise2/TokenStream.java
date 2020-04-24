package gradle.app.exercise2;

import java.io.IOException;

public interface TokenStream {
    Token getToken() throws IOException;
    void consumeToken();
}

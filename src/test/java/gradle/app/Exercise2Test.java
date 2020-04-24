package gradle.app;

import gradle.app.exercise2.Exercise;
import org.junit.Test;

import java.io.IOException;

public class Exercise2Test {
    @Test
    public void testGetTokens() throws IOException {
        Exercise e = new Exercise();
        System.out.println(e.getTokens("(5 + 8) * 13"));
    }
}

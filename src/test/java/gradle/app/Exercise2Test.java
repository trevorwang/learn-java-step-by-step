package gradle.app;

import gradle.app.exercise2.Exercise;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Exercise2Test {
    @Test
    public void testGetTokens() throws IOException {
        Exercise e = new Exercise();
        System.out.println(e.getTokens("(5 + 8) * 13"));
    }


    @Test
    public void testIsValidParentheses() {
        Exercise e = new Exercise();
        assertTrue(e.isValidParentheses("((()))"));
        assertTrue(e.isValidParentheses("[({})]"));
        assertFalse(e.isValidParentheses("[({(})]"));

        assertFalse(e.isValidParentheses("((("));
        assertFalse(e.isValidParentheses("((())1)1"));
        assertFalse(e.isValidParentheses("(1231"));
        assertFalse(e.isValidParentheses("((123123)1)1"));
        assertFalse(e.isValidParentheses("((((){{}1)1"));
        assertFalse(e.isValidParentheses("((()){}{}{}{((())))1"));
    }

    @Test
    public void testCompute() throws IOException {
        Exercise e = new Exercise();
        assertEquals(6, e.compute("8 5 - 4 2 - *"));
        assertEquals(9, e.compute("8 5 - 5 2 - *"));
        assertEquals(80, e.compute("8 5 * 4 2 - *"));
    }
}

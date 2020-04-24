package gradle.app;

import gradle.app.exercise2.Exercise;
import gradle.app.exercise2.Expression;
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


    @Test
    public void testExpression() {
        assertEquals(6, new Expression("2 * 3").evaluate());
        assertEquals(14, new Expression("2 * 3 + 8").evaluate());
        assertEquals(3, new Expression("(2 -1)* 3").evaluate());
        assertEquals(16, new Expression("2 * (3 +5)").evaluate());

        assertEquals(-6, new Expression("-2 * 3").evaluate());
        assertEquals(-3, new Expression("-(-1) * ---3").evaluate());

    }
}

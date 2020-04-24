package gradle.app;

import gradle.app.exercise3.Exercise3;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Exercise3Test {

    @Test
    public void testFindNonRepeatNumbers() {
        assertEquals(6, Exercise3.findNonRepeatNumbers(new int[]{1, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 7, 7}));
    }

    @Test
    public void testFindTwoNonRepeatNumbers() {
        final int[] expected = new int[]{6, 7};
        int[] results = Exercise3.findTwoNonRepeatNumbers(new int[]{1, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 7,});
        Arrays.sort(expected);
        Arrays.sort(results);
        assertArrayEquals(expected, results);
    }
}

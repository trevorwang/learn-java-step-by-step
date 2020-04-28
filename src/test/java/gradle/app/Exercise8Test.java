package gradle.app;

import gradle.app.exercise6.Sorter;
import gradle.app.exercise8.Exercise8;
import gradle.app.exercise8.MergeSorter;
import gradle.app.exercise8.QuickSorter;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class Exercise8Test {

    @Test
    public void testSqrt() {
        assertEquals(null, 2, Exercise8.mySqrt(4), 0.0001);
        assertEquals(null, 3, Exercise8.myCubert(27), 0.0001);
    }

    @Test
    public void testQuickSort() {
        int[] array = new int[]{13, 1, 3, 19, 8, 9, 7, 2};
        Sorter sorter = new QuickSorter();
        sorter.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testMergeSort() {
        int[] array = new int[]{13, 1, 3, 19, 8, 9, 7, 2};
        Sorter sorter = new MergeSorter();
        sorter.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

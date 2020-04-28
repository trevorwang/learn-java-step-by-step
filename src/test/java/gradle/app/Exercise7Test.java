package gradle.app;

import gradle.app.exercise6.Sorter;
import gradle.app.exercise7.HeadUtils;
import gradle.app.exercise7.HeapSorter;
import org.junit.Test;

import java.util.Arrays;

public class Exercise7Test {
    @Test
    public void testHeapArray() {
        int[] array = new int[]{100, 3, 4, 56, 6};
        HeadUtils.buildUpHeap(array);
        System.out.println(Arrays.toString(array));
    }


    @Test
    public void testHeapSort() {
        int[] array = new int[]{1, 3, 19, 8, 9, 7, 2};
        Sorter sorter = new HeapSorter();
        sorter.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

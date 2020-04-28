package gradle.app.exercise7;

import gradle.app.exercise6.Sorter;

public class HeapSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        HeadUtils.buildUpHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            int t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;
            HeadUtils.maxHeapify(arr, i, 0);
        }
    }
}

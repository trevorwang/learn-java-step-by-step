package gradle.app.exercise8;

import gradle.app.exercise6.Sorter;

public class QuickSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin >= end)
            return;

        int k = partition(arr, begin, end);
        quickSort(arr, begin, k - 1);
        quickSort(arr, k + 1, end);
    }

    private int partition(int[] arr, int begin, int end) {
        int x = arr[begin];
        int i = begin;
        for (int j = i + 1; j <= end; j++) {
            if (arr[j] <= x) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int t = arr[i];
        arr[i] = arr[begin];
        arr[begin] = t;
        return i;
    }
}

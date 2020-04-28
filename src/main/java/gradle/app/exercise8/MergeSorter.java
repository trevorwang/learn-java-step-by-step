package gradle.app.exercise8;

import gradle.app.exercise6.Sorter;

public class MergeSorter implements Sorter {
    int[] array2;

    @Override
    public void sort(int[] arr) {
        array2 = new int[arr.length];
        int begin = 0;
        int end = arr.length - 1;
        mergeSort(arr, begin, end);
    }

    private void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, begin, mid, end);
        }
    }


    private void merge(int[] array, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j])
                array2[k++] = array[i++];
            else
                array2[k++] = array[j++];
        }

        while (i <= mid)
            array2[k++] = array[i++];

        while (j <= high)
            array2[k++] = array[j++];


        for (i = low; i <= high; i++) {
            array[i] = array2[i];
        }
    }
}

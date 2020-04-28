package gradle.app.exercise8;

import gradle.app.exercise6.Sorter;

import java.util.Arrays;

public class MergeSorter implements Sorter {
    int[] array2;

    @Override
    public void sort(int[] arr) {
        array2 = new int[arr.length];
        int begin = 0;
        int end = arr.length - 1;
        mergeSortLoop(arr);
    }

    private void mergeSortLoop(int[] array) {
        int len = 1;
        while (array.length > len) {
            for (int i = 0; i + len < array.length; i += len * 2) {
                int left = i;
                int mid = i + len - 1;
                int right = i + len * 2 - 1;
                if (right > array.length - 1) {
                    right = array.length - 1;
                }
                merge(array, left, mid, right);
            }
            len <<= 1;
        }

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
        System.out.println(String.format("merge from : %d,  %d, %d", low, mid, high));
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
        System.out.println(Arrays.toString(array));
    }
}

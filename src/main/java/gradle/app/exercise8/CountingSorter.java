package gradle.app.exercise8;

import gradle.app.exercise6.Sorter;

public class CountingSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        final int MAX = 1024;
        int[] b = new int[MAX];
        for (int a : arr) {
            b[a] += 1;
        }
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            int value = b[i];
            while (value > 0) {
                arr[j++] = i;
                value--;
            }
        }

    }
}

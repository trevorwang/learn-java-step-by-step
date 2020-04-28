package gradle.app.exercise6;

public class InsertionSorter implements Sorter {
    @Override
    public void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int p = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (p < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = p;
        }
    }
}

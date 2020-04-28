package gradle.app.exercise6;

public class ChooseSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        int povit, pos = -1;
        for (int i = 0; i < arr.length; i++) {
            povit = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (povit > arr[j]) {
                    pos = j;
                    povit = arr[j];
                }
            }
            arr[pos] = arr[i];
            arr[i] = povit;
        }
    }
}

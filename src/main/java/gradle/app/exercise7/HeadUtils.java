package gradle.app.exercise7;

public class HeadUtils {
    public static void maxHeapify(int[] arr, int length, int root) {
        if (root >= length) return;

        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            int t = arr[root];
            arr[root] = arr[largest];
            arr[largest] = t;
            maxHeapify(arr, length, largest);
        }
    }

    public static void buildUpHeap(int[] arr) {
        if (arr.length <= 1)
            return;

        int n = (arr.length - 2) / 2;

        while (n >= 0) {
            maxHeapify(arr, arr.length, n);
            n--;
        }
    }
}

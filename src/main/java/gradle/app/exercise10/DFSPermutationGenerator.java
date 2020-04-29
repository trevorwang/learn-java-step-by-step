package gradle.app.exercise10;

import java.util.Arrays;

public class DFSPermutationGenerator {
    public int N;
    private boolean[] used;
    private int[] result;

    public DFSPermutationGenerator(int n) {
        N = n;
        used = new boolean[n + 1];
        result = new int[n];
    }

    public void make(int level) {
        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                System.out.println(Arrays.toString(used));
                used[i] = true;
                result[level] = i;
                make(level + 1);
                used[i] = false;
            }
        }

        if (level == N - 1) {
            System.out.println(Arrays.toString(result));
        }
    }
}

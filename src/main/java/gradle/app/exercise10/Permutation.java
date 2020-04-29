package gradle.app.exercise10;

import java.util.Arrays;

public class Permutation {
    public static int[] decode(int index, int len) {
        int i, base, j;
        int[] auxiliary = new int[len];
        auxiliary[len - 1] = 0;
        int[] result = new int[len];

        base = 2;
        for (i = len - 2; i >= 0; i--) {
            auxiliary[i] = index % base;
            index /= base;
            base++;
        }

//        System.out.println(Arrays.toString(auxiliary));

        for (i = 1; i <= len; i++) {
            for (j = 0; j < len; j++) {
                if (auxiliary[j] == 0) {
                    result[j] = i;
                    auxiliary[j] = -1;
                    break;
                } else if (auxiliary[j] > 0)
                    auxiliary[j]--;
            }
        }

//        System.out.println(Arrays.toString(result));
//        System.out.println();
        return result;
    }

    public static int encode(int[] array, int len) {
        int i, j, single, base, total = 0;
        if (len < 3)
            return -1;

        base = 1;
        for (i = len - 2; i >= 0; i--) {
            single = 0;
            base *= len - i - 1;
            for (j = len - 1; j > i; j--) {
                if (array[i] > array[j])
                    single++;
            }
            total += single * base;
        }
        return total;
    }
}

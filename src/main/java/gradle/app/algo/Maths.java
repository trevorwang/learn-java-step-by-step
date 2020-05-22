package gradle.app.algo;

public class Maths {
    public static double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) return 1;
        int sign = 1;
        if (exponent < 0) {
            sign = -1;
            exponent = -exponent;
        }

        double result = 1;

        while (exponent > 0) {
            if (sign > 0) {
                result *= base;
            } else {
                result /= base;
            }
            exponent--;
        }
        return result;
    }


    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0) return;
        int index = array.length - 1;

        while (index >= 0) {

            if ((array[index] & 1) == 0) {  // find even
                int tmp = array[index];
                boolean moved = false;
                int j = index + 1;
                for (; j < array.length; j++) {
                    if ((array[j] & 1) == 1) {
                        array[j - 1] = array[j];
                        moved = true;
                    } else {
                        break;
                    }
                }
                array[--j] = tmp;
            }
            index--;
        }

    }
}

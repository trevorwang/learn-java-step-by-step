package gradle.app.exercise3;

public class Exercise3 {

    public static int findNonRepeatNumbers(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value ^= num;
        }
        return value;
    }

    public static int[] findTwoNonRepeatNumbers(int[] nums) {
        int[] results = new int[]{0, 0};

        // 找到两个数的异或值
        int xorVal = 0;
        for (int num : nums) {
            xorVal ^= num;
        }

        // 找到这个数字中不为1的bit
        int pos = 0;
        while ((xorVal & 1) == 0) {
            xorVal >>= 1;
            pos++;
        }

        for (int num : nums) {
            if (((num >> pos) & 1) != 0) {  // 按照这个bit为1 和不为1分组异或
                results[0] ^= num;
            } else {
                results[1] ^= num;
            }
        }
        return results;
    }
}

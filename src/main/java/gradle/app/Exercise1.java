package gradle.app;

public class Exercise1 {

    public String oct2Bin(int a) {

        int sign = 0;
        if (a < 0) {
            sign = 1;
            a = Math.abs(a);
        }

        byte[] digits = getNumByteArray(a);
        if (sign == 1) {
            for (int i = 1; i < digits.length; i++) {
                digits[i] = (byte) ((digits[i] + 1) % 2);
            }

            int carry = 0;
            int start = digits.length - 1;
            int tmp = digits[start] + 1;
            carry = tmp / 2;
            digits[start] = (byte) (tmp % 2);
            do {
                start--;
                tmp = digits[start] + carry;
                carry = tmp / 2;
                digits[start] = (byte) (tmp % 2);
            } while (carry != 0 && start > 0);

            digits[0] = 1;
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (byte digit : digits) {
            if (digit != 0) {
                flag = true;
            }
            if (flag) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public String transform(String s, int radixSrc, int radixTgt) {
        return "";
    }

    private byte[] getNumByteArray(int a) {
        byte[] digits = new byte[32];
        int carry = 0;
        int pos = digits.length - 1;
        while (a != 0) {
            carry = (a % 2);
            digits[pos--] = (byte) carry;
            a /= 2;
        }
        return digits;
    }

    public int[][] solve(int x) {
        int pl = 0, pr = 0;
        int poise = 1, r;
        final int LEFT = 0, RIGHT = 1;
        int[][] result = new int[2][20];

        while (x > 0) {
            r = x % 3;
            if (r == 2) {
                result[LEFT][pl++] = poise;
                x = (x + 1) / 3;
            } else if (r == 1) {
                result[RIGHT][pr++] = poise;
                x = x / 3;
            } else
                x = x / 3;

            poise *= 3;
        }

        return result;
    }

    public void testValue() {
        Integer a = new Integer(1);
        Integer b = Integer.valueOf(1);
        Integer c = inc(0);
        Integer d = 1;
        System.out.println(a == b);  // false
        System.out.println(a.equals(b)); // true

        System.out.println(a == c); // false
        System.out.println(a.equals(c)); // true

        System.out.println(a == d);  // false
        System.out.println(a.equals(d)); // true

        System.out.println(b == c);  // true
        System.out.println(b.equals(c));  //true

        System.out.println(b == d);  // true
        System.out.println(b.equals(d)); // true

        System.out.println(((Long) 1L) == 1); // true
        System.out.println(new Long(1).equals(1)); // false

        Long e = 100L;
        Long f = 100L;
        System.out.println(e == f);  // true
        e = 1000L;
        f = 1000L;
        System.out.println(e == f);  // false


    }

    public Integer inc(Integer x) {
        return x + 1;
    }
}

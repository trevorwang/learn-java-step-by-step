package gradle.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise1Test {

    @Test
    public void testBit() {
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(1 << 31);
        System.out.println(1 << 30);
        System.out.println(Integer.MAX_VALUE >> 30);
    }

    @Test
    public void testOct2Bin() {
        Exercise1 e1 = new Exercise1();
        assertEquals(Integer.toBinaryString(7), e1.oct2Bin(7));
        assertEquals(Integer.toBinaryString(-7), e1.oct2Bin(-7));
        assertEquals(Integer.toBinaryString(8), e1.oct2Bin(8));
        assertEquals(Integer.toBinaryString(-1), e1.oct2Bin(-1));
        assertEquals(Integer.toBinaryString(Integer.MAX_VALUE), e1.oct2Bin(Integer.MAX_VALUE));
        assertEquals(Integer.toBinaryString(Integer.MIN_VALUE), e1.oct2Bin(Integer.MIN_VALUE));
    }

    @Test
    public void testMaxValue() {
        short a = Byte.MIN_VALUE;
        int b = Short.MIN_VALUE;
        short c = Byte.MAX_VALUE + 1;
        byte d = (byte) (Byte.MAX_VALUE + 1);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    @Test
    public void testHexString() {
        int i = -1;
        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toOctalString(i));

        int a = 037777777777;
        System.out.println(a);
        System.out.println(a == i);

        System.out.println(Integer.valueOf(Integer.toOctalString(-1), 8));
        System.out.println(Integer.valueOf(Integer.toBinaryString(-1), 2));
        System.out.println(Integer.valueOf(Integer.toHexString(-1), 16));

        System.out.println(Integer.valueOf(Integer.toOctalString(1), 8));
        System.out.println(Integer.valueOf(Integer.toBinaryString(1), 2));
        System.out.println(Integer.valueOf(Integer.toHexString(1), 16));
    }


    @Test
    public void testSolve() {
        Exercise1 e1 = new Exercise1();
        printResult(e1.solve(11));
        printResult(e1.solve(111));
        printResult(e1.solve(1111));
        printResult(e1.solve(11111));
    }

    @Test
    public void testValue() {
        Exercise1 e1 = new Exercise1();
        e1.testValue();

        System.out.println(((Long)1000L) == 1000);
        System.out.println(((Long)1000L) == Long.valueOf(1000));
        System.out.println(new Long(1).equals(1L));
    }

    private void printResult(int[][] results2) {
        for (int[] result : results2) {
            for (int i : result) {
                if (i > 0) {
                    System.out.print(i);
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}

package gradle.app.exercise5;

public class FibSolution {

    public static int fib(int n) {
        return fib(1, 0, n);
    }

    private static int fib(int a, int b, int n) {
        if (n == 0) return a;
        return fib(a + b, a, n - 1);
    }

    public static int fib2(int n) {
        if (n < 2) {
            return 1;
        }
        return fib2(n - 1) + fib2(n - 2);
    }


    public static double pow2(double a, double b) {
        return Math.pow(a, b);
    }

    public static double power1(double m, int n) {
        double result = 1.0;
        double t = m;

        for (int i = 1; i <= n; i <<= 1) {
            if ((n & i) > 0)
                result *= t;

            t *= t;
        }
        return result;
    }

    public static double pow(double m, int n) {
        return pow(m, 1.0, n);
    }

    private static double pow(double x, double m, int n) {
        if (n == 0) return m;
        if ((n & 1) == 1)
            return pow(x, m * x, n - 1);
        else
            return pow(x * x, m, n / 2);
    }
}

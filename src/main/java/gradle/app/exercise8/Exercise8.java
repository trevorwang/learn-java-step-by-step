package gradle.app.exercise8;

public class Exercise8 {

    public static double mySqrt(double x) {
        double k = 1.0;

        while (Math.abs(x - k * k) > 1e-9) {
            k = (k + x / k) / 2.0;
        }

        return k;
    }


    public static double myCubert(double x) {
        double k = 1.0;

        while (Math.abs(x - k * k * k) > 1e-9) {
            k = (k + x / k / k) / 2.0;
        }

        return k;
    }
}

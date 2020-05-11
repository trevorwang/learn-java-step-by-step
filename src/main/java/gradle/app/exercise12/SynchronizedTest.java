package gradle.app.exercise12;

public class SynchronizedTest {

    public void hello2() {
        synchronized (this) {
        }

        synchronized (SynchronizedTest.class) {

        }
    }

    synchronized void hello() {
    }

    synchronized static void sayHello() {

    }
}

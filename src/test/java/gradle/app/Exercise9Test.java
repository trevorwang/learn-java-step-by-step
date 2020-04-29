package gradle.app;

import gradle.app.exercise9.Chopstick;
import gradle.app.exercise9.Philosopher;
import org.junit.Test;

public class Exercise9Test {
    @Test
    public void testPhilosopher() throws InterruptedException {
        int sum = 5;
        Chopstick[] chopsticks = new Chopstick[sum];
        for (int i = 0; i < sum; i++) {
            chopsticks[i] = new Chopstick(i);
        }
        for (int i = 0; i < sum; i++) {
            Thread t = new Thread(new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % sum]));
            t.start();
            t.join();
        }
    }
}

package gradle.app;

import gradle.app.exercise12.Customer;
import gradle.app.exercise12.Producer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Exercise12Test {
    @Test
    public void testConsumerProducer() throws InterruptedException {
        List<Integer> cache = new ArrayList<>();
        Thread p1 = new Thread(new Producer(cache), "P1");
        p1.start();
        Thread c1 = new Thread(new Customer(cache), "C1");
        c1.start();

        Thread c2 = new Thread(new Customer(cache), "C2");
        c2.start();
        p1.join();
        c1.join();
        c2.join();
    }
}

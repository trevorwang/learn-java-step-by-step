package gradle.app;

import gradle.app.exercise11.*;
import org.junit.Test;

public class Exercise11Test {

    @Test
    public void testVisitorPattern() {
        Animal[] animals = {new Dog(), new Cat(), new Fox(), new Cat(), new Dog(), new Dog()};
        Speaker s = new Speaker();
        Counter c = new Counter();
        for (Animal animal : animals) {
            c.visit(animal);
        }
        c.log();

        for (Animal animal : animals) {
            s.visit(animal);
        }
    }
}

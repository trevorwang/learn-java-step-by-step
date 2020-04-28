package gradle.app;

import gradle.app.exercise6.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise6Test {

    @Test
    public void testProxy() {
        Exercise6.Subject s = new Exercise6.Proxy(new Exercise6.RealSubject());
        s.request(3);
    }

    @Test
    public void testJavaProxy() {
        final Exercise6.Subject realSubject = new Exercise6.RealSubject();
        Exercise6.Subject proxy = (Exercise6.Subject) java.lang.reflect.Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), (proxy1, method, args) -> {
                    System.out.println("print log");
                    return method.invoke(realSubject, args);
                });
        proxy.request(1);
    }

    @Test
    public void testBubbleSort() {
        int[] array = new int[]{1, 3, 19, 8, 9, 7, 2};
        Sorter sorter = new BubbleSorter();
        sorter.sort(array);
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    @Test
    public void testInsertionSort() {
        int[] array = new int[]{1, 3, 19, 8, 9, 7, 2};
        Sorter sorter = new InsertionSorter();
        sorter.sort(array);
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    @Test
    public void testChooseSort() {
        int[] array = new int[]{1, 3, 19, 8, 9, 7, 2};
        Sorter sorter = new ChooseSorter();
        sorter.sort(array);
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}

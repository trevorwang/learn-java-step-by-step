package gradle.app;

import gradle.app.exercise5.BinarySearchTree;
import gradle.app.exercise5.FibSolution;
import gradle.app.exercise5.Node;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Exercise5Test {

    @Test
    public void testBSTContains() {
        Integer[] array = new Integer[]{1, 3, 5, 6, 7, 7324, 234, 233, 222, 100, 23};
        BinarySearchTree<Integer> bst = BinarySearchTree.createTree(array);
        assertTrue(bst.contains(1));
        assertTrue(bst.contains(7324));
        assertTrue(bst.contains(233));
        assertTrue(bst.contains(23));
        assertFalse(bst.contains(8));
    }

    @Test
    public void testFib() {

        System.out.println(FibSolution.fib(5));
        System.out.println(FibSolution.fib2(5));
    }

    @Test
    public void testPow() {
        System.out.println(FibSolution.pow(1.5, 3));
        System.out.println(FibSolution.power1(1.5, 3));
    }

    @Test
    public void testOrder() {
        Integer[] array = new Integer[]{233, 100, 7324, 234, 222, 23, 1, 3, 7, 5, 6, 11,};
        BinarySearchTree<Integer> bst = BinarySearchTree.createTree(array);
        String result = bst.preOrder(bst.root).stream().map(it -> String.valueOf(it.data)).collect(Collectors.joining(","));
        System.out.println(result);

        result = bst.midOrder(bst.root).stream().map(it -> String.valueOf(it.data)).collect(Collectors.joining(","));
        System.out.println(result);


        result = bst.postOrder(bst.root).stream().map(it -> String.valueOf(it.data)).collect(Collectors.joining(","));
        System.out.println(result);

        result = bst.bfs().stream().map(it -> String.valueOf(it.data)).collect(Collectors.joining(","));
        System.out.println(result);


        result = bst.dfs().stream().map(it -> String.valueOf(it.data)).collect(Collectors.joining(","));
        System.out.println(result);

        for (Node<Integer> item : bst) {
            System.out.println(item.data);
        }
    }


}

package gradle.app;

import gradle.app.exercise2.Token;
import gradle.app.exercise5.BinarySearchTree;
import gradle.app.exercise5.BinaryTreeExpression;
import gradle.app.exercise5.FibSolution;
import gradle.app.exercise5.Node;
import org.junit.Test;

import java.util.Arrays;
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

    @Test
    public void testRemove() {
        Integer[] array = new Integer[]{233, 100, 7324, 234, 222, 23, 1, 3, 7, 5, 6, 11,};
        BinarySearchTree<Integer> bst = BinarySearchTree.createTree(array);
        Node<Integer> toRemove = bst.findNode(7);
        bst.remove(toRemove);
        for (Node<Integer> item : bst) {
            System.out.println(item.data);
        }
    }

    @Test
    public void testBinaryTreeExpression() {
        testExpression("(1+2)*3");
        testExpression("(1+2)*3 + 3");
        testExpression(" 1 * (7+9) / 3");
    }

    @Test
    public void testPrintNodesOnDepth() {
        Integer[] array = new Integer[]{233, 100, 7324, 234, 222, 23, 1, 3, 7, 5, 6, 11,};
        BinarySearchTree<Integer> bst = BinarySearchTree.createTree(array);
        Object[] result = bst.getNodesOnDepthByRec(3).stream().map(it -> it.data).toArray();
        System.out.println(Arrays.toString(result));

        result = bst.getNodesOnDepthByRec(1).stream().map(it -> it.data).toArray();
        System.out.println(Arrays.toString(result));

        result = bst.getNodesOnDepthByRec(2).stream().map(it -> it.data).toArray();
        System.out.println(Arrays.toString(result));

        result = bst.getNodesOnDepthByLoop(2).toArray();
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testSameTree() {

        Integer[] array = new Integer[]{1, 3, 5, 6, 7, 7324, 234, 233, 222, 100, 23};
        BinarySearchTree<Integer> bst = BinarySearchTree.createTree(array);

        BinarySearchTree<Integer> bst2 = BinarySearchTree.createTree(array);

        assertTrue(sameTree(bst.root, bst2.root));
    }

    private boolean sameTree(Node<Integer> t1, Node<Integer> t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (!t1.data.equals(t2.data)) return false;
        return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }

    private void testExpression(String expr) {
        BinaryTreeExpression e = new BinaryTreeExpression(expr);
        BinarySearchTree<Token> bst = new BinarySearchTree<>();
        bst.root = e.expression();
        for (Node<Token> tokenNode : bst.postOrder(bst.root)) {
            System.out.print(tokenNode.data.value);
        }
        System.out.println();

        for (Node<Token> tokenNode : bst.midOrder(bst.root)) {
            System.out.print(tokenNode.data.value);
        }
        System.out.println();

        for (Node<Token> tokenNode : bst.preOrder(bst.root)) {
            System.out.print(tokenNode.data.value);
        }
        System.out.println();
    }
}

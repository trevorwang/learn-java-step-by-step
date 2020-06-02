package gradle.app

import gradle.app.exercise2.Token
import gradle.app.exercise5.BinarySearchTree
import gradle.app.exercise5.BinarySearchTree.Companion.createTree
import gradle.app.exercise5.BinaryTreeExpression
import gradle.app.exercise5.FibSolution
import gradle.app.exercise5.Node
import org.junit.Assert
import org.junit.Test
import java.util.*
import java.util.stream.Collectors

class Exercise5Test {
    @Test
    fun testBSTContains() {
        val array = arrayOf(1, 3, 5, 6, 7, 7324, 234, 233, 222, 100, 23)
        val bst = createTree(array)
        Assert.assertTrue(bst.contains(1))
        Assert.assertTrue(bst.contains(7324))
        Assert.assertTrue(bst.contains(233))
        Assert.assertTrue(bst.contains(23))
        Assert.assertFalse(bst.contains(8))
    }

    @Test
    fun testFib() {
        println(FibSolution.fib(5))
        println(FibSolution.fib2(5))
    }

    @Test
    fun testPow() {
        println(FibSolution.pow(1.5, 3))
        println(FibSolution.power1(1.5, 3))
    }

    @Test
    fun testOrder() {
        val array = arrayOf(233, 100, 7324, 234, 222, 23, 1, 3, 7, 5, 6, 11)
        val bst = createTree(array)
        var result = bst.preOrder(bst.root!!).stream().map { it: Node<Int> -> it.data.toString() }.collect(Collectors.joining(","))
        println(result)
        result = bst.midOrder(bst.root!!).stream().map { it: Node<Int> -> it.data.toString() }.collect(Collectors.joining(","))
        println(result)
        result = bst.postOrder(bst.root!!).stream().map { it: Node<Int> -> it.data.toString() }.collect(Collectors.joining(","))
        println(result)
        result = bst.bfs().stream().map { it: Node<Int> -> it.data.toString() }.collect(Collectors.joining(","))
        println(result)
        result = bst.dfs().stream().map { it: Node<Int> -> it.data.toString() }.collect(Collectors.joining(","))
        println(result)
        for (item in bst) {
            println(item.data)
        }
    }

    @Test
    fun testRemove() {
        val array = arrayOf(233, 100, 7324, 234, 222, 23, 1, 3, 7, 5, 6, 11)
        val bst = createTree(array)
        val toRemove = bst.findNode(7)
        bst.remove(toRemove)
        for (item in bst) {
            println(item.data)
        }
    }

    @Test
    fun testBinaryTreeExpression() {
        testExpression("(1+2)*3")
        testExpression("(1+2)*3 + 3")
        testExpression(" 1 * (7+9) / 3")
    }

    @Test
    fun testPrintNodesOnDepth() {
        val array = arrayOf(233, 100, 7324, 234, 222, 23, 1, 3, 7, 5, 6, 11)
        val bst = createTree(array)
        var result = bst.getNodesOnDepthByRec(3).stream().map { it: Node<Int> -> it.data }.toArray()
        println(Arrays.toString(result))
        result = bst.getNodesOnDepthByRec(1).stream().map { it: Node<Int> -> it.data }.toArray()
        println(Arrays.toString(result))
        result = bst.getNodesOnDepthByRec(2).stream().map { it: Node<Int> -> it.data }.toArray()
        println(Arrays.toString(result))
        result = bst.getNodesOnDepthByLoop(2).toTypedArray()
        println(Arrays.toString(result))
    }

    @Test
    fun testSameTree() {
        val array = arrayOf(1, 3, 5, 6, 7, 7324, 234, 233, 222, 100, 23)
        val bst = createTree(array)
        val bst2 = createTree(array)
        Assert.assertTrue(sameTree(bst.root, bst2.root))
    }

    private fun sameTree(t1: Node<Int>?, t2: Node<Int>?): Boolean {
        if (t1 == null && t2 == null) return true
        if (t1 == null || t2 == null) return false
        return if (t1.data != t2.data) false else sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right)
    }

    private fun testExpression(expr: String) {
        val e = BinaryTreeExpression(expr)
        val bst = BinarySearchTree<Token>()
        bst.root = e.expression()
        for (tokenNode in bst.postOrder(bst.root)) {
            print(tokenNode.data.value)
        }
        println()
        for (tokenNode in bst.midOrder(bst.root)) {
            print(tokenNode.data.value)
        }
        println()
        for (tokenNode in bst.preOrder(bst.root)) {
            print(tokenNode.data.value)
        }
        println()
    }
}

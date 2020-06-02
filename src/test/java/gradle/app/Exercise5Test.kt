package gradle.app

import gradle.app.exercise2.Token
import gradle.app.exercise5.*
import gradle.app.exercise5.BinarySearchTree.Companion.createTree
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.stream.Collectors
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Exercise5Test {
    lateinit var bst: BinarySearchTree<Int>
    private val array = arrayOf(233, 100, 7324, 234, 222, 23, 1, 3, 7, 5, 6, 11)

    @Before
    fun init() {
        bst = createTree(array)
    }

    @Test
    fun testBSTContains() {
        assertTrue(bst.contains(1))
        assertTrue(bst.contains(7324))
        assertTrue(bst.contains(233))
        assertTrue(bst.contains(23))
        assertFalse(bst.contains(8))
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
        var result = bst.nodesAtLevel(3).map { it: Node<Int> -> it.data }
        println(result)
        result = bst.nodesAtLevel(1).map { it: Node<Int> -> it.data }

        println(result)
        result = bst.nodesAtLevel(2).map { it: Node<Int> -> it.data }
        println(result)
    }

    @Test
    fun testSameTree() {
        val array = arrayOf(1, 3, 5, 6, 7, 7324, 234, 233, 222, 100, 23)
        val bst = createTree(array)
        val bst2 = createTree(array)
        Assert.assertTrue(sameTree(bst.root, bst2.root))
    }

    @Test
    fun `Test leaves count of binary tree`() {
        println(bst.leavesCount())
        assertEquals(1, createTree(arrayOf(1)).leavesCount())
        assertEquals(2, createTree(arrayOf(3, 1, 4)).leavesCount())
    }

    @Test
    fun `Test depth of a binary tree`() {
        assertEquals(1, createTree(arrayOf(1)).depth())
        assertEquals(2, createTree(arrayOf(3, 1, 4)).depth())
        assertEquals(3, createTree(arrayOf(3, 1, 2)).depth())
    }

    @Test
    fun `Test node count of a binary tree`() {
        assertEquals(array.size, bst.count())
    }

    @Test
    fun `node count at level k`() {
        assertEquals(bst.countAtLevel(1), bst.nodesAtLevel(1).size)
        assertEquals(bst.countAtLevel(2), bst.nodesAtLevel(2).size)
    }

    @Test
    fun `leaves at level k`() {
        println(bst.nodesAtLevel(1).map { it.data.toString() })
        println(bst.nodesAtLevel(2).map { it.data.toString() })
        println(bst.nodesAtLevel(3).map { it.data.toString() })
    }

    @Test
    fun `find lowest common ancestor`() {
        val node = bst.findLCA(bst.findNode(1), bst.findNode(7324))
        println(node?.data)
    }

    @Test
    fun `distance between two nodes`() {
        println(distance(bst.root, bst.findNode(1), bst.findNode(7324)))
        assertEquals(-1, distance(bst.root, bst.findNode(1), bst.findNode(-2)))
    }


    @Test
    fun `find all ancestors`() {
        println(bst.findAllAncestors(bst.findNode(7324)).map { it.data })
        println(bst.findAllAncestors(bst.findNode(1)).map { it.data })
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

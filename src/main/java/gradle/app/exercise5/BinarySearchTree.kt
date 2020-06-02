package gradle.app.exercise5

import java.util.*

class BinarySearchTree<T : Comparable<T>?> : Iterable<Node<T>?> {
    @JvmField
    var root: Node<T>? = null
    var minNode: Node<T>? = null
    fun insert(i: T): Boolean {
        val node = Node(i)
        if (this.root == null) {
            this.root = node
            return true
        }
        var current = this.root!!
        while (true) {
            if (i!! < current.data) {
                if (current.left == null) {
                    current.left = node
                    node.parent = current
                    if (minNode == null) {
                        minNode = node
                    } else {
                        if (minNode?.data!! > node.data) {
                            minNode = node
                        }
                    }
                    break
                } else {
                    current = current.left
                }
            } else {
                if (current.right == null) {
                    current.right = node
                    node.parent = current
                    break
                } else {
                    current = current.right
                }
            }
        }
        return true
    }

    operator fun contains(data: T): Boolean {
        return findNode(data) != null
    }

    fun findNode(data: T): Node<T>? {
        if (data == null) return null
        if (root == null) return null
        var current: Node<T> = root!!
        while (true) {
            current = if (data.compareTo(current.data) == 0) {
                return current
            } else if (data < current.data) {
                if (current.left == null) {
                    break
                } else {
                    current.left
                }
            } else {
                if (current.right == null) {
                    break
                } else {
                    current.right
                }
            }
        }
        return null
    }

    fun preOrder(node: Node<T>?): List<Node<T>> {
        val list: MutableList<Node<T>> = ArrayList()
        node?.let {
            list.add(node)
        }
        if (node?.left != null) list.addAll(preOrder(node.left))
        if (node?.right != null) list.addAll(preOrder(node.right))
        return list
    }

    fun midOrder(node: Node<T>?): List<Node<T>> {
        val list: MutableList<Node<T>> = ArrayList()
        if (node?.left != null) list.addAll(midOrder(node.left))
        node?.let {
            list.add(it)
        }
        if (node?.right != null) list.addAll(midOrder(node.right))
        return list
    }

    fun postOrder(node: Node<T>?): List<Node<T>> {
        val list: MutableList<Node<T>> = ArrayList()
        if (node?.left != null) list.addAll(postOrder(node.left))
        if (node?.right != null) list.addAll(postOrder(node.right))
        node?.let {
            list.add(it)
        }
        return list
    }

    fun bfs(): List<Node<T>> {
        val list: MutableList<Node<T>> = ArrayList()
        val queue: Queue<Node<T>> = LinkedList()
        if (root != null) queue.add(root)
        while (!queue.isEmpty()) {
            val node = queue.remove()
            list.add(node)
            if (node.left != null) queue.add(node.left)
            if (node.right != null) queue.add(node.right)
        }
        return list
    }

    fun dfs(): List<Node<T>> {
        val list: MutableList<Node<T>> = ArrayList()
        val stack = Stack<Node<T>>()
        if (root != null) stack.push(root)
        while (!stack.isEmpty()) {
            val node = stack.pop()
            list.add(node)
            if (node.right != null) stack.push(node.right)
            if (node.left != null) stack.push(node.left)
        }
        return list
    }

    fun getNodesOnDepthByLoop(depth: Int): List<T> {
        val leaves: MutableList<T> = ArrayList()
        val queue: Queue<Node<T>?> = LinkedList()
        var currDepth = 1
        var leavesEnqueue = 0
        var leavesToDequeue: Int
        queue.add(root)
        leavesToDequeue = 1
        while (!queue.isEmpty()) {
            leavesToDequeue--
            val node = queue.poll()
            if (node!!.left != null) {
                queue.add(node.left)
                leavesEnqueue += 1
            }
            if (node.right != null) {
                queue.add(node.right)
                leavesEnqueue += 1
            }
            if (leavesToDequeue == 0) {
                leavesToDequeue = leavesEnqueue
                leavesEnqueue = 0
                currDepth++
                if (currDepth == depth) {
                    while (!queue.isEmpty()) {
                        leaves.add(queue.poll()!!.data)
                    }
                    break
                }
            }
        }
        return leaves
    }

    fun getNodesOnDepthByRec(depth: Int): List<Node<T>> {
        val leaves: MutableList<Node<T>> = ArrayList()
        getNodesOnDepthByRec(root, depth, leaves)
        return leaves
    }

    private fun getNodesOnDepthByRec(root: Node<T>?, depth: Int, leaves: MutableList<Node<T>>) {
        if (root == null || depth == 0) return
        if (depth == 1) {
            leaves.add(root)
        } else {
            getNodesOnDepthByRec(root.left, depth - 1, leaves)
            getNodesOnDepthByRec(root.right, depth - 1, leaves)
        }
    }

    fun successor(node: Node<T>?): Node<T>? {
        var pNode: Node<T> = node ?: return null
        var ptr = pNode.right
        if (ptr != null) {
            while (ptr.left != null) {
                ptr = ptr.left
            }
        } else {
            ptr = pNode.parent
            while (ptr != null && ptr.left !== pNode) {
                pNode = ptr
                ptr = pNode.parent
            }
        }
        return ptr
    }

    fun remove(node: Node<T>?) {
        if (node == null) return
        val parent = node.parent
        if (node.left == null && node.right == null) {
            if (node === root) {
                root = null
                return
            }
            if (node === parent.left) {
                parent.left = null
            } else if (node === parent.right) {
                parent.right = null
            }
        } else if (node.left != null && node.right != null) {
            val next = successor(node)
            node.data = next!!.data
            remove(next)
        } else {
            val child: Node<T> = node.left ?: node.right
            if (node === root) {
                child.parent = null
                root = child
                return
            }
            if (node !== parent.left) {
                parent.right = child
            } else {
                parent.left = child
            }
            child.parent = parent
        }
    }

    fun leavesCount(): Int {
        return leavesCount(root)
    }

    fun depth(node: Node<T>?): Int {
        if (node == null) return 0
        if (node.left == null && node.right == null) return 1
        val leftDepth = depth(node.left)
        val rightDepth = depth(node.right)
        return 1 + if (leftDepth > rightDepth) leftDepth else rightDepth
    }

    fun depth(): Int {
        return depth(this.root)
    }


    fun count(): Int {
        return count(root)
    }

    fun count(node: Node<T>?): Int {
        if (node == null) return 0
        if (node.left == null && node.right == null) return 1
        return count(node.left) + count(node.right) + 1
    }

    private fun leavesCount(node: Node<T>?): Int {
        if (node == null) return 0
        if (node.left == null && node.right == null) return 1

        return leavesCount(node.left) + leavesCount(node.right)
    }

    override fun iterator(): MutableIterator<Node<T>> {
        return Itr()
    }

    private inner class Itr : MutableIterator<Node<T>> {
        var lastNode: Node<T>? = null
        var nextNode: Node<T>? = null
        override fun hasNext(): Boolean {
            if (lastNode == null) {
                lastNode = minNode
                nextNode = lastNode
            } else {
                nextNode = successor(lastNode)
            }
            return nextNode != null
        }

        override fun next(): Node<T> {
            lastNode = nextNode
            val node = nextNode
            nextNode = null
            if (node == null)
                throw IllegalStateException("There's no node")
            return node
        }

        override fun remove() {
        }
    }

    companion object {
        @JvmStatic
        fun createTree(array: Array<Int>): BinarySearchTree<Int> {
            val bst = BinarySearchTree<Int>()
            for (t in array) {
                bst.insert(t)
            }
            return bst
        }
    }
}

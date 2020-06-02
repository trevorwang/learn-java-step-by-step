package gradle.app.exercise5

import java.util.*

// find lowest common ancestor
fun <T : Comparable<T>> findLCA(root: Node<T>?, a: Node<T>?, b: Node<T>?): Node<T>? {
    if (root == null || a == null || b == null) return null
    if (root == a || root == b) return root

    val left = findLCA(root.left, a, b)
    val right = findLCA(root.right, a, b)
    if (left != null && right != null) return root
    return left ?: right
}

fun <T : Comparable<T>> findLevel(node: Node<T>?, target: Node<T>?): Int {
    if (node == null || target == null) return -1
    if (node == target) return 0

    var level = findLevel(node.left, target)
    if (level == -1) {
        level = findLevel(node.right, target)
    }
    if (level != -1) {
        return level + 1
    }
    return -1
}

fun <T : Comparable<T>> distance(root: Node<T>?, node: Node<T>?, target: Node<T>?): Int {
    val lca = findLCA(root, node, target)
    val levelNode = findLevel(lca, target)
    val levelTarget = findLevel(lca, node)
    val result = levelNode + levelTarget
    return if (result < 0) -1 else result
}


fun <T : Comparable<T>> findAllAncestors(root: Node<T>?, target: Node<T>?, list: MutableList<Node<T>>): Boolean {
    if (root == null || target == null) return false
    if (root == target) return true
    if (findAllAncestors(root.left, target, list) || findAllAncestors(root.right, target, list)) {
        list.add(root)
        return true
    }
    return false
}

fun <T : Comparable<T>> isCBT(root: Node<T>?): Boolean {
    val queue: Queue<Node<T>> = LinkedList()
    if (root == null) return false
    queue.add(root)

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        if (cur.left == null && cur.right != null) return false
        if (cur.left != null && cur.right == null) {
            if (cur.left.left != null || cur.left.right != null) return false
        }
        if (cur.left != null) queue.offer(cur.left)
        if (cur.right != null) queue.offer(cur.right)
    }
    return true
}

fun <T : Comparable<T>> isPostBSTSequence(array: Array<T>, begin: Int, end: Int): Boolean {
    if (end <= begin) return true
    val data = array[end]
    var i = begin
    while (data > array[i]) {
        i++
    }

    for (j in i until end) {
        if (array[j] < data) return false
    }

    return isPostBSTSequence(array, begin, i - 1) && isPostBSTSequence(array, i, end - 1)
}

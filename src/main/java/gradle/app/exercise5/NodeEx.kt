package gradle.app.exercise5

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

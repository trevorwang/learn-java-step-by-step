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

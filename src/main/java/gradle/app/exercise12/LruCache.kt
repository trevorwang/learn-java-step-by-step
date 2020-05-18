package gradle.app.exercise12

open class LRUCache(private val capacity: Int) {
    private val head = Node(1, -1)
    private val tail = Node(1, -1)
    private val map = HashMap<Int, Node<Int>>(capacity)

    init {
        tail.pre = head
        head.next = tail
    }

    open fun get(key: Int): Int {
        val node = map[key]
        node?.let {
            removeNode(node)
            addNode(node)
        }
        return node?.value ?: -1
    }

    open fun put(key: Int, value: Int) {
        val node = Node(key, value)
        val origin = map[key]
        if (origin != null) {
            removeNode(origin)
        }
        addNode(node)
    }

    private fun addNode(node: Node<Int>) {
        if (capacity == map.size) {
            removeNode(tail.pre!!)
        }

        map[node.key] = node
        node.next = head.next
        head.next?.pre = node
        node.pre = head
        head.next = node
    }

    private fun removeNode(node: Node<Int>) {
        map.remove(node.key)
        node.next?.pre = node.pre
        node.pre?.next = node.next
        node.pre = null
        node.next = null
    }
}

class Node<T>(
        val key: Int,
        val value: T,
        var pre: Node<T>? = null,
        var next: Node<T>? = null)



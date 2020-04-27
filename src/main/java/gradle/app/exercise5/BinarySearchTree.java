package gradle.app.exercise5;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<Node<T>> {
    public Node<T> root;
    public Node<T> minNode;

    public boolean insert(T i) {
        Node<T> node = new Node<>(i);
        if (this.root == null) {
            this.root = node;
            return true;
        }

        Node<T> current = this.root;
        while (true) {
            if (i.compareTo(current.data) < 0) {
                if (current.left == null) {
                    current.left = node;
                    node.parent = current;
                    if (minNode == null) {
                        minNode = node;
                    } else {
                        if (minNode.data.compareTo(node.data) > 0) {
                            minNode = node;
                        }
                    }
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = node;
                    node.parent = current;
                    break;
                } else {
                    current = current.right;

                }
            }
        }
        return true;
    }

    public boolean contains(T data) {
        if (data == null) return false;
        if (root == null) return false;
        Node<T> current = root;
        while (true) {
            if (data.compareTo(current.data) == 0) {
                return true;
            } else if (data.compareTo(current.data) < 0) {
                if (current.left == null) {
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    break;
                } else {
                    current = current.right;
                }
            }
        }
        return false;
    }

    public List<Node<T>> preOrder(Node<T> node) {
        List<Node<T>> list = new ArrayList<>();
        list.add(node);
        if (node.left != null)
            list.addAll(preOrder(node.left));
        if (node.right != null)
            list.addAll(preOrder(node.right));
        return list;
    }

    public List<Node<T>> midOrder(Node<T> node) {
        List<Node<T>> list = new ArrayList<>();
        if (node.left != null)
            list.addAll(midOrder(node.left));
        list.add(node);
        if (node.right != null)
            list.addAll(midOrder(node.right));
        return list;
    }

    public List<Node<T>> postOrder(Node<T> node) {
        List<Node<T>> list = new ArrayList<>();
        if (node.left != null)
            list.addAll(postOrder(node.left));
        if (node.right != null)
            list.addAll(postOrder(node.right));
        list.add(node);
        return list;
    }

    public List<Node<T>> bfs() {
        List<Node<T>> list = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            list.add(node);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return list;
    }

    public List<Node<T>> dfs() {
        List<Node<T>> list = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            list.add(node);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }


    public Node<T> successor(Node<T> node) {
        if (node == null) return null;
        Node<T> ptr = node.right;
        if (ptr != null) {
            while (ptr.left != null) {
                ptr = ptr.left;
            }
        } else {
            ptr = node.parent;
            while (ptr != null && ptr.left != node) {
                node = ptr;
                ptr = node.parent;
            }
        }
        return ptr;
    }

    public static BinarySearchTree<Integer> createTree(Integer[] array) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer t : array) {
            bst.insert(t);
        }
        return bst;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Node<T>> {
        Node<T> lastNode = null;
        Node<T> nextNode = null;

        @Override
        public boolean hasNext() {
            if (lastNode == null) {
                nextNode = lastNode = minNode;
            } else {
                nextNode = successor(lastNode);
            }
            return nextNode != null;
        }

        @Override
        public Node<T> next() {
            lastNode = nextNode;
            Node<T> node = nextNode;
            nextNode = null;
            return node;
        }
    }

}

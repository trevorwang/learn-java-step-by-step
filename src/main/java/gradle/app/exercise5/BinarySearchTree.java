package gradle.app.exercise5;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
    public Node<T> root;

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

    public List<T> preOrder(Node<T> node) {
        List<T> list = new ArrayList<>();
        list.add(node.data);
        if (node.left != null)
            list.addAll(preOrder(node.left));
        if (node.right != null)
            list.addAll(preOrder(node.right));
        return list;
    }

    public List<T> midOrder(Node<T> node) {
        List<T> list = new ArrayList<>();
        if (node.left != null)
            list.addAll(midOrder(node.left));
        list.add(node.data);
        if (node.right != null)
            list.addAll(midOrder(node.right));
        return list;
    }

    public List<T> postOrder(Node<T> node) {
        List<T> list = new ArrayList<>();
        if (node.left != null)
            list.addAll(postOrder(node.left));
        if (node.right != null)
            list.addAll(postOrder(node.right));
        list.add(node.data);
        return list;
    }

    public List<T> bfs() {
        List<T> list = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            list.add(node.data);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return list;
    }

    public List<T> dfs() {
        List<T> list = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            list.add(node.data);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }


    public Node<T> successor(Node<T> n) {
        if (n == null)
            return null;

        Node<T> p;
        if (n.right != null) {
            p = n.right;
            while (p.left != null) {
                p = p.left;
            }
        } else {
            p = n.parent;

            while (p != null && p.left != n) {
                n = p;
                p = n.parent;
            }
        }
        return p;
    }

    public static BinarySearchTree<Integer> createTree(Integer[] array) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer t : array) {
            bst.insert(t);
        }
        return bst;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        Node<T> nextNode = null;

        @Override
        public boolean hasNext() {
            if (nextNode == null) {
                nextNode = root;
            } else {
                nextNode = successor(nextNode);
            }
            return nextNode != null;
        }

        @Override
        public T next() {
            return nextNode.data;
        }
    }

}

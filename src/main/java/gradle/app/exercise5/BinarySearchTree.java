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
        return findNode(data) != null;
    }

    public Node<T> findNode(T data) {
        if (data == null) return null;
        if (root == null) return null;
        Node<T> current = root;
        while (true) {
            if (data.compareTo(current.data) == 0) {
                return current;
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
        return null;
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

    public List<T> getNodesOnDepthByLoop(int depth) {
        List<T> leaves = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        int currDepth = 1;
        int leavesEnqueue = 0;
        int leavesToDequeue;
        queue.add(root);
        leavesToDequeue = 1;
        while (!queue.isEmpty()) {
            leavesToDequeue--;
            Node<T> node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                leavesEnqueue += 1;
            }
            if (node.right != null) {
                queue.add(node.right);
                leavesEnqueue += 1;
            }
            if (leavesToDequeue == 0) {
                leavesToDequeue = leavesEnqueue;
                leavesEnqueue = 0;
                currDepth++;
                if (currDepth == depth) {
                    while (!queue.isEmpty()) {
                        leaves.add(queue.poll().data);
                    }
                }
            }
        }
        return leaves;
    }


    public List<Node<T>> getNodesOnDepthByRec(int depth) {
        List<Node<T>> leaves = new ArrayList<>();
        getNodesOnDepthByRec(root, depth, leaves);
        return leaves;
    }

    private void getNodesOnDepthByRec(Node<T> root, int depth, List<Node<T>> leaves) {
        if (root == null || depth == 0) return;
        if (depth == 1) {
            leaves.add(root);
        } else {
            getNodesOnDepthByRec(root.left, depth - 1, leaves);
            getNodesOnDepthByRec(root.right, depth - 1, leaves);
        }
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

    public void remove(Node<T> node) {
        Node<T> parent = node.parent;
        if (node.left == null && node.right == null) {
            if (node == root) {
                root = null;
                return;
            }

            if (node == parent.left) {
                parent.left = null;
            } else if (node == parent.right) {
                parent.right = null;
            }
        } else if (node.left != null && node.right != null) {
            Node<T> next = successor(node);
            node.data = next.data;
            remove(next);

        } else {
            Node<T> child;
            child = Objects.requireNonNullElseGet(node.left, () -> node.right);
            if (node == root) {
                child.parent = null;
                root = child;
                return;
            }

            if (node != parent.left) {
                parent.right = child;
            } else {
                parent.left = child;
            }
            child.parent = parent;
        }
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

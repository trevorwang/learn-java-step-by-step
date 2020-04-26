package gradle.app.exercise5;

public class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> left;
    public Node<T> right;
    public Node<T> parent;
    public int state;

    Node(T data) {
        this.data = data;
    }
}

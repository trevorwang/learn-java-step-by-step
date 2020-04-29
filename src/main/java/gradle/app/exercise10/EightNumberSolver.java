package gradle.app.exercise10;

import java.util.Arrays;
import java.util.LinkedList;

public class EightNumberSolver {

    public int[] visited;

    public EightNumberSolver() {
        visited = new int[11340];
    }

    public int moveUp(int[] state) {
        int index = findSpace(state);
        if (index < 6) {
            state[index] = state[index + 3];
            state[index + 3] = 0;
        }
        return Permutation.encode(state, 9);
    }

    public int moveDown(int[] state) {
        int index = findSpace(state);
        if (index > 2) {
            state[index] = state[index - 3];
            state[index - 3] = 0;
        }
        return Permutation.encode(state, 9);
    }

    public int moveLeft(int[] state) {
        int index = findSpace(state);
        if (index % 3 != 2) {
            state[index] = state[index + 1];
            state[index + 1] = 0;
        }
        return Permutation.encode(state, 9);
    }

    public int moveRight(int[] state) {
        int index = findSpace(state);
        if (index % 3 != 0) {
            state[index] = state[index - 1];
            state[index - 1] = 0;
        }
        return Permutation.encode(state, 9);
    }

    public int findSpace(int[] state) {
        int index = -1;
        for (int i = 0; i < 9; i++) {
            if (state[i] == 1)
                index = i;
        }
        return index;
    }

    public boolean isChecked(int n) {
        int a = n / 32;
        int b = n & 31;

        return ((visited[a] & (1 << b)) != 0);
    }

    public void visit(int n) {
        int a = n / 32;
        int b = n & 31;

        visited[a] |= (1 << b);
    }

    public void breadFirstSearch(int[] array) {
        int s = Permutation.encode(array, 9);
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(new Node(s, null));

        while (!q.isEmpty()) {
            Node t = q.poll();

            if (t.n == 0) {
                Node iter = t;
                while (iter != null) {
                    int[] arrayIter = Permutation.decode(iter.n, 9);
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            System.out.print(arrayIter[i * 3 + j] - 1 + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("*********");

                    iter = iter.previous;
                }
                return;
            }

            int[] state = Permutation.decode(t.n, 9);
            int[] tmp;
            tmp = Arrays.copyOf(state, state.length);
            int n = moveUp(tmp);
            if (n != s && !isChecked(n)) {
                visit(n);
                q.addLast(new Node(n, t));
            }

            tmp = Arrays.copyOf(state, state.length);

            n = moveDown(tmp);
            if (n != s && !isChecked(n)) {
                visit(n);
                q.addLast(new Node(n, t));
            }

            tmp = Arrays.copyOf(state, state.length);
            n = moveLeft(tmp);
            if (n != s && !isChecked(n)) {
                visit(n);
                q.addLast(new Node(n, t));
            }

            tmp = Arrays.copyOf(state, state.length);
            n = moveRight(tmp);
            if (n != s && !isChecked(n)) {
                visit(n);
                q.addLast(new Node(n, t));
            }
        }

        System.out.println("no solution");
    }

    static class Node {
        int n;
        Node previous;

        public Node(int n, Node prev) {
            this.n = n;
            this.previous = prev;
        }
    }
}

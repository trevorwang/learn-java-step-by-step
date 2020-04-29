package gradle.app.exercise10;

import java.util.ArrayDeque;

public class Graph {
    int v;
    int e;
    ListHead[] vertex;

    public Graph(int v, int e) {
        this.v = v;
        this.e = e;
        vertex = new ListHead[v + 1];

        for (int i = 1; i <= v; i++) {
            vertex[i] = new ListHead(i);
        }
    }

    public void addEdge(int a, int b) {
        vertex[a].linkTo(b);
        vertex[b].linkTo(a);
    }

    public void breadthFirstSearch() {
        ArrayDeque<ListHead> q = new ArrayDeque<>(v);
        q.add(vertex[1]);
        vertex[1].visited = true;

        while (!q.isEmpty()) {
            ListHead tmp = q.removeFirst();
            System.out.println(tmp.data);

            AdjacentListNode n = tmp.firstArc;

            while (n != null) {
                tmp = vertex[n.nodeIndex];
                if (!tmp.visited) {
                    q.add(tmp);
                    tmp.visited = true;
                }

                n = n.nextArc;
            }
        }
    }

    public void depthFirstSearch() {
        depthFirstSearch(vertex[1]);
    }

    public void depthFirstSearch(ListHead v) {
        v.visited = true;
        System.out.println(v.data);
        AdjacentListNode n = v.firstArc;

        while (n != null) {
            if (vertex[n.nodeIndex].visited) {
                n = n.nextArc;
                continue;
            }

            depthFirstSearch(vertex[n.nodeIndex]);
            n = n.nextArc;
        }
    }
}

package gradle.app;

import gradle.app.exercise10.Graph;
import org.junit.Test;

public class Exercise10Test {
    @Test
    public void testGraph() {
        int[] inputs = {
                7, 9,
                1, 2,
                1, 3,
                1, 5,
                2, 5,
                2, 3,
                3, 4,
                4, 6,
                4, 7,
                6, 7
        };

        int v = inputs[0];
        int e = inputs[1];
        Graph g = new Graph(v, e);

        int j = 1;
        for (int i = 0; i < e; i++) {
            g.addEdge(inputs[++j], inputs[++j]);
        }

        g.breadthFirstSearch();

    }
}

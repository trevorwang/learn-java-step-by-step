package gradle.app;

import gradle.app.exercise10.EightNumberSolver;
import gradle.app.exercise10.Graph;
import org.junit.Test;

import static gradle.app.exercise10.Permutation.decode;
import static gradle.app.exercise10.Permutation.encode;
import static org.junit.Assert.assertEquals;

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

    @Test
    public void testPermutation() {
        for (int i = 0; i <= 119; i++) {
            decode(i, 5);
        }
        int value = 15;
        assertEquals(value, encode(decode(value, 5), 5));
    }

    @Test
    public void testEightNumberSolver() {
        int[] array = {6, 8, 7, 5, 4, 3, 2, 1, 0};
        for (int i = 0; i < array.length; i++) {
            array[i]++;    //数字加1方便进行编码
        }
        new EightNumberSolver().breadFirstSearch(array);
    }
}

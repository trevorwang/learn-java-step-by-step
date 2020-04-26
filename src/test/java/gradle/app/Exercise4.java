package gradle.app;

import gradle.app.exercise4.DoubleLinkList;
import gradle.app.exercise4.DoubleLinkNode;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class Exercise4 {

    @Test
    public void testDoubleLinkList() {
        Integer[] initArray = new Integer[]{1, 2, 3, 5, 6, 7, 8, 9, 10};
        DoubleLinkList list = new DoubleLinkList(initArray);
        assertTrue(Arrays.equals(initArray, list.getValueArray()));

        Integer[] resultArray = new Integer[]{1, 2, 3, 5, 6, 7, 8, 10};
        list = new DoubleLinkList(initArray);
        list.deleteNode(new DoubleLinkNode(9));
        assertTrue(list.tail.data == 10);
        assertTrue(Arrays.equals(resultArray, list.getValueArray()));

        resultArray = new Integer[]{1, 2, 3, 5, 6, 7, 8, 9};
        list = new DoubleLinkList(initArray);
        list.deleteNode(new DoubleLinkNode(10));
        assertTrue(list.tail.data == 9);
        assertTrue(Arrays.equals(resultArray, list.getValueArray()));

        resultArray = new Integer[]{2, 3, 5, 6, 7, 8, 9};
        list = new DoubleLinkList(initArray);
        list.deleteNode(new DoubleLinkNode(10));
        list.deleteNode(new DoubleLinkNode(1));
        assertTrue(list.tail.data == 9);
        assertTrue(list.head.data == 2);
        assertTrue(Arrays.equals(resultArray, list.getValueArray()));


        resultArray = new Integer[]{1, 2, 3, 5, 6, 7, 8, 9, 10, 11};
        list = new DoubleLinkList(initArray);
        list.insertNode(new DoubleLinkNode(10), new DoubleLinkNode(11));
        assertTrue(list.tail.data == 11);
        assertTrue(Arrays.equals(resultArray, list.getValueArray()));


        list = new DoubleLinkList(initArray);
        for (Integer integer : list.getValueArrayByDesc()) {
            System.out.println(integer);
        }
    }
}

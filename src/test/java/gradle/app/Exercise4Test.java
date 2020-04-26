package gradle.app;

import gradle.app.exercise4.DoubleLinkList;
import gradle.app.exercise4.DoubleLinkNode;
import gradle.app.exercise4.LinkList;
import gradle.app.exercise4.ListNode;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class Exercise4Test {

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

    @Test
    public void testLinkList() {
        int[] array = new int[]{Integer.MIN_VALUE, 4, 2, 1, 3, Integer.MIN_VALUE,};
        LinkList list = new LinkList(array);
        ListNode head = list.insertionSortList();
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

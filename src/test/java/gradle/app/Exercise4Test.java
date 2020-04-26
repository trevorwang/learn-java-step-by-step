package gradle.app;

import gradle.app.exercise4.*;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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

    @Test
    public void testAddTwoNumbers() {
        LinkList list1 = new LinkList(new int[]{1, 2, 3, 4, 8});
        LinkList list2 = new LinkList(new int[]{1, 2, 3, 4, 8});   ///24681
        ListNode result = Solution.addTwoNumbers(list1.head, list2.head);
        while (result != null) {
            result = result.next;
        }
    }

    @Test
    public void testRemoveNthFromEnd() {
        LinkList list2 = new LinkList(new int[]{1, 2, 3, 4, 8});
        ListNode result = Solution.removeNthFromEnd(list2.head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        list2 = new LinkList(new int[]{1, 2, 3, 4, 8});
        result = Solution.removeNthFromEnd(list2.head, 5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    @Test
    public void testQueuePerformance() {
        Deque<Integer> q = new LinkedList<>();
        long begin = System.currentTimeMillis();
        test(q);
        long end = System.currentTimeMillis();
        System.out.println("took " + (end - begin) + "ms");


        q = new ArrayDeque<>();
        begin = System.currentTimeMillis();
        test(q);
        end = System.currentTimeMillis();
        System.out.println("took " + (end - begin) + "ms");
    }

    private void test(Deque<Integer> q) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10_000; j++) {
                q.addLast(j);
            }

            for (int j = 0; j < 10_000; j++) {
                q.removeFirst();
            }
        }
    }
}

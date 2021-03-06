package gradle.app;

import gradle.app.exercise4.*;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static junit.framework.TestCase.assertFalse;
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

    @Test
    public void testReverseListNode() {
        LinkList list = new LinkList(new int[]{1, 2, 3, 4, 8});
        System.out.println(list.toString());
        System.out.println(list.reverse().toString());
    }

    @Test
    public void testReverseKGroupListNode() {
        LinkList list = new LinkList(new int[]{1, 2, 3, 4, 8});
        System.out.println(list.toString());
        System.out.println(list.reverseKGroup(2).toString());
        System.out.println();
        System.out.println(list.toString());
        System.out.println(list.reverseKGroup(3).toString());
        System.out.println();
        System.out.println(list.toString());
        System.out.println(list.reverseKGroup(4).toString());

    }

    @Test
    public void testRightRotate() {
        LinkList list = new LinkList(new int[]{1, 2, 3, 4, 5});
        System.out.println(list.toString());

        list.head = Solution.rightRotate(list.head, 2);
        System.out.println(list.toString());
    }

    @Test
    public void testHasCircle() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = Solution.initListNode(array, 3);
        assertTrue(Solution.hasCircle(head));

        head = Solution.initListNode(array, -1);
        assertFalse(Solution.hasCircle(head));


        head = Solution.initListNode(array, 6);
        assertTrue(Solution.hasCircle(head));


        head = Solution.initListNode(new int[]{1}, 0);
        assertTrue(Solution.hasCircle(head));

        head = Solution.initListNode(new int[]{}, -1);
        assertFalse(Solution.hasCircle(head));
    }

    @Test
    public void testMergeSortedLinkList() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ListNode l1 = Solution.initListNode(array, -1);
        ListNode l2 = Solution.initListNode(array, -1);
        LinkList linkList = new LinkList(array);
        linkList.head = Solution.mergeTowLinkListByLoop(l1, l2);
        System.out.println(linkList.toString());
    }
}

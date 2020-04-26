package gradle.app.exercise4;

public class LinkList {
    ListNode head;

    public LinkList(int[] array) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        for (int value : array) {
            ListNode node = new ListNode(value);
            tmp.next = node;
            tmp = node;
        }
        head = dummy.next;
    }

    public ListNode insertionSortList() {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode tail = dummy;
        while (cur != null) {
            if (tail.val <= cur.val) {
                tail.next = cur;
                tail = cur;
                cur = cur.next;
            } else {
                ListNode next = cur.next;
                while (pre.next != null && pre.next.val < cur.val)
                    pre = pre.next;
                cur.next = pre.next;
                pre.next = cur;
                tail.next = next;
                pre = dummy;
                cur = next;
            }
        }
        return dummy.next;
    }
}

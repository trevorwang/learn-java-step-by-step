package gradle.app.exercise4;

public class Solution {

    public static ListNode mergeTowLinkList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTowLinkList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTowLinkList(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTowLinkListByLoop(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            ListNode q;
            if (l1.val < l2.val) {
                q = l1;
                l1 = l1.next;
            } else {
                q = l2;
                l2 = l2.next;
            }
            q.next = null;
            p.next = q;
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int val = v1 + v2 + carry;
            ListNode node = new ListNode(val % 10);
            carry = val > 10 ? 1 : 0;
            cur.next = node;
            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        int i = 0;
        while (i <= n) {
            first = first.next;
            i++;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {   // find small list per k
                end = end.next;
            }
            if (end == null) break;   // < k, don't reverse
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode rightRotate(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        int carry = k % len;
        if (carry == 0) return head;

        ListNode pre = head;
        for (int i = 0; i < len - carry - 1; i++) {
            pre = pre.next;
        }
        tail.next = head;
        ListNode res = pre.next;
        pre.next = null;
        return res;
    }

    public static boolean hasCircle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast != null && fast.next != null && slow != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//
//            if (slow == fast) return true;
//        }
//        return false;

        ListNode fast = head, slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static ListNode initListNode(int[] array, int circlePos) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        for (int value : array) {
            ListNode node = new ListNode(value);
            tmp.next = node;
            tmp = node;
        }

        ListNode pos = dummy.next;
        if (circlePos >= 0 && array.length > circlePos) {
            for (int i = 0; i < circlePos; i++) {
                pos = pos.next;
            }
            ListNode tail = pos;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = pos;
        }
        return dummy.next;
    }
}

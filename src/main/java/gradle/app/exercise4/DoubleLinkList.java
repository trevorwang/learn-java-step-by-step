package gradle.app.exercise4;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkList {
    public DoubleLinkNode head;
    public DoubleLinkNode tail;


    public DoubleLinkList(Integer[] list) {
        if (list == null) {
            this.head = null;
            this.tail = null;
            return;
        }

        DoubleLinkNode prev = null;
        for (int i = 0; i < list.length; i++) {
            DoubleLinkNode node = new DoubleLinkNode(list[i]);
            if (i == 0) {
                head = node;
            }
            if (i == list.length - 1) {
                tail = node;
            }
            if (prev != null) {
                prev.next = node;
                node.prev = prev;
            }
            prev = node;
        }
    }


    // 查询第 index 项的内容
    public DoubleLinkNode queryNode(int index) {
        DoubleLinkNode dummy = head;
        int flag = 0;
        while (flag <= index) {
            dummy = dummy.next;
            flag++;
        }
        return dummy;
    }

    // 将 toBeDelete 从链表中删除
    public void deleteNode(DoubleLinkNode toBeDelete) {
        DoubleLinkNode dummy = head;
        while (dummy != null) {
            if (dummy.data == toBeDelete.data) {
                DoubleLinkNode next = dummy.next;
                DoubleLinkNode prev = dummy.prev;
                if (prev != null) {
                    prev.next = dummy.next;
                } else {
                    head = dummy.next;
                }
                if (next != null) {
                    next.prev = dummy.prev;
                } else {
                    tail = prev;
                }
                return;
            }
            dummy = dummy.next;
        }
    }

    // 将toBeInsert插入到pos结点后面
    public void insertNode(DoubleLinkNode pos, DoubleLinkNode toBeInsert) {
        DoubleLinkNode dummy = head;
        while (dummy != null) {
            if (dummy.data == pos.data) {
                DoubleLinkNode next = dummy.next;
                toBeInsert.next = next;
                if (next != null) {
                    next.prev = toBeInsert;
                } else {
                    tail = toBeInsert;
                }
                toBeInsert.prev = dummy;
                dummy.next = toBeInsert;
            }
            dummy = dummy.next;
        }
    }

    public Integer[] getValueArray() {
        List<Integer> array = new ArrayList<>();
        DoubleLinkNode dummy = head;
        while (dummy != null) {
            array.add(dummy.data);
            dummy = dummy.next;
        }
        return array.toArray(it -> new Integer[0]);
    }

    public Integer[] getValueArrayByDesc() {
        List<Integer> array = new ArrayList<>();
        DoubleLinkNode dummy = tail;
        while (dummy != null) {
            array.add(dummy.data);
            dummy = dummy.prev;
        }
        return array.toArray(it -> new Integer[0]);
    }
}

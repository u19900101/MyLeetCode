package leetcode._02_链表;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author pppppp
 * @date 2022/1/20 23:09
 */
public class _142_环形链表_II {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode t = head;
        while (t != null) {
            boolean add = hashSet.add(t);
            if (!add) {
                return t;
            }
            t = t.next;
        }
        return null;
    }


    @Test
    public void T_() {
        ListNode node = new ListNode(1, new ListNode(2));
        ListNode node1 = detectCycle2(node);
    }

    /*快慢指针 a*/
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while (f != null && s != null) {
            s = s.next;
            f = f.next;
            if (f != null) {
                f = f.next;
            } else {
                return null;
            }
            if (f == s) {
                ListNode a = head;
                while (a != f) {
                    a = a.next;
                    f = f.next;
                }
                return a;
            }
        }
        return null;
    }

}

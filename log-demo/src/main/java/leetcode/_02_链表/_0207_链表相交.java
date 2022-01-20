package leetcode._02_链表;

import org.junit.Test;

import static leetcode._02_链表._203_移除链表元素.arrayToLinkList;

/**
 * @author pppppp
 * @date 2022/1/20 22:19
 */
public class _0207_链表相交 {
    @Test
    public void T_() {
        int[][] nums = {{4, 1, 8, 4, 5}, {}, {7, 7, 7, 7}, {1, 2}};
        int[][] nums2 = {{5, 0, 1, 8, 4, 5}};
        int[] res = {8};

        for (int i = 0; i < nums.length; i++) {
            /*构造链表*/
            ListNode headA = arrayToLinkList(nums[i]);
            ListNode headB = arrayToLinkList(nums2[i]);
            ListNode node = getIntersectionNode(headA, headB);
            System.out.println(node.val == res[i]);
        }
    }

    /*交替遍历两个链表
    1.如果要有公共的部分则
     一定有 lenA - skipA = lenB - skipB ,所以两者同时走 lenA + skipB步后便一定会相遇
     2.两者无公共部分 当走到第 lenA + lenB 时，两者同时走到了各自的链表尾部 均为 null，循环退出
     */
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*同步两个链表长度*/
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode tA = headA;
        ListNode tB = headB;
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            if (lenA > lenB) {
                tA = tA.next;
            } else {
                tB = tB.next;
            }
        }
        while (tA != null) {
            if (tA == tB) {
                return tA;
            }
            tA = tA.next;
            tB = tB.next;
        }
        return null;
    }

    private int getLen(ListNode headA) {
        int len = 0;
        ListNode t = headA;
        while (t != null) {
            t = t.next;
            len++;
        }
        return len;
    }
}

package leetcode._02_链表;

import org.junit.Test;

import static leetcode._02_链表._203_移除链表元素.arrayToLinkList;

/**
 * @author pppppp
 * @date 2022/1/20 15:09
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 */
public class _24_两两交换链表中的节点 {
    @Test
    public void T_() {
        int[][] nums = {{1, 2, 3, 4}, {}, {1}};
        int[][] res = {{2, 1, 4, 3}, {}, {1}};
        for (int i = 0; i < nums.length; i++) {
            /*构造链表*/
            ListNode head = arrayToLinkList(nums[i]);
            ListNode node = swapPairs2(head);
            /*遍历链表*/
            int j = 0;
            while (node != null) {
                System.out.println(node.val == res[i][j++]);
                node = node.next;
            }
        }
    }

    /*改进版 添加虚拟头节点*/
    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head == null ? null : head;
        }
        /*保留头节点*/
        ListNode dummy = new ListNode(0,head);
        ListNode l = dummy;
        ListNode cur = dummy.next;
        while (cur != null && cur.next != null) {
            ListNode r = cur.next;
            cur.next = cur.next.next;
            r.next = cur;
            l.next = r;
            cur = cur.next;
            l = l.next.next;
        }
        return dummy.next;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head == null ? null : head;
        }
        /*保留头节点*/
        ListNode next = head.next;
        head.next = head.next.next;
        next.next = head;
        head = next;
        if( head.next != null && head.next.next != null){
            ListNode cur = head.next.next;
            ListNode l = head.next;
            while (cur != null && cur.next != null) {
                ListNode r = cur.next;
                cur.next = cur.next.next;
                r.next = cur;
                l.next = r;
                cur = cur.next;
                l = l.next.next;
            }
        }
        return head;
    }
}

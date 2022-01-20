package leetcode._02_链表;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

import static leetcode._02_链表._203_移除链表元素.arrayToLinkList;

/**
 * @author pppppp
 * @date 2022/1/20 20:14
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class _19_删除链表的倒数第N个结点 {
    @Test
    public void T_() {
        int[][] nums = {{1, 2, 3, 4, 5}, {1}, {1, 2},{1, 2}};
        int[] nums2 = {2, 1, 1,2};
        int[][] res = {{1, 2, 3, 5}, {}, {1},{2}};
        for (int i = 0; i < nums.length; i++) {
            /*构造链表*/
            ListNode head = arrayToLinkList(nums[i]);
            ListNode node = removeNthFromEnd3(head, nums2[i]);
            /*遍历链表*/
            int j = 0;
            while (node != null) {
                System.out.println(node.val == res[i][j++]);
                node = node.next;
            }
        }
    }
    /*双指针法*/
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode f = dummy;
        ListNode s = head;
        /*根据最后的目标状态 判断s指针要往前走的步数*/
        for (int i = 0; i < n - 1; i++) {
            s = s.next;
        }
        while (s.next !=null){
            f = f.next;
            s = s.next;
        }
        f.next = f.next.next;
        return dummy.next;
    }
    /*使用栈解决 不计算len也不用二次定位*/
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0,head);
        ListNode t = dummy;
        while (t != null){
            stack.push(t);
            t = t.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pop = stack.pop();
        pop.next = pop.next.next;
        return dummy.next;
    }

    /*个人的解法 求长度 找index*/
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /*获取len*/
        ListNode t = head;
        ListNode dummy = new ListNode(0,head);
        int len = 0;
        while (t != null) {
            len++;
            t = t.next;
        }
        int index = len - n;
        if(index < 0 || index >= len){
            return null;
        }
        int i = 0;
        t = dummy;
        while (i < index) {
            i++;
            t = t.next;
        }
        t.next = t.next.next;
        return dummy.next;
    }
}

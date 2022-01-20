package leetcode._02_链表;

import org.junit.Test;

import static leetcode._02_链表._203_移除链表元素.arrayToLinkList;

/**
 * @author pppppp
 * @date 2022/1/20 10:41
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class _206_反转链表 {
    @Test
    public void T_(){
        int[][] nums = {{1, 2, 6, 3, 4, 5, 6}, {}, {7, 7, 7, 7},{1,2}};
        int[] nums2 = {6, 1, 7,2};
        int[][] res = {{1, 2, 3, 4, 5}, {}, {},{1}};

        for (int i = 0; i <nums.length; i++) {
            /*构造链表*/
            ListNode head = arrayToLinkList(nums[i]);
            ListNode node = reverseList2(head);
            /*遍历链表*/
            int j = nums[i].length-1;
            while (node != null){
                System.out.println(node.val == nums[i][j--]);
                node = node.next;
            }
        }
    }

    /*自己的解法*/
    public static ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        while (head != null){
            /*创建一个新node*/
            ListNode newHead = new ListNode(head.val);
            newHead.next = reverse;
            reverse = newHead;
            head = head.next;
        }
        return reverse;
    }

    /*反转相邻的两个节点直到结尾*/
    public static ListNode reverseList2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = new ListNode(head.val);
        ListNode pre = head.next;
        while (pre != null){
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }
}

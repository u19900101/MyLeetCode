package leetcode._02_链表;

import org.junit.Test;

/**
 * @author pppppp
 * @date 2022/1/20 8:44
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class _203_移除链表元素 {
    public static void main(String[] args) {

    }

    @Test
    public void T_(){
        int[][] nums = {{1, 2, 6, 3, 4, 5, 6}, {}, {7, 7, 7, 7},{1,2}};
        int[] nums2 = {6, 1, 7,2};
        int[][] res = {{1, 2, 3, 4, 5}, {}, {},{1}};

        for (int i = 0; i <nums.length; i++) {
            /*构造链表*/
            ListNode head = arrayToLinkList(nums[i]);
            ListNode node = removeElements(head, nums2[i]);
            /*遍历链表*/
            int j = 0;
            while (node != null){
                System.out.println(node.val == res[i][j++]);
                node = node.next;
            }
        }
    }

    /*官方题解 更简单*/
    public static ListNode removeElements2(ListNode head, int val) {
        /*构造一个头节点*/
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        /*始终判断下一个节点是否要跳过还是要更新为当前节点*/
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
    public static ListNode removeElements(ListNode head, int val) {

        /*确定头节点的位置*/
        while (head != null && head.val==val){
            head = head.next;
        }
        if(head == null){
            return null;
        }
        ListNode pNode = head;
        ListNode cNode = pNode.next;
        while (cNode != null){
            if(cNode.val == val){
                pNode.next = cNode.next;
            }else {
                pNode = cNode;
            }
            cNode = cNode.next;
        }
        return head;
    }
    
    public static ListNode arrayToLinkList(int[] num) {
        if(num.length == 0){
            return null;
        }


        ListNode head = new ListNode(0);
        ListNode dummy = head;
        int index = 0;
        while (index < num.length ){
            dummy.next = new ListNode(num[index++]);
            dummy = dummy.next;
        }
        return head.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


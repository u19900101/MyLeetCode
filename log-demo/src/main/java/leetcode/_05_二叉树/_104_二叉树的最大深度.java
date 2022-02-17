package leetcode._05_二叉树;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/2/17 14:12
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class _104_二叉树的最大深度 {

    @Test
    public void T_() {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = Util.arrToTree(arr);
        int i = maxDepth3(treeNode);
        System.out.println(i);
    }

    /*自己的题解*/
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> oldQueue = new LinkedList<>();
        Queue<TreeNode> newQueue = new LinkedList<>();
        int maxDepth = 0;
        oldQueue.offer(root);
        newQueue.offer(root);
        while (!newQueue.isEmpty()) {
            newQueue.clear();
            while (!oldQueue.isEmpty()) {
                TreeNode poll = oldQueue.poll();

                if (poll.left != null) {
                    newQueue.offer(poll.left);
                }
                if (poll.right != null) {
                    newQueue.offer(poll.right);
                }
            }
            maxDepth++;
            oldQueue.addAll(newQueue);
        }
        return maxDepth;
    }

    /*官方题解 递归 深度优先*/
    public static int maxDepth2(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth2(root.left) +1, maxDepth2(root.right) + 1);
    }

    /*官方题解 队列 广度优先 自己方法的一个优化*/
    public static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        int maxDepth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0 ) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            maxDepth++;
        }
        return maxDepth;
    }
}

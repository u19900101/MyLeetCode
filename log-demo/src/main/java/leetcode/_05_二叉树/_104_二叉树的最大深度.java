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
        int i = maxDepth(treeNode);

    }

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
}

package leetcode._05_二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/2/17 15:49
 */
public class _111_二叉树的最小深度 {
    /*递归+多重判断*/
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int lMin = minDepth(root.left);
        int rMin = minDepth(root.right);
        return 1 + Math.min(lMin, rMin);
    }

    /*层序遍历*/
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int minDepth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0){
                TreeNode p = q.poll();
                if(p.left == null && p.right == null){
                    return minDepth;
                }
                if(p.left != null){
                    q.offer(p.left);
                }
                if(p.right != null){
                    q.offer(p.right);
                }
                size--;
            }
            minDepth++;
        }
        return minDepth;
    }
}

package leetcode._05_二叉树;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/2/7 10:38
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class _101_对称二叉树 {

    @Test
    public void T_() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(3, new TreeNode(4), new TreeNode(2)), new TreeNode(3, new TreeNode(2), new TreeNode(4)));
        System.out.println(isSymmetric2(treeNode));
    }


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    /*使用队列求解*/
    public boolean isSymmetric2(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

}

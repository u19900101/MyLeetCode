package leetcode._05_二叉树;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author pppppp
 * @date 2022/2/16 11:41
 */
public class _100_相同的树 {

    @Test
    public void T_3() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(p, q));

    }

    /*使用队列层序遍历*/
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode p1 = queue.poll();
            TreeNode p2 = queue.poll();
            if (p1 == null && p2 == null) {
                continue;
            }
            if (p1 == null || p2 == null || p1.val != p2.val) {
                return false;
            }
            queue.offer(p1.left);
            queue.offer(p2.left);
            queue.offer(p1.right);
            queue.offer(p2.right);
        }
        return true;
    }

    /*官方递归题解*/
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree2(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*使用栈遍历一棵二叉树*/
    @Test
    public void T_() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = new TreeNode(1, new TreeNode(3, new TreeNode(4), new TreeNode(2)), new TreeNode(3, new TreeNode(2), new TreeNode(4)));
        // stack.push(p);
        while (!stack.isEmpty() || p != null) {
            if (p == null) {
                p = stack.pop();
                System.out.println(p.val);
                p = p.right;
            } else {
                stack.push(p);
                p = p.left;
            }
        }
    }

    /*使用队列进行层序遍历树*/
    @Test
    public void T_2() {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = new TreeNode(1, new TreeNode(3, new TreeNode(4), new TreeNode(2)), new TreeNode(3, new TreeNode(2), new TreeNode(4)));
        queue.offer(p);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            System.out.println(pop.val);
            if (pop.left != null) {
                queue.offer(pop.left);
            }

            if (pop.right != null) {
                queue.offer(pop.right);
            }
        }
    }
}

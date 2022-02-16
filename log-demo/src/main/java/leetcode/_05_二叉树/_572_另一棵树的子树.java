package leetcode._05_二叉树;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pppppp
 * @date 2022/2/16 15:37
 * 40min
 *
 */
public class _572_另一棵树的子树 {

    @Test
    public void T_1(){
        // TreeNode p = new TreeNode(3, new TreeNode(4,new TreeNode(1),new TreeNode(2)), new TreeNode(5));

        // TreeNode p = new TreeNode(3, new TreeNode(4,new TreeNode(1),new TreeNode(2,new TreeNode(0),null)), new TreeNode(5));
        // TreeNode q = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        TreeNode p = new TreeNode(3, new TreeNode(4,new TreeNode(1),null), new TreeNode(5,new TreeNode(2),null));
        TreeNode q = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        System.out.println(isSubtree2(p, q));
    }

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }

        if(root == null || subRoot == null){
            return false;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.val == subRoot.val){
                if(isSubtree2(poll.left,subRoot.left) && isSubtree2(poll.right,subRoot.right)){
                    return true;
                }
            }
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }

        if(root == null || subRoot == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.val == subRoot.val){
                if(isSametree(poll,subRoot)){
                    return true;
                }
            }
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
        return false;
    }

    public boolean isSametree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode poll2 = queue.poll();
            if(poll == null && poll2 == null){
                continue;
            }
            if(poll == null || poll2 == null){
                return false;
            }
            if(poll.val != poll2.val){
                return false;
            }
            queue.offer(poll.left);
            queue.offer(poll2.left);
            queue.offer(poll.right);
            queue.offer(poll2.right);
        }
        return true;
    }

    /*官方题解*/
    public boolean isSubtreeGF(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

}

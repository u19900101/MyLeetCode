package leetcode._05_二叉树;

import org.junit.Test;

/**
 * @author pppppp
 * @date 2022/2/18 9:56
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class _110_平衡二叉树 {
    @Test
    public void T_(){
        // Integer [] nums = {3,9,20,null,null,15,7};
        Integer [] nums = {1,2,2,3,3,null,null,4,4};
        TreeNode root = Util.arrToTree(nums);
        System.out.println(isBalanced(root));
    }

    /*自顶向下  递归平衡 + 递归树高*/
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        int l = getLevel(root.left);
        int r = getLevel(root.right);
        if(Math.abs(l-r) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getLevel(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(getLevel(root.left),getLevel(root.right)) + 1;
    }

    /*官方题解  自底向上*/
    public boolean isBalancedGF(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight == -1 ) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
